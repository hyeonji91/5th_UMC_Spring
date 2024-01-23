package umc.springDemo.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@Builder
public class ErrorReasonDTO {
    private final String message;
    private final String code;
    private final boolean isSuccess;
    private final HttpStatus httpStatus;

    // Other constructors, methods, etc.
}
