package com.github.bokire.fastdfs;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.github.bokire.fastdfs.core.FastDfsTemplate;
import com.github.bokire.fastdfs.pool.ConnectionFactory;

@Configuration
@EnableConfigurationProperties(FastDfsProperties.class)
public class FastDfsAutoConfiguration {

	@Autowired
	private FastDfsProperties fastDfsProperties;

	/**
	 * init fastdfs global config
	 * @throws Exception
	 */
	@PostConstruct
	public void init() throws Exception {
		// set connectTimeout
		int connectTimeout = fastDfsProperties.getConnectTimeout();
		if (connectTimeout < 0) {
			connectTimeout = 5;
		}
		ClientGlobal.setG_connect_timeout(connectTimeout * 1000);

		// set networkTimeout
		int networkTimeout = fastDfsProperties.getNetworkTimeout();
		if (networkTimeout < 0) {
			networkTimeout = 30;
		}
		ClientGlobal.setG_network_timeout(networkTimeout * 1000);

		// set charset
		String charset = fastDfsProperties.getCharset();
		if (StringUtils.isEmpty(charset)) {
			charset = "ISO8859-1";
		}
		ClientGlobal.setG_charset(charset);

		String trackerServer = fastDfsProperties.getTrackerServer();
		if (!StringUtils.isEmpty(trackerServer)) {
			String[] szTrackerServers = trackerServer.split(";");
			InetSocketAddress[] tracker_servers = new InetSocketAddress[szTrackerServers.length];
			for (int i = 0; i < szTrackerServers.length; i++) {
				String[] parts = szTrackerServers[i].split("\\:", 2);
				if (parts.length != 2) {
					throw new MyException(
							"the value of item \"tracker_server\" is invalid, the correct format is host:port");
				}
				tracker_servers[i] = new InetSocketAddress(parts[0].trim(), Integer.parseInt(parts[1].trim()));
			}

			ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));

		}

		// set token
		String antiStealToken = fastDfsProperties.getAntiStealToken().toLowerCase();

		if ("true".equals(antiStealToken) || "1".equals(antiStealToken) || "yes".equals(antiStealToken)) {
			ClientGlobal.setG_secret_key(fastDfsProperties.getSecretKey());
		}
	}
	
	@Bean
	public GenericObjectPool<TrackerServer> genericObjectPool() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setMinIdle(2);
		GenericObjectPool<TrackerServer> objectPool = new GenericObjectPool<TrackerServer>(factory, poolConfig);

		return objectPool;
	}
	
	@Bean
	@ConditionalOnMissingBean(FastDfsTemplate.class)
	// @ConditionalOnProperty(prefix = "spring.fastdfs.trackerServer")
	public FastDfsTemplate fastDfsTemplate() throws Exception {
		return new FastDfsTemplate(genericObjectPool());
	}
}
