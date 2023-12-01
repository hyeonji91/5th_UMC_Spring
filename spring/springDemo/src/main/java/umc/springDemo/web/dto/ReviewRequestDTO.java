package umc.springDemo.web.dto;

import lombok.Getter;

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
        Long restaurantId;

        @NotNull
        Long userId;

        @NotNull
        List<String> reviewImg;
    }
}
