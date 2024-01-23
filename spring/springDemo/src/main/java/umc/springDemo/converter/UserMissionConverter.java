package umc.springDemo.converter;

import org.springframework.data.domain.Page;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.web.dto.*;

import java.util.List;
import java.util.stream.Collectors;

public class UserMissionConverter {
    public static UserMissionPatchResponseDTO.PatchUserMissionResultDTO toPatchUserMissionDTO(UserMission userMission){
        return UserMissionPatchResponseDTO.PatchUserMissionResultDTO.builder()
                .build();
    }

    public static UserMission toUserMission(UserMissionPatchRequestDTO request){
        return UserMission.builder()
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(UserMission userMission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .dDay(userMission.getMission().getDDay())
                .amount(userMission.getMission().getAmount())
                .point(userMission.getMission().getPoint())
                .createdAt(userMission.getMission().getCreatedAt().toLocalDate())
                .build();
    }
    public static MissionResponseDTO.MissonPreViewListDTO missonPreViewListDTO(Page<UserMission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(UserMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissonPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

}
