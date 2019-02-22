package com.github.bokire.fastdfs.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.csource.fastdfs.TrackerServer;

public class FastDfsPool extends FastDfsPoolAbstract {

	public FastDfsPool() {
	    super();
	  }

	public FastDfsPool(GenericObjectPoolConfig poolConfig, PooledObjectFactory<TrackerServer> factory) {
	    super(poolConfig, factory);
	  }

	@Override
	public void returnBrokenResource(TrackerServer trackerServer) {
		super.returnBrokenResource(trackerServer);
	}

	@Override
	public void returnResource(TrackerServer trackerServer) {
		super.returnResource(trackerServer);
	}
}
