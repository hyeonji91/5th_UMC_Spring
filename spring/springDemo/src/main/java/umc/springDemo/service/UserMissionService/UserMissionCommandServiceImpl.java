package umc.springDemo.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.MissionHandler;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.enums.MissionType;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.repository.UserMissionRepository;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.UserMissionPatchRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService{
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public UserMission patchUserMissionToDoing(Long missionId, UserMissionPatchRequestDTO.PatchUserMissionDTO request) {

        UserMission userMission = userMissionRepository.findMssionByMission_MissionIdAndUser_UserId(missionId, request.getUserId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        //mission_type을 doing으로 바꾸기
        if(userMission.getMissionType() == MissionType.doing)
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_DOING);
        else
            userMission.setMissionType(MissionType.doing);

        return userMissionRepository.save(userMission);
    }
}
