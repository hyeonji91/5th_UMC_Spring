package umc.springDemo.service.FoodCategoryService;

import umc.springDemo.domain.User;
import umc.springDemo.web.dto.UserRequestDTO;

public interface FoodCategoryCommandService {
    boolean existsById(Long id);
}
