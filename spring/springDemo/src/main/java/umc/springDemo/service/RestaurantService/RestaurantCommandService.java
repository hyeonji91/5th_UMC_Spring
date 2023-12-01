package umc.springDemo.service.RestaurantService;

import umc.springDemo.domain.Restaurant;
import umc.springDemo.web.dto.RestaurantRequestDTO;

import java.util.Optional;

public interface RestaurantCommandService {
    Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request);

    Optional<Restaurant> findById(Long id);

}
