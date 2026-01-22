package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.entity.Asset;
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
}
