package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.dto.PortfolioSummary;
import com.fintrack.fintrack_api.entity.Asset;

import java.util.List;

public interface AssetService {
    Asset saveAssetForUser(long userId, Asset asset);
    List<Asset> getAssetsByUserId(Long userId);
    PortfolioSummary getSummary(Long userId);
}
