package vn.easycredit.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author HienNT
 *
 */
public class DisbursementInfoRequest {

	@Valid
	@NotNull
	private String keyCode;

	@Valid
	@NotNull
	private String clientId;

	@Valid
	@NotNull
	private String contractNumber;

	@Valid
	@NotNull
	private String partnerCode;
	
	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}
	
	public DisbursementInfoRequest(String keyCode, String clientId, String contractNumber, String partnerCode) {
		super();
		this.keyCode = keyCode;
		this.clientId = clientId;
		this.contractNumber = contractNumber;
		this.partnerCode = partnerCode;
	}

	public DisbursementInfoRequest() {
		super();
	}

}
