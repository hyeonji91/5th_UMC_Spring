package umc.springDemo.converter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.FoodCategoryHandler;
import umc.springDemo.apiPayload.exception.handler.RegionHandler;
import umc.springDemo.domain.Region;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.User;
import umc.springDemo.repository.RegionRepository;
import umc.springDemo.web.dto.RestaurantReponseDTO;
import umc.springDemo.web.dto.RestaurantRequestDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

@Component
public class RestaurantConverter {
    public static RestaurantReponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant){
        return RestaurantReponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getRestaurantId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDTO request){
        return Restaurant.builder()
                .restaurantName(request.getRestaurantName())
//                .region(regionRepository.findById(request.getRegionId())
//                        .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)))
                .build();
    }

}
