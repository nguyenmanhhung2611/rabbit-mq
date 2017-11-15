package vn.easycredit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import vn.easycredit.constant.Constant;
import vn.easycredit.domain.DisbursementInfoRequest;
import vn.easycredit.domain.DisbursementInfoResponse;
import vn.easycredit.domain.ErrorResponse;
import vn.easycredit.service.DisbursementInfoService;

/**
 * Controller
 * 
 * @author HienNT
 */

@RestController
public class DisbursementController {

	@Autowired
	private DisbursementInfoService disbursementInfoService;

	@ApiOperation(value = "Check Debursement Info", notes = "Check Debursement Info.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SUCCESS_MESSAGE, response = DisbursementInfoResponse.class),
			@ApiResponse(code = 400, message = Constant.BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/api/disbursementService/v1/checkContractInfo", method = RequestMethod.POST)
	public DisbursementInfoResponse checkContractInfo(@Valid @RequestBody DisbursementInfoRequest info) throws Exception {
		//send message logs request to rabbitMQ
		disbursementInfoService.insertLogInfo(info);
		
		return new DisbursementInfoResponse(Constant.RESPONSE_SUCCESS, disbursementInfoService.getDisbursementInfo(info));
	}
	
	@ApiOperation(value = "Check Debursement Info", notes = "Check Debursement Info.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SUCCESS_MESSAGE, response = DisbursementInfoResponse.class),
			@ApiResponse(code = 400, message = Constant.BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/api/disbursementService/v1/disburseSucceed", method = RequestMethod.POST)
	public DisbursementInfoResponse disburseSucceed(@Valid @RequestBody DisbursementInfoRequest info) throws Exception {
		//send message logs request to rabbitMQ
		disbursementInfoService.insertLogSuccess(info);
		
		return new DisbursementInfoResponse(Constant.RESPONSE_SUCCESS, disbursementInfoService.getDisbursementInfo(info));
	}
}
