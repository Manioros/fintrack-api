package com.fintrack.fintrack_api.controller;

import com.fintrack.fintrack_api.entity.Asset;
import com.fintrack.fintrack_api.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping
    public List<Asset> getAllAssets(){
        return assetService.findAll();
    }

    @PostMapping
    public Asset createAsset(@RequestBody Asset asset){
        return assetService.save(asset);
    }
}
