package com.example.restclientpocproductpricesservice.api.request;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false)
    private BigDecimal amount;

    @NotBlank
    @Size(min = 3, max = 8)
    private String currency;

    @NotBlank
    @Size(max = 16)
    private String priceType;
}
