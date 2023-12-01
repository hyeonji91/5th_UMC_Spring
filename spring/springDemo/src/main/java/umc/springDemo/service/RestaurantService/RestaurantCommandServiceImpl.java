package umc.springDemo.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.FoodCategoryHandler;
import umc.springDemo.apiPayload.exception.handler.RegionHandler;
import umc.springDemo.converter.RestaurantConverter;
import umc.springDemo.converter.UserConverter;
import umc.springDemo.converter.UserPreferConverter;
import umc.springDemo.domain.FoodCategory;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.domain.User;
import umc.springDemo.domain.mapping.UserPrefer;
import umc.springDemo.repository.FoodCategoryRepository;
import umc.springDemo.repository.RegionRepository;
import umc.springDemo.repository.RestaurantRepository;
import umc.springDemo.repository.UserRepository;
import umc.springDemo.web.dto.RestaurantRequestDTO;
import umc.springDemo.web.dto.UserRequestDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {
    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;


    @Override
    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request){

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);

        newRestaurant.setRegion(regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)));

        return restaurantRepository.save(newRestaurant);
    }

}
