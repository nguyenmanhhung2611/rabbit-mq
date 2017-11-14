package vn.easycresdit.exception;

import vn.easycredit.domain.Utilities.ApiError;

/**
 * @author HienNT
 *
 */
@SuppressWarnings("serial")
public class ImxContractNotFoundException extends InvalidException {

    public ImxContractNotFoundException(String message) {
        super(ApiError.IMX_CONTRACT_NOT_FOUND_ERROR_CODE, message);
    }
}
