package vn.easycredit.domain;

import java.util.Map;

/**
 * 
 * @author HienNT
 * @param <T>
 *
 */
public class LogsInfoRequest<T> {

	private String inflowApi;
	private Map<String, String> header;
	private T body;

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

	public LogsInfoRequest(String inflowApi, Map<String, String> header, T body) {
		super();
		this.inflowApi = inflowApi;
		this.header = header;
		this.body = body;
	}

	public LogsInfoRequest() {
		super();
	}

}
