package umc.springDemo.service.UserMissionService;

import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.UserMissionPatchRequestDTO;

public interface UserMissionCommandService {
    UserMission patchUserMissionToDoing(Long missionId, UserMissionPatchRequestDTO.PatchUserMissionDTO request);

}
