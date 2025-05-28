package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.ProductRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.ProductResponseDto;
import dev.gihan.e_commerce.api.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto dto, String sellerUsername);
    List<ProductResponseDto> getAllProducts();
    List<ProductResponseDto> getSellerProducts(String sellerUsername);
    ProductResponseDto getProductById(Long id) throws ProductNotFoundException;
    void deleteProduct(Long id, String sellerUsername) throws ProductNotFoundException;
}

