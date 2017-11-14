package vn.easycresdit.exception;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import vn.easycredit.domain.Utilities.ApiError;


/**
 * 
 * @author HienNT
 *
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
public class InvalidException extends Exception {
    private final ApiError errorCode;
    private final String message;
    
    public InvalidException(ApiError code, String message) {
        super(code.asErrorCode());
        this.message = message;
        this.errorCode = code;
    }
}
