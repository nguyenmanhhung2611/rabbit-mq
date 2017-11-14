package vn.easycredit.controller;


import vn.easycredit.constant.NormalError;
import vn.easycredit.domain.ErrorInfo.InvalidParameter;
import vn.easycredit.domain.ErrorInfo.Type;

/**
 * 
 * @author HienNT
 *
 */
public class CustomException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NormalError normalError;
	
	private Type type;
	
	private InvalidParameter invalidParameter;

	public CustomException(NormalError normalError, Type type, InvalidParameter invalidParameter) {
		this.normalError = normalError;
		this.type = type;
		this.invalidParameter = invalidParameter;
	}

	public NormalError getNormalError() {
		return normalError;
	}

	public void setNormalError(NormalError normalError) {
		this.normalError = normalError;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public InvalidParameter getInvalidParameter() {
		return invalidParameter;
	}

	public void setInvalidParameter(InvalidParameter invalidParameter) {
		this.invalidParameter = invalidParameter;
	}


}
