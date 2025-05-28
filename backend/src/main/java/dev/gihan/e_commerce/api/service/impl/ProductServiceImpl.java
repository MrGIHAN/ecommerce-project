package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.ProductRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.ProductResponseDto;
import dev.gihan.e_commerce.api.exception.ProductNotFoundException;
import dev.gihan.e_commerce.api.model.Product;
import dev.gihan.e_commerce.api.model.User;
import dev.gihan.e_commerce.api.repository.ProductRepository;
import dev.gihan.e_commerce.api.repository.UserRepository;
import dev.gihan.e_commerce.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto, String sellerUsername) {
        User seller = userRepo.findByUsername(sellerUsername)
                .orElseThrow(() -> new UsernameNotFoundException("Seller not found"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setSeller(seller);

        return mapToDto(productRepo.save(product));
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public List<ProductResponseDto> getSellerProducts(String sellerUsername) {
        User seller = userRepo.findByUsername(sellerUsername)
                .orElseThrow(() -> new UsernameNotFoundException("Seller not found"));

        return productRepo.findBySellerId(seller.getId()).stream().map(this::mapToDto).toList();
    }

    @Override
    public ProductResponseDto getProductById(Long id) throws ProductNotFoundException {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return mapToDto(product);
    }

    @Override
    public void deleteProduct(Long id, String sellerUsername) throws ProductNotFoundException {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        if (!product.getSeller().getUsername().equals(sellerUsername)) {
            throw new SecurityException("You do not own this product.");
        }

        productRepo.delete(product);
    }

    private ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setSellerUsername(product.getSeller().getUsername());
        return dto;
    }
}
