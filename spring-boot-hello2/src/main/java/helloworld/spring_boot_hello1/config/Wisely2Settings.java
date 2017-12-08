package helloworld.spring_boot_hello1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 若继续在application.properties中添加
 * @author Administrator
 *
 */
@ConfigurationProperties(prefix="wisely2")
public class Wisely2Settings {
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
