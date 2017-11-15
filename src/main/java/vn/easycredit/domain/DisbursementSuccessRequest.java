package vn.easycredit.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author HienNT
 *
 */
public class DisbursementSuccessRequest {

	@Valid
	@NotNull
	private String contractNumber;

	@Valid
	@NotNull
	private String clientIdNumber;

	@Valid
	@NotNull
	private Date issueDate;

	@Valid
	@NotNull
	private String issuePlace;

	@Valid
	@NotNull
	private Double moneyAmount;

	@Valid
	@NotNull
	private String moneyUnit;

	@Valid
	@NotNull
	private String partnerCode;

	@Valid
	@NotNull
	private String clientFullname;

	@Valid
	@NotNull
	private Date disbursementDate;

	@Valid
	@NotNull
	private String note;

	@Valid
	@NotNull
	private String shopCode;

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getClientIdNumber() {
		return clientIdNumber;
	}

	public void setClientIdNumber(String clientIdNumber) {
		this.clientIdNumber = clientIdNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssuePlace() {
		return issuePlace;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public Double getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(Double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	public String getMoneyUnit() {
		return moneyUnit;
	}

	public void setMoneyUnit(String moneyUnit) {
		this.moneyUnit = moneyUnit;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getClientFullname() {
		return clientFullname;
	}

	public void setClientFullname(String clientFullname) {
		this.clientFullname = clientFullname;
	}

	public Date getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public DisbursementSuccessRequest() {
		super();
	}

	public DisbursementSuccessRequest(String contractNumber, String clientIdNumber, Date issueDate, String issuePlace,
			Double moneyAmount, String moneyUnit, String partnerCode, String clientFullname, Date disbursementDate,
			String note, String shopCode) {
		super();
		this.contractNumber = contractNumber;
		this.clientIdNumber = clientIdNumber;
		this.issueDate = issueDate;
		this.issuePlace = issuePlace;
		this.moneyAmount = moneyAmount;
		this.moneyUnit = moneyUnit;
		this.partnerCode = partnerCode;
		this.clientFullname = clientFullname;
		this.disbursementDate = disbursementDate;
		this.note = note;
		this.shopCode = shopCode;
	}

}
