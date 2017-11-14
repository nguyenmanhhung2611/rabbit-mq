package vn.easycredit.config.setting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Property settings for API IMX, prefix is "imx-api".
 * 
 * 
 * @author HienNT
 */
@Component
@ConfigurationProperties(prefix = "imx-api")
public class ImxApiSetting {
	private String disbursementInfoUrl;
	private int timeout;

	public String getDisbursementInfoUrl() {
		return disbursementInfoUrl;
	}

	public void setDisbursementInfoUrl(String disbursementInfoUrl) {
		this.disbursementInfoUrl = disbursementInfoUrl;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public ImxApiSetting(String disbursementInfoUrl, int timeout) {
		super();
		this.disbursementInfoUrl = disbursementInfoUrl;
		this.timeout = timeout;
	}

	public ImxApiSetting() {
		super();
	}

}
