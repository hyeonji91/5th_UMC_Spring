package umc.springDemo.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.RegionHandler;
import umc.springDemo.converter.RestaurantConverter;
import umc.springDemo.domain.Restaurant;
import umc.springDemo.repository.RegionRepository;
import umc.springDemo.repository.RestaurantRepository;
import umc.springDemo.web.dto.RestaurantRequestDTO;

import javax.transaction.Transactional;
import java.util.Optional;

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

    @Override
    public Optional<Restaurant> findById(Long id){
        return restaurantRepository.findById(id);
    }

    @Override
    public Boolean existsById(Long id){
        return restaurantRepository.existsById(id);
    }

}
