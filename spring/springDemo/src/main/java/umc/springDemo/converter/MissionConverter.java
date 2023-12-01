package umc.springDemo.converter;

import umc.springDemo.domain.Mission;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.MissionPatchResponseDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionPatchResponseDTO.PatchMissionResultDTO toPatchMissionDTO(Mission mission){
        return MissionPatchResponseDTO.PatchMissionResultDTO.builder()
                .build();
    }

    public static Mission toMission(MissionPatchRequestDTO request){
        return Mission.builder()
                .build();
    }

}
