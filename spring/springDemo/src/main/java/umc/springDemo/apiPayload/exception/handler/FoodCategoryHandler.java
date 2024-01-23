package umc.springDemo.apiPayload.exception.handler;

import umc.springDemo.apiPayload.code.BaseErrorCode;
import umc.springDemo.apiPayload.exception.GeneralException;
import umc.springDemo.repository.FoodCategoryRepository;

public class FoodCategoryHandler extends  GeneralException{
    public FoodCategoryHandler(BaseErrorCode errorCode){ super(errorCode);}
}

