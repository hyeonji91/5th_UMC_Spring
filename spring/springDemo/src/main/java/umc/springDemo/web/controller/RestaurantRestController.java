package umc.springDemo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.converter.RestaurantConverter;
import umc.springDemo.converter.UserConverter;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.User;
import umc.springDemo.service.RestaurantService.RestaurantCommandService;
import umc.springDemo.service.UserService.UserCommandService;
import umc.springDemo.web.dto.RestaurantReponseDTO;
import umc.springDemo.web.dto.RestaurantRequestDTO;
import umc.springDemo.web.dto.UserRequestDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantReponseDTO.AddRestaurantResultDTO> add(@RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request){
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }
}
