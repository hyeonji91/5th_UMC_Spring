package umc.springDemo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.converter.RestaurantConverter;
import umc.springDemo.converter.ReviewConverter;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;
import umc.springDemo.service.RestaurantService.RestaurantCommandService;
import umc.springDemo.service.ReviewService.ReviewCommandService;
import umc.springDemo.web.dto.RestaurantResponseDTO;
import umc.springDemo.web.dto.RestaurantRequestDTO;
import umc.springDemo.web.dto.ReviewRequestDTO;
import umc.springDemo.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> addRestaurant(@RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request){
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.PostReviewResultDTO> postReview(@RequestBody @Valid ReviewRequestDTO.PostReviewDTO request){
        Review review = reviewCommandService.postReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toPostReviewResultDTO(review));
    }
}
