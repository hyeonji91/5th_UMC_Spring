package umc.springDemo.converter;

import org.springframework.data.domain.Page;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.MissionPatchResponseDTO;
import umc.springDemo.web.dto.MissionResponseDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
