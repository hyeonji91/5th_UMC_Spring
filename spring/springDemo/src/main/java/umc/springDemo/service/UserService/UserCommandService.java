package umc.springDemo.service.UserService;

import umc.springDemo.domain.User;
import umc.springDemo.web.dto.UserRequestDTO;

import java.util.Optional;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);

    Optional<User> findById(Long id);


}
