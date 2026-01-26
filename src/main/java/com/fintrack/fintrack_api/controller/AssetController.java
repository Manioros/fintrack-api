package com.fintrack.fintrack_api.controller;

import com.fintrack.fintrack_api.dto.PortfolioSummary;
import com.fintrack.fintrack_api.entity.Asset;
import com.fintrack.fintrack_api.service.AssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public Asset createAsset(@Valid @RequestBody Asset asset){
        return assetService.save(asset);
    }

    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id){
        return assetService.findById(id);
    }

    @PutMapping("/{id}")
    public Asset updateAsset(@PathVariable Long id, @Valid @RequestBody Asset asset){
        return assetService.update(id, asset);
    }

    @DeleteMapping("/{id}")
    public void deleteAsset(@PathVariable Long id){
        assetService.deleteById(id);
    }

    @GetMapping("/summary")
    public ResponseEntity<PortfolioSummary> getSummary() {
        return ResponseEntity.ok(assetService.getSummary());
    }
}
