package com.example.restclientpocproductpricesservice.api.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {
    
    @NotNull
    @Positive
    private Long id;

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
