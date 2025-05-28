package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.ReviewRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.ReviewResponseDto;
import dev.gihan.e_commerce.api.exception.AlreadyReviewedException;
import dev.gihan.e_commerce.api.model.Product;
import dev.gihan.e_commerce.api.model.Review;
import dev.gihan.e_commerce.api.model.User;
import dev.gihan.e_commerce.api.repository.ProductRepository;
import dev.gihan.e_commerce.api.repository.ReviewRepository;
import dev.gihan.e_commerce.api.repository.UserRepository;
import dev.gihan.e_commerce.api.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepo;
    private UserRepository userRepo;
    private ProductRepository productRepo;

    @Override
    public void addReview(ReviewRequestDto dto, String username) throws AlreadyReviewedException {
        User customer = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (reviewRepo.existsByProductIdAndCustomerId(product.getId(), customer.getId())) {
            throw new AlreadyReviewedException("You already reviewed this product.");
        }

        Review review = new Review();
        review.setProduct(product);
        review.setCustomer(customer);
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());

        reviewRepo.save(review);
    }

    @Override
    public List<ReviewResponseDto> getReviewsForProduct(Long productId) {
        return reviewRepo.findByProductId(productId).stream().map(r -> {
            ReviewResponseDto dto = new ReviewResponseDto();
            dto.setProductName(r.getProduct().getName());
            dto.setCustomerUsername(r.getCustomer().getUsername());
            dto.setRating(r.getRating());
            dto.setComment(r.getComment());
            return dto;
        }).toList();
    }
}

