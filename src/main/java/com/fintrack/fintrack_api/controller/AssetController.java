package com.fintrack.fintrack_api.controller;

import com.fintrack.fintrack_api.dto.PortfolioSummary;
import com.fintrack.fintrack_api.entity.Asset;
import com.fintrack.fintrack_api.service.AssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @PostMapping
    public ResponseEntity<Asset> addAsset(@PathVariable Long userId, @Valid @RequestBody Asset asset){
        return ResponseEntity.status(HttpStatus.CREATED).body(assetService.saveAssetForUser(userId, asset));
    }

    @GetMapping
    public List<Asset> getAssetByUser(@PathVariable Long userId){
        return assetService.getAssetsByUserId(userId);
    }

    @GetMapping("/summary")
    public ResponseEntity<PortfolioSummary> getSummary(@PathVariable Long userId){
        return ResponseEntity.ok(assetService.getSummary(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long userId, @PathVariable Long id){
        assetService.deleteAsset(userId, id);
        return ResponseEntity.noContent().build();
    }
}