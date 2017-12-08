package helloworld.spring_boot_hello1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 我们还可以通过@ConfigurationProperties 读取application属性配置文件中的属性。
 * @author Administrator
 * 它就是以spring.data.mongodb作为前缀的属性，然后通过名字直接映射为对象的属性，同时还包含了一些默认值。如
 * 果不配置，那么mongo.uri就是mongodb://localhost/test。
 */
@ConfigurationProperties(prefix="spring.data.mongodb")
public class MongoProperties {
	private String host;
	private int port;
	private String uri = "mongodb://localhost/test";
	private String database;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
	
}
