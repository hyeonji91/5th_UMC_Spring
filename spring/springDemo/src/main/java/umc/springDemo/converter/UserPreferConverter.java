package umc.springDemo.converter;

import umc.springDemo.domain.FoodCategory;
import umc.springDemo.domain.mapping.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserPrefer> toUserPreferList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
