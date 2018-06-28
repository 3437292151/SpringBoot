package cn.gdj.test.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gdj.test.bean.Demo;
import cn.gdj.test.dao.Demo2Repository;
import cn.gdj.test.dao.DemoDao;
import cn.gdj.test.dao.DemoRepository;
import cn.gdj.test.mapper.DemoMapper;

@Service
public class DemoService {

	@Resource
	private DemoRepository demoRepository;
	@Resource
	private DemoDao demoDao;
	@Resource
	private Demo2Repository demo2Repository;
	@Autowired
	private DemoMapper demoMapper;
	
	@Transactional
	public void sava(Demo demo){
		demoRepository.save(demo);
	}
	
	public Demo getById(long id){
		Demo demo = demoDao.getById(id);
		return demo;
	}
	
	public Iterable<Demo> getAll(){
		return demoRepository.findAll();
	}
	
	public Demo findById(Long id){
		return demo2Repository.findById(id);
	}
	
	public Demo findMyId(Long id){
		return demo2Repository.findMyId(id);
	}
	
	public List<Demo> findByName(String name){
		return demoMapper.findByName(name);
	}
	
	public Demo findBybatisId(long id){
		return demoMapper.findById(id);
	}
	
	public void saveDemo(Demo demo){
		demoMapper.saveDemo(demo);
	}
}
