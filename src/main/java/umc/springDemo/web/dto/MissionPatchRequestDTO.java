package umc.springDemo.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MissionPatchRequestDTO {
    @Getter
    public static class PatchMissionDTO {

        @NotNull
        Long userId;
    }
}
