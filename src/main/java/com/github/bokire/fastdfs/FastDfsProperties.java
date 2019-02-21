package com.github.bokire.fastdfs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.fastdfs")
public class FastDfsProperties {

	private String charset;

	private int connectTimeout;
	
	private int networkTimeout;

	private String antiStealToken;
	
	private String secretKey;

	private String trackerServer;

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getNetworkTimeout() {
		return networkTimeout;
	}

	public void setNetworkTimeout(int networkTimeout) {
		this.networkTimeout = networkTimeout;
	}

	public String getAntiStealToken() {
		return antiStealToken;
	}

	public void setAntiStealToken(String antiStealToken) {
		this.antiStealToken = antiStealToken;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getTrackerServer() {
		return trackerServer;
	}

	public void setTrackerServer(String trackerServer) {
		this.trackerServer = trackerServer;
	}

}
