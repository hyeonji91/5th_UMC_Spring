package umc.springDemo.apiPayload.exception.handler;

import umc.springDemo.apiPayload.code.BaseErrorCode;
import umc.springDemo.apiPayload.exception.GeneralException;

public class RestaurantHandler extends  GeneralException{
    public RestaurantHandler(BaseErrorCode errorCode){ super(errorCode);}
}

