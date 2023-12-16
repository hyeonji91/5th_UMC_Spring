package umc.springDemo.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.springDemo.apiPayload.code.status.ErrorStatus;
import umc.springDemo.apiPayload.exception.handler.MissionHandler;
import umc.springDemo.domain.Mission;
import umc.springDemo.domain.User;
import umc.springDemo.domain.enums.MissionType;
import umc.springDemo.domain.mapping.UserMission;
import umc.springDemo.repository.UserMissionRepository;
import umc.springDemo.repository.UserRepository;
import umc.springDemo.web.dto.MissionPatchRequestDTO;
import umc.springDemo.web.dto.UserMissionPatchRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService{
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserMission patchUserMissionToDoing(Long missionId, UserMissionPatchRequestDTO.PatchUserMissionDTO request) {

        UserMission userMission = userMissionRepository.findMissionByMission_MissionIdAndUser_UserId(missionId, request.getUserId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        //mission_type을 doing으로 바꾸기
        if(userMission.getMissionType() == MissionType.doing)
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_DOING);
        else
            userMission.setMissionType(MissionType.doing);

        return userMissionRepository.save(userMission);
    }
    @Override
    public Page<UserMission> getMissionList(Long UserId, Integer page) {
        User user = userRepository.findById(UserId).get();
        Page<UserMission> MissionPage = userMissionRepository.findAllByUserAndMissionType(user, MissionType.doing, PageRequest.of(page-1, 10));
        return MissionPage;
    }
}
