package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.dto.PortfolioSummary;
import com.fintrack.fintrack_api.entity.Asset;
import com.fintrack.fintrack_api.entity.User;
import com.fintrack.fintrack_api.exception.ResourceNotFoundException;
import com.fintrack.fintrack_api.exception.UnauthorizedAccessException;
import com.fintrack.fintrack_api.repository.AssetRepository;
import com.fintrack.fintrack_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Handles the Dependency Injection of the Repository
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    @Override
    public Asset saveAssetForUser(long userId, Asset asset) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        asset.setUser(user);
        return assetRepository.save(asset);
    }

    @Override
    public List<Asset> getAssetsByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return assetRepository.findByUserId(userId);
    }

    @Override
    public PortfolioSummary getSummary(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        List<Asset> assets = assetRepository.findByUserId(userId);

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

    @Override
    public void deleteAsset(Long userId,Long assetId) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id " + assetId));
        if (!asset.getUser().getId().equals(userId)){
            throw new UnauthorizedAccessException("Unauthorized: Asset does not belong to this user");
        }
        assetRepository.delete(asset);
    }
}
