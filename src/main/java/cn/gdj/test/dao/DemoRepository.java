package cn.gdj.test.dao;

import org.springframework.data.repository.CrudRepository;

import cn.gdj.test.bean.Demo;

public interface DemoRepository extends CrudRepository<Demo, Long> {

}
