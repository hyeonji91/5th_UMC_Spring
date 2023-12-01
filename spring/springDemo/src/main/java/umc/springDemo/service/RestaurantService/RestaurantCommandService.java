package umc.springDemo.service.RestaurantService;

import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.User;
import umc.springDemo.web.dto.RestaurantRequestDTO;
import umc.springDemo.web.dto.UserRequestDTO;

public interface RestaurantCommandService {
    Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request);

}
