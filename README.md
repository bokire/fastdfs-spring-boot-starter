# fastdfs-spring-boot-starter
===================================

[FastDfs](https://github.com/happyfish100/fastdfs) 是一个开源的轻量级分布式文件系统.
FastDfs Spring Boot Starter, 实现连接池功能, 帮助你在Spring-boot快速集成FastDfs开发


### 如何使用

* 下载代码:
```
git clone https://github.com/bokire/fastdfs-spring-boot-starter.git
```

* 安装至本地仓库:

```
mvn clean install
```

* 添加依赖:

```xml
<dependency>
	<groupId>com.github.bokire</groupId>
	<artifactId>fastdfs-spring-boot-starter</artifactId>
	<version>1.0.0-SNAPSHOT</version>
</dependency>
```

* 在application.properties添加fastdfs和连接池的相关配置信息，样例配置如下:

```properties
spring.fastdfs.client.charset=UTF-8
spring.fastdfs.client.trackerServer=127.0.0.1:22122

spring.fastdfs.pool.testOnBorrow=true
```

[更多配置](https://github.com/bokire/fastdfs-spring-boot-starter/wiki/fastdfs-spring-boot-starter%E5%8F%AF%E9%85%8D%E7%BD%AE%E5%B1%9E%E6%80%A7)

* 接下来在Spring Boot 工程中使用fastdfs

```java
@Autowired
private FastDfsTemplate fastDfsTemplate;

@Test
public void testUpload() throws Exception {
    String fileId = fastDfsTemplate.upload_file("D:\\fastdfs.tex", null, null);
    System.out.println(fileId);
}
```

