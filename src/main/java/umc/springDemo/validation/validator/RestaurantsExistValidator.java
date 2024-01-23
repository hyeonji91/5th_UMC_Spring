package umc.springDemo.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.repository.FoodCategoryRepository;
import umc.springDemo.service.RestaurantService.RestaurantCommandService;
import umc.springDemo.service.RestaurantService.RestaurantCommandServiceImpl;
import umc.springDemo.validation.annotation.ExistCategories;
import umc.springDemo.validation.annotation.ExistRestaurants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantsExistValidator implements ConstraintValidator<ExistRestaurants, Long> {

    private final RestaurantCommandServiceImpl restaurantCommandService;

    @Override
    public void initialize(ExistRestaurants constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantCommandService.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();

        return false;
        }

        return true;
    }
}