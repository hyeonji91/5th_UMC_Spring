package umc.springDemo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.service.UserService.UserCommandService;
import umc.springDemo.web.dto.UserRequestDTO;
import umc.springDemo.web.dto.UserResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinReslutDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        return null;
    }
}
