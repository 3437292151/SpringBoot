package cn.gdj.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import cn.gdj.test.bean.Demo;

public interface DemoMapper {

	//#{name}占位符部会存在sql注入，$存在sql注入
	@Select("select * from demo where name=#{name}")
	public List<Demo> findByName(String name);
	
	@Select("select * from demo where id=#{id}")
	public Demo findById(Long id);
	
	@Insert("insert into demo(name,time) values(#{name},#{time}) ")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	public void saveDemo(Demo demo);
}
