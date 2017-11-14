package vn.easycredit.domain;

import java.util.Date;

/**
 * 
 * @author HienNT
 *
 */
public final class Utilities {

	public static Date getTime() {
		Date now = new Date();
		return now;
	}
	
	public enum ApiError {
	    IMX_CONTRACT_NOT_FOUND_ERROR_CODE("G003");

	    private String errorCode;

	    private ApiError(String errorCode) {
	        this.errorCode = errorCode;
	    }

	    public String asErrorCode() {
	        return errorCode;
	    }
	}
	
	public static final String PARTNER_CODE_SAC = "SAC";
	public static final String PARTNER_CODE_PAYOO = "PAY";
	public static final String PARTNER_CODE_MOMO = "MOM";
	
	public static final String[] PARTNER_CODE = {PARTNER_CODE_SAC, PARTNER_CODE_PAYOO, PARTNER_CODE_MOMO};
	
}
