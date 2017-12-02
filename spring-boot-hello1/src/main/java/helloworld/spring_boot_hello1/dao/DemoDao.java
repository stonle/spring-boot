package helloworld.spring_boot_hello1.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import helloworld.spring_boot_hello1.bean.Demo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
/**
 * 1、在pom.xml加入jdbcTemplate的依赖
 * 2、编写DemoDao类，声明为：@Repository，引入JdbcTemplate
 * 3、编写DemoService类，引入DemoDao进行使用
 * 4、编写Demo2Controller进行简单测试
 * @author Administrator
 *
 */
@Repository
public class DemoDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
    /**
     * 通过id获取demo对象.
     * @param id
     * @return
     */
	public Demo getById(long id){
		String sql = "select * from demo where id=?";
		RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
}
