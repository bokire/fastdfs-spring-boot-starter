package com.github.bokire.fastdfs.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.github.bokire.fastdfs.util.PoolConfig;

public class FastDfsPoolConfig extends GenericObjectPoolConfig {

	public FastDfsPoolConfig(PoolConfig poolConfig) {
		setMaxWaitMillis(poolConfig.getMaxWaitMillis());
		setMinEvictableIdleTimeMillis(poolConfig.getMinEvictableIdleTimeMillis());
		setSoftMinEvictableIdleTimeMillis(poolConfig.getSoftMinEvictableIdleTimeMillis());
		setNumTestsPerEvictionRun(poolConfig.getNumTestsPerEvictionRun());
		setTestOnCreate(poolConfig.isTestOnCreate());
		setTestOnBorrow(poolConfig.isTestOnBorrow());
		setTestOnReturn(poolConfig.isTestOnReturn());
		setTestWhileIdle(poolConfig.isTestWhileIdle());
		setTimeBetweenEvictionRunsMillis(poolConfig.getTimeBetweenEvictionRunsMillis());
		setBlockWhenExhausted(poolConfig.isBlockWhenExhausted());
		setMaxIdle(poolConfig.getMaxIdle());
		setMaxTotal(poolConfig.getMaxTotal());
		setMinIdle(poolConfig.getMinIdle());
	}
}
