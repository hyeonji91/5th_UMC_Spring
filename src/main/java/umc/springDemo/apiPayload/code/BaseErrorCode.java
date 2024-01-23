package umc.springDemo.apiPayload.code;

import lombok.Builder;


public interface BaseErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
