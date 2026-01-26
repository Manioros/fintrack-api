package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.dto.PortfolioSummary;
import com.fintrack.fintrack_api.entity.Asset;

import java.util.List;

public interface AssetService {
    List<Asset> findAll();
    Asset save(Asset asset);
    Asset findById(Long id);
    Asset update(Long id, Asset asset);
    void deleteById(Long id);
    PortfolioSummary getSummary();
}
