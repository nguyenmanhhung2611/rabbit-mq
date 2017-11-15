package vn.easycredit.domain;

import java.util.Map;

/**
 * 
 * @author HienNT
 * @param <T>
 *
 */
public class LogsInfoRequest<T> {
	private String ip;
	private String logStatus;// status insert or update api-logs
	private String uuid;
	private String inflowApi;
	private Map<String, String> header;
	private T body;
	private String status;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getInflowApi() {
		return inflowApi;
	}

	public void setInflowApi(String inflowApi) {
		this.inflowApi = inflowApi;
	}

	public Map<String, String> getHeader() {
		return header;
	}

	public void setHeader(Map<String, String> header) {
		this.header = header;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public LogsInfoRequest(String ip, String logStatus, String uuid, String inflowApi, Map<String, String> header,
			T body, String status) {
		super();
		this.ip = ip;
		this.logStatus = logStatus;
		this.uuid = uuid;
		this.inflowApi = inflowApi;
		this.header = header;
		this.body = body;
		this.status = status;
	}

	public LogsInfoRequest() {
		super();
	}

}
