package cn.nttt.service;

import cn.nttt.domain.ResponseResult;

public interface CameraAuthenticationService
{

    ResponseResult authentication(String authCode) ;

    ResponseResult deauthenticate(String authCode);
}
