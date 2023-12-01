package umc.springDemo.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDTO {
        @NotBlank
        String restaurantName;

        @NotNull
        Long regionId;

    }
}
