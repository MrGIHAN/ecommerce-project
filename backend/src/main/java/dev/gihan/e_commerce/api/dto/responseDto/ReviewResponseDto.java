package dev.gihan.e_commerce.api.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewResponseDto {

    private String productName;
    private String customerUsername;
    private int rating;
    private String comment;

}

