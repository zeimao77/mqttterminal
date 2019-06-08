package top.zeimao77.consts;

@SuppressWarnings("unused")
public enum ErrorEnum {
    UNKNOWN_ERROR("SERVICE_ERROR","未知异常"),
    CODE_ERROR("SERVICE_ERROR","SERVICE_CODE验证失败"),
    CLIENT_ERROR("SERVICE_ERROR","CLIENT资料验证失败"),
    REFRESHTOKEN_ERROR("SERVICE_ERROR","refresh_token验证失败"),
    ACCESS_TOKEN_INVALIDATE("ACCESS_TOKEN_INVALIDATE","access_token 无效"),//access_token 无效（包括失效）
    INVALIDATE_CONTROL_ORDER("INVALIDATE_CONTROL_ORDER","控制指令不正确"),
    DEVICE_NOT_SUPPORT_FUNCTION("DEVICE_NOT_SUPPORT_FUNCTION","设备不支持该操作"),
    INVALIDATE_PARAMS("INVALIDATE_PARAMS","请求参数有误"),
    DEVICE_IS_NOT_EXIST("DEVICE_IS_NOT_EXIST","设备未找到"),
    IOT_DEVICE_OFFLINE("IOT_DEVICE_OFFLINE","设备离线")
    ;

    private String code;
    private String code_description;

    ErrorEnum(String code,String code_description){
        this.code = code;
        this.code_description = code_description;
    }

    public String getCode() {
        return code;
    }

    public String getCode_description() {
        return code_description;
    }
}
