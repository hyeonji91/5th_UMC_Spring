package umc.springDemo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.springDemo.apiPayload.ApiResponse;
import umc.springDemo.converter.TempConverter;
import umc.springDemo.service.TempService.TempQueryService;
import umc.springDemo.service.TempService.TempQueryServiceImpl;
import umc.springDemo.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@Validated
@RequiredArgsConstructor
public class TempRestController {
  private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess((TempConverter.toTempExceptionDTO(flag)));
    }



}
