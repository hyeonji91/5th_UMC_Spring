package umc.springDemo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.springDemo.domain.ReviewImg;
import umc.springDemo.validation.annotation.ExistRestaurants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
        Float score;

        @NotBlank
        String reviewBody;

        @NotNull
        List<ReviewImgDTO> reviewImg;
    }
    @Getter
    public static class ReviewImgDTO{
        String imgUrl;
    }
}
