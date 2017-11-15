package vn.easycredit.constant;

/**
 * @author HienNT
 *
 */

public final class Constant {

	public static final String SUCCESS_MESSAGE = "Success";
	public static final String INTERNALERROR_MESSAGE = "Internal Server Error";
	public static final String BADREQUEST_MESSAGE = "Bad Request";

	public static final int PAGE_SIZE = 3;
	public static final int RESPONSE_SUCCESS = 200;

	public static final String DISBURSEMENT_INFO_INFLOW = "disbursement_info_api";
	public static final String DISBURSEMENT_SUCCESS_INFLOW = "disbursement_success_api";
	public static final String DISBURSEMENT_REJECT_INFLOW = "disbursement_reject_api";
	
	public static final String LOGS_STATUS_INSERT_WORKING_LOG = "insert_working_log";
	public static final String LOGS_STATUS_UPDATE_WORKING_LOG = "update_working_log";
	public static final String LOGS_STATUS_INSERT_HISTORY = "insert_history";
	
	public static final String STATUS_PENDING = "pending";
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_FAIL = "fail";

	private Constant() {
	}
}
