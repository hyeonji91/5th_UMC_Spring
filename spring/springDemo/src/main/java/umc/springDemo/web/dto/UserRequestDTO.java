package umc.springDemo.web.dto;

import lombok.Getter;

import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        List<Long> preferCategory;
    }
}
