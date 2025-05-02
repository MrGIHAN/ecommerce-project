package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.ProductRequestDto;
import dev.gihan.e_commerce.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductRequestDto productRequestDto) {
        productService.create(productRequestDto);
    }

//    @GetMapping("/{id}")
//    public ProductResponseDto getById(@PathVariable Long id) {
//        return productService.getById(id);
//    }
//
//    @GetMapping
//    public List<ProductResponseDto> getAll() {
//        return productService.getAll();
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto) {
//        productService.update(id, productRequestDto);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id) {
//        productService.delete(id);
//    }
}