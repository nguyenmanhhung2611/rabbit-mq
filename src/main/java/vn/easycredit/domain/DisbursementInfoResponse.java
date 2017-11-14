package vn.easycredit.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author HienNT
 *
 */
public class DisbursementInfoResponse {

	@JsonProperty("status code")
	private Integer statusCode;

	private DisbursementInfoResponseBody disbursementInfo;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public DisbursementInfoResponseBody getDisbursementInfo() {
		return disbursementInfo;
	}

	public void setDisbursementInfo(DisbursementInfoResponseBody disbursementInfo) {
		this.disbursementInfo = disbursementInfo;
	}

	public DisbursementInfoResponse(Integer statusCode, DisbursementInfoResponseBody disbursementInfo) {
		super();
		this.statusCode = statusCode;
		this.disbursementInfo = disbursementInfo;
	}

	public DisbursementInfoResponse() {
		super();
	}

	public static class DisbursementInfoResponseBody {
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

		public DisbursementInfoResponseBody(String contractNumber, String clientFullName, String clientIdNumber,
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

		public DisbursementInfoResponseBody() {
			super();
		}

	}

}
