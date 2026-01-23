package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.entity.Asset;
import com.fintrack.fintrack_api.exception.ResourceNotFoundException;
import com.fintrack.fintrack_api.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        existingAsset.setBalance(assetDetails.getBalance());
        return assetRepository.save(existingAsset);
    }

    @Override
    public void deleteById(Long id) {
        if (!assetRepository.existsById(id)){
            throw new ResourceNotFoundException("Cannot delete. Asset not found with id: " + id);
        }
        assetRepository.deleteById(id);
    }
}
