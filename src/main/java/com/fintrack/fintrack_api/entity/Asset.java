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

    @NotNull(message = "balance cannot be null")
    @PositiveOrZero(message = "Balance must be zero or positive")
    private Double balance;
}