package dev.gihan.e_commerce.api.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewRequestDto {

    private Long productId;
    private int rating;
    private String comment;

}

