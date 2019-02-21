package com.github.bokire.fastdfs.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.csource.fastdfs.TrackerServer;

public class ConnectionPool extends GenericObjectPool<TrackerServer> {

    public ConnectionPool(PooledObjectFactory<TrackerServer> factory) {
        super(factory);
    }

    public ConnectionPool(PooledObjectFactory<TrackerServer> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

    public ConnectionPool(PooledObjectFactory<TrackerServer> factory, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
