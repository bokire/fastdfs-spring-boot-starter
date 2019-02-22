package com.github.bokire.fastdfs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import com.github.bokire.fastdfs.util.FastDfsClient;
import com.github.bokire.fastdfs.util.PoolConfig;

@ConfigurationProperties(prefix = "spring.fastdfs")
public class FastDfsProperties {

	@NestedConfigurationProperty
	private FastDfsClient client;

	@NestedConfigurationProperty
	private PoolConfig pool;
	
	public FastDfsClient getClient() {
		return client;
	}

	public void setClient(FastDfsClient client) {
		this.client = client;
	}

	public PoolConfig getPool() {
		return pool;
	}

	public void setPool(PoolConfig pool) {
		this.pool = pool;
	}
	
}
