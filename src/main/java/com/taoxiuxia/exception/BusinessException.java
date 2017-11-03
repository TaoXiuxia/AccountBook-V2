package com.taoxiuxia.exception;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = -5587054685087764286L;

	public BusinessException(String message, Throwable e) {
		super(message, e);
	}

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(Throwable e) {
		super(e);
	}

	/**
	 * 重写 fillInStackTrace 方法，日志不会打印堆栈信息，节省时间。
	 * 			业务异常，没有必要打印堆栈，提高效率。
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
}
