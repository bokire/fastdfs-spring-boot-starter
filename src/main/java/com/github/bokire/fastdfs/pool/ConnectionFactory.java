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
        //��װʵ�ʶ���
        return new DefaultPooledObject<TrackerServer>(trackerServer);
    }
    
    @Override
    public void destroyObject(PooledObject<TrackerServer> p) throws Exception {
    	p.getObject().close();
    }
 
    /**
	 * �����������ж���Դ�����Ƿ���Ч����Ч���� true����Ч���� false
	 * 
	 * ʲôʱ�����ô˷���
	 * 
	 * 1������Դ���л�ȡ��Դ��ʱ�򣬲��� testOnBorrow ���� testOnCreate ����һ�� ���� Ϊ true ʱ��
	 * 
	 * ����� factory.validateObject() ����.
	 * 
	 * 2������Դ��������Դ�ص�ʱ�򣬲��� testOnReturn������Ϊ true ʱ�����ô˷���.
	 * 
	 * 3����Դ�����̣߳�������Դ��ʱ�򣬲��� testWhileIdle������Ϊ true ʱ�����ô˷���.
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
