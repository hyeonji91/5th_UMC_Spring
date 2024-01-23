package umc.springDemo.apiPayload.exception.handler;

import umc.springDemo.apiPayload.code.BaseErrorCode;
import umc.springDemo.apiPayload.exception.GeneralException;

public class UserHandler extends  GeneralException{
    public UserHandler(BaseErrorCode errorCode){ super(errorCode);}
}

