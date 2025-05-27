package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.ReviewRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.ReviewResponseDto;
import dev.gihan.e_commerce.api.exception.AlreadyReviewedException;
import dev.gihan.e_commerce.api.security.CustomUserDetails;
import dev.gihan.e_commerce.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Void> addReview(
            @RequestBody ReviewRequestDto dto,
            @AuthenticationPrincipal CustomUserDetails user) throws AlreadyReviewedException {
        reviewService.addReview(dto, user.getUsername());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ReviewResponseDto>> getProductReviews(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewService.getReviewsForProduct(productId));
    }
}

