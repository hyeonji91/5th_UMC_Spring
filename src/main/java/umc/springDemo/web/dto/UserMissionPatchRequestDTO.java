package umc.springDemo.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class UserMissionPatchRequestDTO {
    @Getter
    public static class PatchUserMissionDTO {

        @NotNull
        Long userId;
    }
}
