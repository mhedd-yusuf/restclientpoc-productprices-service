package com.example.restclientpocproductpricesservice.service;

import com.example.restclientpocproductpricesservice.api.request.PriceRequest;
import com.example.restclientpocproductpricesservice.api.response.PriceResponse;
import com.example.restclientpocproductpricesservice.common.PageableSanitizer;
import com.example.restclientpocproductpricesservice.domain.ProductPrice;
import com.example.restclientpocproductpricesservice.exception.NotFoundException;
import com.example.restclientpocproductpricesservice.mapper.ToPriceResponse;
import com.example.restclientpocproductpricesservice.repository.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;
    private final ToPriceResponse toPriceResponse;
    private final PageableSanitizer pageableSanitizer;


    public List<PriceResponse> listPrices(final Pageable pageable) {
        Pageable sanitizedPage = pageableSanitizer.apply(pageable);
        Page<ProductPrice> productPrices = productPriceRepository.findAll(sanitizedPage);
        return productPrices
                .stream()
                .map(toPriceResponse)
                .toList();
    }

    public PriceResponse findPrice(final Long id) {
        return productPriceRepository.findById(id)
                .map(toPriceResponse)
                .orElseThrow(() -> new NotFoundException("Price with id " + id + " not found"));
    }

    @Transactional
    public PriceResponse createPrice(final PriceRequest priceRequest) {
        ProductPrice productPrice = ProductPrice
                .builder()
                .amount(priceRequest.getAmount())
                .priceType(priceRequest.getPriceType())
                .currency(priceRequest.getCurrency())
                .build();
        ProductPrice saved = productPriceRepository.save(productPrice);
        return toPriceResponse.apply(saved);
    }

}
