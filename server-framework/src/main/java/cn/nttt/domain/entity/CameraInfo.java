package cn.nttt.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CameraInfo
{
    private String cameraAuthCode;

    private String cameraUUID;

    private String startTime;
}
