package com.github.bokire.fastdfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.bokire.fastdfs.core.FastDfsTemplate;
import com.github.bokire.fastdfs.pool.FastDfsFactory;
import com.github.bokire.fastdfs.pool.FastDfsPool;
import com.github.bokire.fastdfs.pool.FastDfsPoolConfig;

@Configuration
@EnableConfigurationProperties(FastDfsProperties.class)
public class FastDfsAutoConfiguration {

	@Autowired
	private FastDfsProperties fastDfsProperties;

	@Bean
	public FastDfsPool fastDfsPool() throws Exception {
		FastDfsFactory factory = new FastDfsFactory(fastDfsProperties.getClient());
		FastDfsPoolConfig poolConfig = new FastDfsPoolConfig(fastDfsProperties.getPool());
		FastDfsPool fastDfsPool = new FastDfsPool(poolConfig, factory);
		return fastDfsPool;
	}
	
	@Bean
	@ConditionalOnMissingBean(FastDfsTemplate.class)
	// @ConditionalOnProperty(prefix = "spring.fastdfs.trackerServer")
	public FastDfsTemplate fastDfsTemplate() throws Exception {
		return new FastDfsTemplate(fastDfsPool());
	}
}
