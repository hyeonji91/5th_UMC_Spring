package umc.springDemo.converter;

import org.springframework.stereotype.Component;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.web.dto.RestaurantResponseDTO;
import umc.springDemo.web.dto.RestaurantRequestDTO;

import java.time.LocalDateTime;


public class RestaurantConverter {
    public static RestaurantResponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant){
        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getRestaurantId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDTO request){
        return Restaurant.builder()
                .restaurantName(request.getRestaurantName())
              .build();
    }

}
