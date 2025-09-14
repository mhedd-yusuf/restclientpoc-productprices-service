package com.example.restclientpocproductpricesservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "price")
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, length = 8)
    private String currency;

    @Column(name = "price_type", nullable = false, length = 16)
    private String priceType;
}
