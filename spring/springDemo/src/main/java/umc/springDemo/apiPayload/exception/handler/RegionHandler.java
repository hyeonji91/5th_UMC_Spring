package umc.springDemo.apiPayload.exception.handler;

import umc.springDemo.apiPayload.code.BaseErrorCode;
import umc.springDemo.apiPayload.exception.GeneralException;

public class RegionHandler extends  GeneralException{
    public RegionHandler(BaseErrorCode errorCode){ super(errorCode);}
}

