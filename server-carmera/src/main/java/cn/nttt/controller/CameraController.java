package cn.nttt.controller;

import cn.nttt.domain.ResponseResult;
import cn.nttt.enums.AppHttpCodeEnum;
import cn.nttt.exception.SystemException;
import cn.nttt.service.CameraAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameraController
{
    @Autowired
    private CameraAuthenticationService cameraAuthenticationService;

    @GetMapping("/getToken")
    public ResponseResult getToken( String authCode)
    {
        authCode=authCode.replaceAll(" ","+");

        return cameraAuthenticationService.authentication(authCode);
    }
}