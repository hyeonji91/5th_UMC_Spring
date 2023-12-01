package umc.springDemo.web.dto;

import lombok.Getter;
import umc.springDemo.validation.annotation.ExistRestaurants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class PostReviewDTO {
        @NotBlank
        String reviewText;

        @NotNull
        Double rating;

        @NotNull
        @ExistRestaurants
        Long restaurantId;

        @NotNull
        Long userId;

        @NotNull
        List<String> reviewImg;
    }
}
