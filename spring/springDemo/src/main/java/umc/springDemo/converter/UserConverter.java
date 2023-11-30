package umc.springDemo.converter;

import umc.springDemo.domain.User;
import umc.springDemo.domain.enums.Gender;
import umc.springDemo.web.dto.UserRequestDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinReslutDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinReslutDTO.builder()
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch(request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .userPreferList(new ArrayList<>())
                .build();

    }
}
