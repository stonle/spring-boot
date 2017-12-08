package helloworld.spring_boot_hello1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 如我新建一个wisely.properties
 * @author Administrator
 *
 */
@ConfigurationProperties(prefix="wisely",locations = "classpath:config/wisely.properties")
public class WiselySettings {
	private String name;
    private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
