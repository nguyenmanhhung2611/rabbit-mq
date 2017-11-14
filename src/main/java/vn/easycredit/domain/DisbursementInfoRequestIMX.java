package vn.easycredit.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DisbursementInfoRequestIMX extends DisbursementInfoRequest {
	@Valid
	@NotNull
	private String authenKey;

	public String getAuthenKey() {
		return authenKey;
	}

	public void setAuthenKey(String authenKey) {
		this.authenKey = authenKey;
	}

	public DisbursementInfoRequestIMX(String keyCode, String clientId, String contractNumber, String partnerCode,
			String authenKey) {
		super(keyCode, clientId, contractNumber, partnerCode);
		this.authenKey = authenKey;
	}

	public DisbursementInfoRequestIMX() {
		super();
	}
}
