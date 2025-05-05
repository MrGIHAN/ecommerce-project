package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.ProductRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.ProductResponseDto;
import dev.gihan.e_commerce.api.model.Product;

import java.util.List;

public interface ProductService {

    void create (ProductRequestDto productRequestDto);
    void update (Long id, ProductRequestDto productRequestDto);
    void delete (Long id);
    ProductResponseDto getById (Long id);
    List<ProductResponseDto> getAll ();


}
