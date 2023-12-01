package umc.springDemo.web.dto;

import lombok.Getter;
import umc.springDemo.validation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDTO {
        @NotBlank
        String restaurantName;

        @NotNull
        Long regionId;

    }
}
