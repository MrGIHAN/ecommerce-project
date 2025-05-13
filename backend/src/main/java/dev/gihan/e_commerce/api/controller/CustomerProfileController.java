package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.CustomerProfileRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.CustomerProfileResponseDto;
import dev.gihan.e_commerce.api.exception.NotFoundException;
import dev.gihan.e_commerce.api.service.CustomerProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer-Profile")
@AllArgsConstructor
public class CustomerProfileController {

    private CustomerProfileService customerProfileService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CustomerProfileRequestDto customerProfileRequestDto) {
        customerProfileService.create(customerProfileRequestDto);
        return ResponseEntity.ok("Customer Profile Created Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(Long id, @Valid @RequestBody CustomerProfileRequestDto customerProfileRequestDto) throws NotFoundException {
        customerProfileService.update(id, customerProfileRequestDto);
        return ResponseEntity.ok("Customer Profile Updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerProfile(@PathVariable Long id) throws NotFoundException {
        customerProfileService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfileResponseDto> getCustomerProfile(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(customerProfileService.getById(id));
    }






}
