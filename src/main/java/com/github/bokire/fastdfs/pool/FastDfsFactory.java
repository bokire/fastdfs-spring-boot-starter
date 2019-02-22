package com.github.bokire.fastdfs.pool;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.github.bokire.fastdfs.exceptions.FastDfsPoolException;
import com.github.bokire.fastdfs.util.FastDfsClient;

public class FastDfsFactory extends BasePooledObjectFactory<TrackerServer> {

	private Logger logger = LoggerFactory.getLogger(FastDfsFactory.class);

	public void initClientGlobal(FastDfsClient client) {
		// set connectTimeout
		int connectTimeout = client.getConnectTimeout();
		if (connectTimeout < 0) {
			connectTimeout = 5;
		}
		ClientGlobal.setG_connect_timeout(connectTimeout * 1000);

		// set networkTimeout
		int networkTimeout = client.getNetworkTimeout();
		if (networkTimeout < 0) {
			networkTimeout = 30;
		}
		ClientGlobal.setG_network_timeout(networkTimeout * 1000);

		// set charset
		String charset = client.getCharset();
		if (StringUtils.isEmpty(charset)) {
			charset = "ISO8859-1";
		}
		ClientGlobal.setG_charset(charset);

		String trackerServer = client.getTrackerServer();
		if (!StringUtils.isEmpty(trackerServer)) {
			String[] szTrackerServers = trackerServer.split(";");
			InetSocketAddress[] tracker_servers = new InetSocketAddress[szTrackerServers.length];
			for (int i = 0; i < szTrackerServers.length; i++) {
				String[] parts = szTrackerServers[i].split("\\:", 2);
				if (parts.length != 2) {
					throw new FastDfsPoolException(
							"the value of item \"tracker_server\" is invalid, the correct format is host:port");
				}
				tracker_servers[i] = new InetSocketAddress(parts[0].trim(), Integer.parseInt(parts[1].trim()));
			}

			ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));

		}

		// set token
		String antiStealToken = client.getAntiStealToken().trim().toLowerCase();

		if ("true".equals(antiStealToken) || "1".equals(antiStealToken) || "yes".equals(antiStealToken)) {
			ClientGlobal.setG_secret_key(client.getSecretKey());
		}
	}

	public FastDfsFactory(FastDfsClient client) {
		initClientGlobal(client);
	}

	@Override
	public TrackerServer create() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("create TrackerServer ...");
		}
		TrackerServer trackerServer = null;

		if (ClientGlobal.getG_tracker_group() != null) {
			TrackerClient trackerClient = new TrackerClient();
			try {
				trackerServer = trackerClient.getConnection();
				if (trackerServer != null) {
					ProtoCommon.activeTest(trackerServer.getSocket());
				}
			} catch (IOException e) {
				if (trackerServer != null) {
					trackerServer.close();
				}
				logger.error("connect to fastdfs server fail...", e);
				throw new FastDfsPoolException("connect to fastdfs server fail...", e);
			}

		} else {
			throw new FastDfsPoolException("can't create TrackerServer before you init the ClientGlobal");
		}
		return trackerServer;

	}

	@Override
	public PooledObject<TrackerServer> wrap(TrackerServer trackerServer) {
		return new DefaultPooledObject<TrackerServer>(trackerServer);
	}

	@Override
	public void destroyObject(PooledObject<TrackerServer> p) {
		final TrackerServer trackerServer = p.getObject();
		if (trackerServer != null) {
			try {
				trackerServer.close();
			} catch (IOException e) {
				logger.error("destroy TrackerServer fail", e);
				throw new FastDfsPoolException("destroy TrackerServer fail");
			}
		}
	}

	
	@Override
	public boolean validateObject(PooledObject<TrackerServer> p) {
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
		// Not sure what todo right now.
		super.activateObject(p);
	}

	@Override
	public void passivateObject(PooledObject<TrackerServer> p) throws Exception {
		// Not sure what todo right now.
		super.passivateObject(p);
	}
}
