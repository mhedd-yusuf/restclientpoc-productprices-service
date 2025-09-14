package com.example.restclientpocproductpricesservice.controller;

import com.example.restclientpocproductpricesservice.api.request.PriceRequest;
import com.example.restclientpocproductpricesservice.api.response.PriceResponse;
import com.example.restclientpocproductpricesservice.common.api.ApiResponse;
import com.example.restclientpocproductpricesservice.service.ProductPriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class ProductPriceController {
    private final ProductPriceService productPriceService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PriceResponse>>> getPrices(@PageableDefault(
            direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.<List<PriceResponse>>builder()
                        .data(productPriceService.listPrices(pageable))
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<PriceResponse>> getPrice(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.<PriceResponse>builder()
                        .data(productPriceService.findPrice(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PriceResponse>> createPrice(@Valid @RequestBody PriceRequest priceRequest) {
        PriceResponse priceResponse = productPriceService.createPrice(priceRequest);
        return ResponseEntity.created(URI.create("/prices/" + priceResponse.getId()))
                .body(ApiResponse.<PriceResponse>builder()
                        .data(priceResponse)
                        .build());
    }

}
