package umc.springDemo.service.UserService;

import umc.springDemo.domain.User;
import umc.springDemo.web.dto.UserRequestDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);

}
