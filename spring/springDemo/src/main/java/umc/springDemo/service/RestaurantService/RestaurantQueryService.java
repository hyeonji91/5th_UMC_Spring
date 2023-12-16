package umc.springDemo.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;

import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> findRestaurant(Long id);
    Page<Review> getReviewList(Long RestaurantId, Integer page);
    Page<Mission> getMissionList(Long RestaurantId, Integer page);
}
