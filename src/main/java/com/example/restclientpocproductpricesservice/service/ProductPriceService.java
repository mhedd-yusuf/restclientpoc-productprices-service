package com.example.restclientpocproductpricesservice.service;

import com.example.restclientpocproductpricesservice.api.response.PriceResponse;
import com.example.restclientpocproductpricesservice.common.PageableSanitizer;
import com.example.restclientpocproductpricesservice.domain.ProductPrice;
import com.example.restclientpocproductpricesservice.mapper.ToPriceResponse;
import com.example.restclientpocproductpricesservice.repository.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;
    private final ToPriceResponse toPriceResponse;
    private final PageableSanitizer pageableSanitizer;

//    public List<PriceResponse> getPrices() {
//        return productPriceRepository.findAll()
//                .stream()
//                .map(toPriceResponse)
//                .collect(Collectors.toList());
//    }

    public List<PriceResponse> getPrices(final Pageable pageable) {
        Pageable sanitizedPage = pageableSanitizer.apply(pageable);
        Page<ProductPrice> productPrices = productPriceRepository.findAll(sanitizedPage);
        return productPrices
                .stream()
                .map(toPriceResponse)
                .toList();
    }
}
