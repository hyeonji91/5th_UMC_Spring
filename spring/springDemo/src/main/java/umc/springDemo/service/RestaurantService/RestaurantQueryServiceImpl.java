package umc.springDemo.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.Review;
import umc.springDemo.repository.MissionRepository;
import umc.springDemo.repository.RestaurantRepository;
import umc.springDemo.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Restaurant> findRestaurant(Long id){
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long RestaurantId, Integer page){
        Restaurant restaurant = restaurantRepository.findById(RestaurantId).get();

        Page<Review> RestaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page,10));
        return RestaurantPage;
    }

    @Override
    public Page<Mission> getMissionList(Long RestaurantId, Integer page){
        Restaurant restaurant = restaurantRepository.findById(RestaurantId).get();
        Page<Mission> RestaurantPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return RestaurantPage;
    }

}
