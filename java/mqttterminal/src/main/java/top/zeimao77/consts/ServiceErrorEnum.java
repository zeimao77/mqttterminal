package top.zeimao77.consts;

public enum ServiceErrorEnum {
	
	UNKNOWN_ERROR("SERVICE_ERROR","未知异常"),
	UNKNOWN_DATA_ERROR("SERVICE_DATA_ERROR","输入数据异常"),
	DEVICE_IS_NOT_EXIST("DEVICE_IS_NOT_EXIST","设备未找到"),
	DEVICE_NOT_SUPPORT_FUNCTION("DEVICE_NOT_SUPPORT_FUNCTION","设备不支持该操作"),
	DEVICE_TYPE_ERROR("DEVICE_TYPE_ERROR","设备类型校验错误"),
    INVALIDATE_CONTROL_ORDER("INVALIDATE_CONTROL_ORDER","控制指令不正确"),
	;

    private String code;
    private String code_description;

    ServiceErrorEnum(String code,String code_description){
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
