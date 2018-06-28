package cn.gdj.test.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import cn.gdj.test.bean.Demo;

public interface Demo2Repository extends Repository<Demo, Long>{

	/**
	 * 1.查询方法以 get|find|read
	 * 2.涉及查询条件时，条件的属性用条件关键字连接，要注意条件属性要以首字母大写开头
	 */
	public Demo findById(Long id);
	
	/**
	 * 如何编写JPQL语句
	 * JPQL与HQL类似
	 */
	@Query("from Demo where id=:a")
	public Demo findMyId(@Param("a")Long id);
}
