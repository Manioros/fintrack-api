package com.fintrack.fintrack_api.service;

import com.fintrack.fintrack_api.entity.Asset;

import java.util.List;

public interface AssetService {
    List<Asset> findAll();
    Asset save(Asset asset);
}
