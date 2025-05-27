package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.ReviewRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.ReviewResponseDto;
import dev.gihan.e_commerce.api.exception.AlreadyReviewedException;

import java.util.List;

public interface ReviewService {

    void addReview(ReviewRequestDto dto, String username) throws AlreadyReviewedException;
    List<ReviewResponseDto> getReviewsForProduct(Long productId);

}

