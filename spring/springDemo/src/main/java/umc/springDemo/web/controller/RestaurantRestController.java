package umc.springDemo.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.converter.RestaurantConverter;
import umc.springDemo.converter.ReviewConverter;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;
import umc.springDemo.service.RestaurantService.RestaurantCommandService;
import umc.springDemo.service.RestaurantService.RestaurantQueryService;
import umc.springDemo.service.ReviewService.ReviewCommandService;
import umc.springDemo.validation.annotation.CheckPage;
import umc.springDemo.validation.annotation.ExistRestaurants;
import umc.springDemo.web.dto.RestaurantResponseDTO;
import umc.springDemo.web.dto.RestaurantRequestDTO;
import umc.springDemo.web.dto.ReviewRequestDTO;
import umc.springDemo.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;
    private final ReviewCommandService reviewCommandService;
    private final RestaurantQueryService restaurantQueryService;

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

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistRestaurants @PathVariable(name = "storeId") Long storeId
            , @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> review= restaurantQueryService.getReviewList(storeId, page-1);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreViewListDTO(review));
        //return null;
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호")
    })
    public ApiResponse<RestaurantResponseDTO.MissonPreViewListDTO> getMissionList(
            @ExistRestaurants @PathVariable(name = "storeId") Long storeId
            , @CheckPage @RequestParam(name = "page") Integer page){
        Page<Mission> mission= restaurantQueryService.getMissionList(storeId, page-1);
        return ApiResponse.onSuccess(RestaurantConverter.missonPreViewListDTO(mission));
    }
}
