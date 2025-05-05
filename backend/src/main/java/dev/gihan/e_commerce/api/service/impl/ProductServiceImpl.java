package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.ProductRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.ProductResponseDto;
import dev.gihan.e_commerce.api.model.Product;
import dev.gihan.e_commerce.api.repository.ProductRepository;
import dev.gihan.e_commerce.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;

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

    @Override
    public void update(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new ProviderNotFoundException("Product Not Found" + id)
        );
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setImageUrl(productRequestDto.getImageUrl());
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProviderNotFoundException("Product Not Found " + id)
        );
        return new ProductResponseDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl()
        );
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponseDto(
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImageUrl()))
                .toList();
    }

}