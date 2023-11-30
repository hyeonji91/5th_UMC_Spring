package umc.springDemo.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.FoodCategoryHandler;
import umc.springDemo.converter.UserConverter;
import umc.springDemo.converter.UserPreferConverter;
import umc.springDemo.domain.FoodCategory;
import umc.springDemo.domain.User;
import umc.springDemo.domain.mapping.UserPrefer;
import umc.springDemo.repository.FoodCategoryRepository;
import umc.springDemo.repository.UserRepository;
import umc.springDemo.web.dto.UserRequestDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request){

        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);
        userPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
