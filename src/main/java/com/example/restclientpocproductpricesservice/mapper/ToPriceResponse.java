package com.example.restclientpocproductpricesservice.mapper;

import com.example.restclientpocproductpricesservice.api.response.PriceResponse;
import com.example.restclientpocproductpricesservice.domain.ProductPrice;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ToPriceResponse implements Function<ProductPrice, PriceResponse> {

    @Override
    public PriceResponse apply(ProductPrice productPrice) {
        return PriceResponse
                .builder()
                .id(productPrice.getId())
                .priceType(productPrice.getPriceType())
                .currency(productPrice.getCurrency())
                .build();
    }
}
