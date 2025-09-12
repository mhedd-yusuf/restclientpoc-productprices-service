package com.example.restclientpocproductpricesservice.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponse {

    private Long id;

    private BigDecimal amount;

    private String currency;

    private String priceType;
}
