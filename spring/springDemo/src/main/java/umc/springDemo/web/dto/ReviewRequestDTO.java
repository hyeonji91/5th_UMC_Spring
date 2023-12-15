package umc.springDemo.web.dto;

import lombok.Getter;
import umc.springDemo.validation.annotation.ExistRestaurants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class PostReviewDTO {
        @NotNull
        @ExistRestaurants
        Long restaurantId;

        @NotNull
        Long userId;

        @NotNull
        Double rating;

        @NotBlank
        String reviewText;

        @NotNull
        List<String> reviewImg;
    }
}
