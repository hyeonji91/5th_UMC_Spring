package umc.springDemo.converter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.RegionHandler;
import umc.springDemo.apiPayload.exception.handler.RestaurantHandler;
import umc.springDemo.apiPayload.exception.handler.TempHandler;
import umc.springDemo.apiPayload.exception.handler.UserHandler;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.ReviewImg;
import umc.springDemo.domain.User;
import umc.springDemo.domain.mapping.UserPrefer;
import umc.springDemo.service.RestaurantService.RestaurantCommandServiceImpl;
import umc.springDemo.service.UserService.UserCommandService;
import umc.springDemo.service.UserService.UserCommandServiceImpl;
import umc.springDemo.web.dto.RestaurantRequestDTO;
import umc.springDemo.web.dto.RestaurantResponseDTO;
import umc.springDemo.web.dto.ReviewRequestDTO;
import umc.springDemo.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewConverter {

    private static UserCommandServiceImpl userCommandService;
    private static RestaurantCommandServiceImpl restaurantCommandService;

    public static ReviewResponseDTO.PostReviewResultDTO toPostReviewResultDTO(Review review){
        return ReviewResponseDTO.PostReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(review.getCreatedAt())
                .build();
    }


    public static List<ReviewImg> toReviewImgList(List<ReviewRequestDTO.ReviewImgDTO> reviewImgDTOList){
//        reviewImg.stream().map(img -> ReviewImg.builder()
//                .imgURL(img)
//                .build()).collect(Collectors.toList());

        return reviewImgDTOList.stream()
                .map(imgDTO -> ReviewImg.builder().imgURL(imgDTO.getImgUrl()).build())
                .collect(Collectors.toList());
    }
    public static Review toReview(ReviewRequestDTO.PostReviewDTO request){

//        User user =  userCommandService.findById(request.getUserId())
//                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
//        List<ReviewImg> foreginReviewImgList =
//                request.getReviewImg().stream()
//                .map(img -> ReviewImg.builder()
//                        .imgURL(img)
//                        .build()
//                ).collect(Collectors.toList());


        return Review.builder()
                .reviewImgList(toReviewImgList(request.getReviewImg()))
                .reviewBody(request.getReviewBody())
                .score(request.getScore())
                .createdAt(LocalDateTime.now())
                .build();
    }



}
