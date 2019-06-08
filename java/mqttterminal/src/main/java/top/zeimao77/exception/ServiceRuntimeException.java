package top.zeimao77.exception;

import top.zeimao77.consts.ServiceErrorEnum;

public class ServiceRuntimeException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	private String code;

    public ServiceRuntimeException(String code,Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public ServiceRuntimeException(String code,String message) {
        super(message);
        this.code = code;
    }

    public ServiceRuntimeException(String message) {
        super(message);
        this.code = "-1";
    }
    
    public ServiceRuntimeException(ServiceErrorEnum error) {
        super(error.getCode_description());
        this.code = error.getCode();
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
    

}
