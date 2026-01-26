package com.fintrack.fintrack_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Ticker is mandatory")
    @Size(min = 2, max = 10, message= "Ticker must be between 2 and 10 characters")
    @Column(nullable = false, unique = true)
    private String ticker;

    @NotBlank(message = "Asset type is mandatory")
    private String assetType;

    @NotNull(message = "Quantity is mandatory")
    @PositiveOrZero(message = "Quantity must be zero or positive")
    private Double quantity;

    @NotNull(message = "Current price is mandatory")
    @PositiveOrZero(message = "Current price must be zero or positive")
    private Double currentPrice;

    public Double getCalculatedValue() {
        return (quantity != null && currentPrice != null ? quantity * currentPrice  : 0.0);
    }
}