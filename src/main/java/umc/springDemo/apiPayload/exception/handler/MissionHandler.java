package umc.springDemo.apiPayload.exception.handler;

import umc.springDemo.apiPayload.code.BaseErrorCode;
import umc.springDemo.apiPayload.exception.GeneralException;

public class MissionHandler extends  GeneralException{
    public MissionHandler(BaseErrorCode errorCode){ super(errorCode);}
}

