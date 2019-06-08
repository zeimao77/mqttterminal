package top.zeimao77.util;

import org.springframework.util.StringUtils;

import top.zeimao77.consts.ServiceErrorEnum;
import top.zeimao77.exception.ServiceRuntimeException;

public class ServiceAssert {
	
	private ServiceAssert (){}
	
	public static void isTrue(boolean expression,String message) {
		if(!expression) {
			throw new ServiceRuntimeException("");
		}
	}
	
	public static void isTrue(boolean expression) {
		isTrue(expression,ServiceErrorEnum.UNKNOWN_ERROR);
	}
	
	public static void isTrue(boolean expression,ServiceErrorEnum error) {
		isTrue(expression,error.getCode());
	}
	
	public static void notNull(Object obj) {
		notNull(StringUtils.isEmpty(obj),ServiceErrorEnum.UNKNOWN_DATA_ERROR);
	}
	
	public static void notNull(Object obj,ServiceErrorEnum error) {
		isTrue(!StringUtils.isEmpty(obj),error);
	}

}
