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

    //InvalidDataAccessApiUsageException
    //    @Autowired
//    ReviewConverter(  RestaurantCommandServiceImpl restaurantCommandService, UserCommandServiceImpl userCommandService){
//        ReviewConverter.userCommandService = userCommandService;
//        ReviewConverter.restaurantCommandService = restaurantCommandService;
//    }
    public static ReviewResponseDTO.PostReviewResultDTO toPostReviewResultDTO(Review review){
        return ReviewResponseDTO.PostReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Review toReview(ReviewRequestDTO.PostReviewDTO request){

//        User user =  userCommandService.findById(request.getUserId())
//                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        List<ReviewImg> foreginReviewImgList =
                request.getReviewImg().stream()
                .map(img -> ReviewImg.builder()
                        .imgURL(img)
                        .build()
                ).collect(Collectors.toList());


        return Review.builder()
//                .user(user)
//                .name(user.getName())
//                .restaurant(restaurantCommandService.findById(request.getRestaurantId())
//                        .orElseThrow(()->new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND)))
                .reviewImgList(foreginReviewImgList)
                .text(request.getReviewText())
                .rate(request.getRating())
                .build();
    }

}
