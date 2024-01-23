package umc.springDemo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.springDemo.domain.ReviewImg;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinReslutDTO{
        Long userId;
        LocalDateTime createdAt;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetMyReviewListDTO{
        List<GetMyReviewDTO> myReviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetMyReviewDTO{
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
        List<ReviewImg> reviewImg;
    }
}
