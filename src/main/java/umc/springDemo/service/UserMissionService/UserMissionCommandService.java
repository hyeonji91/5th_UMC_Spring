package umc.springDemo.service.UserMissionService;

import org.springframework.data.domain.Page;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.User;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.UserMissionPatchRequestDTO;

import java.util.Optional;

public interface UserMissionCommandService {
    UserMission patchUserMissionToDoing(Long missionId, UserMissionPatchRequestDTO.PatchUserMissionDTO request);
    public Page<UserMission> getMissionList(Long UserId, Integer page);

}
