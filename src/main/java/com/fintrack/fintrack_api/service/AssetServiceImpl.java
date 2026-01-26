package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.dto.PortfolioSummary;
import com.fintrack.fintrack_api.entity.Asset;
import com.fintrack.fintrack_api.exception.ResourceNotFoundException;
import com.fintrack.fintrack_api.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Handles the Dependency Injection of the Repository
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;
    @Override
    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    @Override
    public Asset save(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public Asset findById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + id));
    }

    @Override
    public Asset update(Long id, Asset assetDetails) {
        Asset existingAsset = findById((id));
        existingAsset.setName(assetDetails.getName());
        existingAsset.setTicker(assetDetails.getTicker());
        existingAsset.setAssetType(assetDetails.getAssetType());
        existingAsset.setQuantity(assetDetails.getQuantity());
        existingAsset.setCurrentPrice(assetDetails.getCurrentPrice());
        return assetRepository.save(existingAsset);
    }

    @Override
    public void deleteById(Long id) {
        if (!assetRepository.existsById(id)){
            throw new ResourceNotFoundException("Cannot delete. Asset not found with id: " + id);
        }
        assetRepository.deleteById(id);
    }

    public PortfolioSummary getSummary() {
        List<Asset> assets = assetRepository.findAll();

        double totalValue = assets.stream()
                .mapToDouble(asset -> asset.getQuantity() * asset.getCurrentPrice())
                .sum();
        Map<String, Double> distribution = assets.stream()
                .collect(Collectors.groupingBy(
                        Asset::getAssetType,
                        Collectors.summingDouble(asset -> asset.getQuantity() * asset.getCurrentPrice())
                ));
        return new PortfolioSummary(totalValue, distribution);
    }
}
