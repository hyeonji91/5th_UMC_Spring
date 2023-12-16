package umc.springDemo.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.converter.UserConverter;
import umc.springDemo.domain.Review;
import umc.springDemo.domain.User;
import umc.springDemo.service.UserService.UserCommandService;
import umc.springDemo.service.UserService.UserQueryService;
import umc.springDemo.validation.annotation.CheckPage;
import umc.springDemo.validation.annotation.ExistRestaurants;
import umc.springDemo.web.dto.RestaurantResponseDTO;
import umc.springDemo.web.dto.UserRequestDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinReslutDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO((user)));
    }

    @GetMapping("/reviews/{userId}")
    @Operation(summary = "특정 유저의 리뷰 목록 조회 API",description = "특정 유저의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번에 1페이지 입니다")
    })
    public ApiResponse<UserResponseDTO.GetMyReviewListDTO> getReviewList(
            @ExistRestaurants @PathVariable(name = "userId") Long userId
            , @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> review = userQueryService.getReviewList(userId,page);
        return ApiResponse.onSuccess(UserConverter.getMyReviewListDTO(review));
    }
}
