package com.example.restclientpocproductpricesservice.service;

import com.example.restclientpocproductpricesservice.api.response.PriceResponse;
import com.example.restclientpocproductpricesservice.mapper.ToPriceResponse;
import com.example.restclientpocproductpricesservice.repository.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;
    private final ToPriceResponse toPriceResponse;

    public List<PriceResponse> getPrices() {
        return productPriceRepository.findAll()
                .stream()
                .map(toPriceResponse)
                .collect(Collectors.toList());
    }
}
