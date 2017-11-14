package vn.easycredit.service;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.config.setting.ImxApiSetting;
import vn.easycredit.constant.Constant;
import vn.easycredit.controller.EvnProjectApplication;
import vn.easycredit.domain.DisbursementInfoRequest;
import vn.easycredit.domain.DisbursementInfoRequestIMX;
import vn.easycredit.domain.DisbursementInfoResponse.DisbursementInfoResponseBody;
import vn.easycredit.domain.DisbursementInfoResponseIMX;
import vn.easycredit.domain.LogsInfoRequest;
import vn.easycredit.domain.Utilities;
import vn.easycresdit.exception.ImxContractNotFoundException;

/**
 * 
 * @author HienNT
 *
 */
@Slf4j
@Service
public class DisbursementInfoService {

	@Autowired
	private ImxApiSetting imxApiSetting;

	@Autowired
	@Qualifier("imxRestTemplate")
	private RestTemplate imxRestTemplate;
	
	private final RabbitTemplate rabbitTemplate;

	@Autowired
	private HttpServletRequest request;

	public DisbursementInfoService(ImxApiSetting imxApiSetting, RestTemplate imxRestTemplate,
			RabbitTemplate rabbitTemplate, HttpServletRequest request) {
		super();
		this.imxApiSetting = imxApiSetting;
		this.imxRestTemplate = imxRestTemplate;
		this.rabbitTemplate = rabbitTemplate;
		this.request = request;
	}

	// TODO
	/*
	 * request data from MID to IMD for get contract info
	 */

	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	/**
	 * get contract info from IMX api.
	 * 
	 * @param request
	 * @return
	 * @throws ImxContractNotFoundException
	 */
	public DisbursementInfoResponseBody getDisbursementInfo(DisbursementInfoRequest request) throws ImxContractNotFoundException {
		if(Arrays.asList(Utilities.PARTNER_CODE).contains(request.getPartnerCode())){
			DisbursementInfoRequestIMX req = copyPropertiesRequest(request);

			log.info("CheckDisbursementInfoService[get] Start....");
			ResponseEntity<DisbursementInfoResponseIMX> responseEntity = imxRestTemplate
					.postForEntity(imxApiSetting.getDisbursementInfoUrl(), req, DisbursementInfoResponseIMX.class);

			if (HttpStatus.OK != responseEntity.getStatusCode()) {
				throw new ImxContractNotFoundException("Cannot get Imx Disbursement Info from IMX");
			}

			DisbursementInfoResponseBody body = copyPropertiesResponse(responseEntity.getBody());
			return body;
		}
		throw new ImxContractNotFoundException("Cannot get Imx Disbursement Info from IMX");
	}

	private DisbursementInfoRequestIMX copyPropertiesRequest(DisbursementInfoRequest request) {
		DisbursementInfoRequestIMX contract = new DisbursementInfoRequestIMX();
		contract.setClientId(request.getClientId());
		contract.setContractNumber(request.getContractNumber());
		contract.setKeyCode(request.getKeyCode());
		contract.setPartnerCode(request.getPartnerCode());
		// TODO authen key
		contract.setAuthenKey("authenKey");

		return contract;
	}

	private DisbursementInfoResponseBody copyPropertiesResponse(DisbursementInfoResponseIMX res) {
		if (res != null) {
			DisbursementInfoResponseBody contract = new DisbursementInfoResponseBody();

			contract.setClientFullName(res.getDisbursementInfo().getClientFullName());
			contract.setClientIdNumber(res.getDisbursementInfo().getClientIdNumber());
			contract.setContractNumber(res.getDisbursementInfo().getContractNumber());
			contract.setIssuedDate((res.getDisbursementInfo().getIssuedDate()));
			contract.setIssuedPlace(res.getDisbursementInfo().getIssuedPlace());
			contract.setMoneyAmount(res.getDisbursementInfo().getMoneyAmount());
			contract.setResponseCode(res.getDisbursementInfo().getResponseCode());
			contract.setResponseMessage(res.getDisbursementInfo().getResponseMessage());

			return contract;
		}
		return null;
		
	}
	
	/**
	 * prepare param for send message logs request to rabbitMQ
	 * @param logsRequest
	 * @throws Exception
	 */
	public void prepareRequest(DisbursementInfoRequest info) throws Exception{
		LogsInfoRequest<DisbursementInfoRequest> logsRequest = new LogsInfoRequest<>(Constant.DISBURSEMENT_INFO_INFLOW, getHeadersInfo(), info);

		Gson gson = new Gson();
		String jsonInString = gson.toJson(logsRequest);

		run(jsonInString);
	}
	
	/**
	 * send message logs request to rabbitMQ
	 * @param logsRequest
	 * @throws Exception
	 */
	public void run(String logsRequest) throws Exception {
		rabbitTemplate.convertAndSend(EvnProjectApplication.queueName, logsRequest);
	}

	/*
	 * get all param from request header
	 */
	private Map<String, String> getHeadersInfo() {
		Map<String, String> map = new HashMap<String, String>();
		@SuppressWarnings("rawtypes")
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

}
