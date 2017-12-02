package helloworld.spring_boot_hello1.dao;

import org.springframework.data.repository.CrudRepository;

import helloworld.spring_boot_hello1.bean.Demo;

/**  
 *  1、创建实体类Demo,如果已经存在，可以忽略。
 *  2、创建jpa repository类操作持久化。
 *  3、创建service类
 *  4、创建restful请求类。
 *  
 *  在CrudRepository自带常用的crud方法.
 *  
 *  这样一个基本dao就写完了
 * @author Administrator
 * 
 * 另外就是在Spring Data的核心接口里面Repository是最基本的接口了, spring提供了很多实现了该接口的基本接口,
 * 如:CrudRepository，PagingAndSortingRepository，SimpleJpaRepository，QueryDslJpaRepository等大量查询
 * 接口
 *
 */
public interface DemoRepository extends CrudRepository<Demo, Long>{

}
