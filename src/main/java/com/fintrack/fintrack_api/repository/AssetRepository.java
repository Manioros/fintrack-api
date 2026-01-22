package com.fintrack.fintrack_api.repository;

import com.fintrack.fintrack_api.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    // No code needed for basic CRUD.
}