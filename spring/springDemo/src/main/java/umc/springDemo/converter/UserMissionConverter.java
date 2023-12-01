package umc.springDemo.converter;

import umc.springDemo.domain.Mission;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.MissionPatchResponseDTO;
import umc.springDemo.web.dto.UserMissionPatchRequestDTO;
import umc.springDemo.web.dto.UserMissionPatchResponseDTO;

public class UserMissionConverter {
    public static UserMissionPatchResponseDTO.PatchUserMissionResultDTO toPatchUserMissionDTO(UserMission userMission){
        return UserMissionPatchResponseDTO.PatchUserMissionResultDTO.builder()
                .build();
    }

    public static UserMission toUserMission(UserMissionPatchRequestDTO request){
        return UserMission.builder()
                .build();
    }

}
