package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.ProductRequestDto;
import dev.gihan.e_commerce.api.model.Product;
import dev.gihan.e_commerce.api.repository.ProductRepository;
import dev.gihan.e_commerce.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public void create(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setImageUrl(productRequestDto.getImageUrl());
        productRepository.save(product);
    }

}
