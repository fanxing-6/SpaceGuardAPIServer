package cn.nttt.enums;

public enum AppHttpCodeEnum
{
    // 成功
    SUCCESS(200, "操作成功"),
    // 登录
    NEED_LOGIN(401, "需要连接后操作"),
    NO_OPERATOR_AUTH(403, "无权限操作"),
    SYSTEM_ERROR(500, "出现错误"),
    AUTHCODE_ERROR(501, "验证码错误");


    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage)
    {
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }
}
