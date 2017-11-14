package vn.easycredit.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author HienNT
 *
 */
public class DisbursementInfoResponseIMX {

	@JsonProperty("status code")
	private Integer statusCode;

	private DisbursementInfoResponseIMXBody disbursementInfo;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public DisbursementInfoResponseIMX(Integer statusCode, DisbursementInfoResponseIMXBody disbursementInfo) {
		super();
		this.statusCode = statusCode;
		this.disbursementInfo = disbursementInfo;
	}

	public DisbursementInfoResponseIMXBody getDisbursementInfo() {
		return disbursementInfo;
	}

	public void setDisbursementInfo(DisbursementInfoResponseIMXBody disbursementInfo) {
		this.disbursementInfo = disbursementInfo;
	}

	public DisbursementInfoResponseIMX() {
		super();
	}

	public static class DisbursementInfoResponseIMXBody {
		private String contractNumber;
		private String clientFullName;
		private String clientIdNumber;
		private Date issuedDate;
		private String issuedPlace;
		private Double moneyAmount;
		private Integer responseCode;
		private String responseMessage;

		public String getContractNumber() {
			return contractNumber;
		}

		public void setContractNumber(String contractNumber) {
			this.contractNumber = contractNumber;
		}

		public String getClientFullName() {
			return clientFullName;
		}

		public void setClientFullName(String clientFullName) {
			this.clientFullName = clientFullName;
		}

		public String getClientIdNumber() {
			return clientIdNumber;
		}

		public void setClientIdNumber(String clientIdNumber) {
			this.clientIdNumber = clientIdNumber;
		}

		public Date getIssuedDate() {
			return issuedDate;
		}

		public void setIssuedDate(Date issuedDate) {
			this.issuedDate = issuedDate;
		}

		public String getIssuedPlace() {
			return issuedPlace;
		}

		public void setIssuedPlace(String issuedPlace) {
			this.issuedPlace = issuedPlace;
		}

		public Double getMoneyAmount() {
			return moneyAmount;
		}

		public void setMoneyAmount(Double moneyAmount) {
			this.moneyAmount = moneyAmount;
		}

		public Integer getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(Integer responseCode) {
			this.responseCode = responseCode;
		}

		public String getResponseMessage() {
			return responseMessage;
		}

		public void setResponseMessage(String responseMessage) {
			this.responseMessage = responseMessage;
		}

		public DisbursementInfoResponseIMXBody(String contractNumber, String clientFullName, String clientIdNumber,
				Date issuedDate, String issuedPlace, Double moneyAmount, Integer responseCode, String responseMessage) {
			super();
			this.contractNumber = contractNumber;
			this.clientFullName = clientFullName;
			this.clientIdNumber = clientIdNumber;
			this.issuedDate = issuedDate;
			this.issuedPlace = issuedPlace;
			this.moneyAmount = moneyAmount;
			this.responseCode = responseCode;
			this.responseMessage = responseMessage;
		}

		public DisbursementInfoResponseIMXBody() {
			super();
		}

	}

}
