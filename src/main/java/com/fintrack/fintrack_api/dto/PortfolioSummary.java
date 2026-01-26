package com.fintrack.fintrack_api.dto;

import java.util.Map;

public record PortfolioSummary(Double totalValue, Map<String, Double> distributionByAssetType) {
}
