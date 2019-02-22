package com.github.bokire.fastdfs.util;

public class FastDfsClient {

	/**
	 * 字符集，默认为 ISO8859-1
	 */
	private String charset;

	/**
	 * 连接超时时间 ，默认值为5
	 */
	private int connectTimeout = 5;
	
	/**
	 * 网络超时时间 ，默认值为30
	 */
	private int networkTimeout = 30;

	/**
	 * 开启防盗链标识，当值为 'true' 或 '1' 或  'yes' 时开启开启防盗链, 不区分大小写, 默认不开启
	 */
	private String antiStealToken;
	
	/**
	 * 开启防盗链时使用的密钥
	 */
	private String secretKey;

	/**
	 * tracker服务器地址，多个地址用';'隔开， 必填
	 */
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
