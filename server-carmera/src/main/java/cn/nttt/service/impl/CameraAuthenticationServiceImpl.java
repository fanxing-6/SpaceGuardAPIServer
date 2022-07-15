package cn.nttt.service.impl;


import cn.hutool.core.date.DateTime;
import cn.nttt.domain.ResponseResult;
import cn.nttt.domain.entity.CameraInfo;
import cn.nttt.enums.AppHttpCodeEnum;
import cn.nttt.service.CameraAuthenticationService;
import cn.nttt.utils.RSAUtil;
import cn.nttt.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class CameraAuthenticationServiceImpl implements CameraAuthenticationService
{
    @Autowired
    private RSAUtil rsaUtil;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult authentication(String authCode)
    {
        CameraInfo cameraInfo = redisCache.getCacheObject(authCode);
        if (cameraInfo == null)
        {
            Date day = new Date();

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String uuid = rsaUtil.GetUUID(authCode);
            CameraInfo newInfo = new CameraInfo(authCode, uuid, df.format(day));
            redisCache.setCacheObject(authCode, newInfo);
            return ResponseResult.okResult(uuid);
        }
        return ResponseResult.okResult(cameraInfo.getCameraUUID());
    }

    @Override
    public ResponseResult deauthenticate(String authCode)
    {
        CameraInfo cameraInfo = redisCache.getCacheObject(authCode);
        if(cameraInfo!=null)
        {
            redisCache.deleteObject(authCode);
            return ResponseResult.okResult(200,"关闭连接成功");
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
    }
}
