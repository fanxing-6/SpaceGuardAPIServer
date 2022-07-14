package cn.nttt.service.impl;

import cn.nttt.domain.ResponseResult;
import cn.nttt.service.CameraAuthenticationService;
import cn.nttt.utils.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CameraAuthenticationServiceImpl implements CameraAuthenticationService
{
    @Autowired
    private RSAUtil rsaUtil;

    @Override
    public ResponseResult authentication(String authCode)
    {
        return ResponseResult.okResult(rsaUtil.Decrypt(authCode));
    }
}
