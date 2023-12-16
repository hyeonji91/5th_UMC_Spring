package umc.springDemo.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.converter.MissionConverter;
import umc.springDemo.converter.RestaurantConverter;
import umc.springDemo.converter.UserMissionConverter;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.service.UserMissionService.UserMissionCommandService;
import umc.springDemo.validation.annotation.CheckPage;
import umc.springDemo.validation.annotation.ExistRestaurants;
import umc.springDemo.web.dto.*;

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

    @GetMapping("/doing-missions/{userId}")
    @Operation(summary = "특정 유저가 진행 중인 미션 목록 조회 API",description = "특정 유저가 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    public ApiResponse<MissionResponseDTO.MissonPreViewListDTO> getMissionList(
            @ExistRestaurants @PathVariable(name = "userId") Long userId
            , @CheckPage @RequestParam(name = "page") Integer page){
        Page<UserMission> mission= userMissionCommandService.getMissionList(userId, page);
        return ApiResponse.onSuccess(UserMissionConverter.missonPreViewListDTO(mission));
    }
}
