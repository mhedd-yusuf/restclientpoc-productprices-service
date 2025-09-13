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

    //    @GetMapping
//    public ResponseEntity<ApiResponse<List<PriceResponse>>> getPrices() {
//        return ResponseEntity.ok(
//                ApiResponse.<List<PriceResponse>>builder()
//                        .data(productPriceService.getPrices())
//                        .build()
//        );
//    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<PriceResponse>>> getPrices(@PageableDefault(
            direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.<List<PriceResponse>>builder()
                        .data(productPriceService.getPrices(pageable))
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<PriceResponse>> getPrice(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.<PriceResponse>builder()
                        .data(productPriceService.getPrice(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PriceResponse>> createPrice(@Valid @RequestBody PriceRequest priceRequest) {
        return ResponseEntity.created(URI.create("/prices/" + priceRequest.getId()))
                .body(ApiResponse.<PriceResponse>builder()
                        .data(productPriceService.createPrice(priceRequest))
                        .build());
    }

}
