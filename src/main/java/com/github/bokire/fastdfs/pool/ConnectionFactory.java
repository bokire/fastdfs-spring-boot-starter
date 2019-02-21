package com.github.bokire.fastdfs.pool;

import java.io.IOException;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConnectionFactory extends BasePooledObjectFactory<TrackerServer> {

	private  Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);
	
    @Override
    public TrackerServer create() throws Exception {
    	if (logger.isDebugEnabled()) {
    		logger.debug("create TrackerServer ...");
    	}
    	TrackerServer trackerServer = null;
		TrackerClient trackerClient = new TrackerClient();
		try {
			trackerServer = trackerClient.getConnection();
			if(trackerServer != null) {
				ProtoCommon.activeTest(trackerServer.getSocket());
			}
		} catch (IOException e) {
			logger.error("connect to fastdfs server fail...", e);
		}
		return trackerServer;
    	
    }

    @Override
    public PooledObject<TrackerServer> wrap(TrackerServer trackerServer) {
        //包装实际对象
        return new DefaultPooledObject<TrackerServer>(trackerServer);
    }
    
    @Override
    public void destroyObject(PooledObject<TrackerServer> p) throws Exception {
    	p.getObject().close();
    }
 
    /**
	 * 功能描述：判断资源对象是否有效，有效返回 true，无效返回 false
	 * 
	 * 什么时候会调用此方法
	 * 
	 * 1：从资源池中获取资源的时候，参数 testOnBorrow 或者 testOnCreate 中有一个 配置 为 true 时，
	 * 
	 * 则调用 factory.validateObject() 方法.
	 * 
	 * 2：将资源返还给资源池的时候，参数 testOnReturn，配置为 true 时，调用此方法.
	 * 
	 * 3：资源回收线程，回收资源的时候，参数 testWhileIdle，配置为 true 时，调用此方法.
	 */
    @Override
    public boolean validateObject(PooledObject<TrackerServer> p) {
    	System.out.println("validateObject");
    	if (logger.isDebugEnabled()) {
    		logger.debug("validate TrackerServer ...");
    	}
    	
    	try {
    		TrackerServer trackerServer = p.getObject();
    		if (trackerServer != null) {
    			return ProtoCommon.activeTest(p.getObject().getSocket());
    		}
		} catch (IOException e) {
			logger.warn("disconnect from fastdfs server...", e);
		}
    	return false;
    }
 
    
    @Override
    public void activateObject(PooledObject<TrackerServer> p) throws Exception {
        super.activateObject(p);
    }
 
    @Override
    public void passivateObject(PooledObject<TrackerServer> p) throws Exception {
        super.passivateObject(p);
    }
}
