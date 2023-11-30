package umc.springDemo.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.springDemo.apiPayload.code.BaseCode;
import umc.springDemo.apiPayload.code.ErrorReasonDTO;
import umc.springDemo.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "COMMON200", "요청 성공"),
    _CREATED(HttpStatus.CREATED, "COMMON201", "적절한 데이터 생성")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;



    @Override
    public ReasonDTO getReason(){
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
