package umc.springDemo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.converter.MissionConverter;
import umc.springDemo.converter.UserMissionConverter;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.service.UserMissionService.UserMissionCommandService;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.MissionPatchResponseDTO;
import umc.springDemo.web.dto.UserMissionPatchRequestDTO;
import umc.springDemo.web.dto.UserMissionPatchResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final UserMissionCommandService userMissionCommandService;

    @PatchMapping("/doing-missions/{missionId}")
    public ApiResponse<String> patchUserMissionToDoing(
            @PathVariable("missionId") @Valid Long missionId,
            @RequestBody @Valid UserMissionPatchRequestDTO.PatchUserMissionDTO request){

        UserMission userMission = userMissionCommandService.patchUserMissionToDoing(missionId, request);
        return ApiResponse.onSuccess("mission 진행중으로 이동 완료");
    }
}
