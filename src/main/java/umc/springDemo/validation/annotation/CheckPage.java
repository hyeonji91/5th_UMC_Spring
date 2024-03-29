package umc.springDemo.validation.annotation;

import umc.springDemo.validation.validator.CategoriesExistValidator;
import umc.springDemo.validation.validator.CheckPageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "잘못된 페이지 범위입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

