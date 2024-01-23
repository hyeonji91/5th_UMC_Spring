package umc.springDemo.service.FoodCategoryService;

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
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existsById(Long id) {

        return foodCategoryRepository.existsById(id);
    }


}
