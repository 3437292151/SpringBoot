package cn.gdj.test.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.gdj.test.bean.Demo;
import cn.gdj.test.bean.DemoThymeleaf;

import com.mysql.fabric.xmlrpc.base.Array;
@Controller
@RequestMapping("/template")
public class TemplateController {

	
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String,Object> map){
		map.put("hello","from TemplateController.helloHtml");
		System.out.println("helloHtml");
		return"/helloHtml";
	}
	
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloHtml1")
	public ModelAndView helloHtml1(Map<String,Object> map){
		map.put("hello","from TemplateController.helloHtml123");
		List prods = new ArrayList<>();
		DemoThymeleaf demo1 = new DemoThymeleaf();
		demo1.setId(1L);
		demo1.setName("qwe1");
		demo1.setInStock(false);
		DemoThymeleaf demo2 = new DemoThymeleaf();
		demo2.setId(2L);
		demo2.setName("qwe2");
		demo2.setInStock(false);
		DemoThymeleaf demo3 = new DemoThymeleaf();
		demo3.setId(3L);
		demo3.setName("qwe3");
		demo3.setInStock(true);
		prods.add(demo1);
		prods.add(demo2);
		prods.add(demo3);
		map.put("prods", prods);
		ModelAndView mv = new ModelAndView("helloHtml");
		return mv;
	}
	
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloHtml2")
	public String helloHtml2(Map<String,Object> map){
		map.put("hello","from TemplateController.helloHtml123");
		System.out.println("helloHtml2");
		List prods = new ArrayList<>();
		DemoThymeleaf demo1 = new DemoThymeleaf();
		demo1.setId(1L);
		demo1.setName("qwe1");
		demo1.setInStock(true);
		DemoThymeleaf demo2 = new DemoThymeleaf();
		demo2.setId(2L);
		demo2.setName("qwe2");
		demo2.setInStock(false);
		DemoThymeleaf demo3 = new DemoThymeleaf();
		demo3.setId(3L);
		demo3.setName("qwe3");
		demo3.setInStock(true);
		prods.add(demo1);
		prods.add(demo2);
		prods.add(demo3);
		map.put("prods", prods);
		//ModelAndView mv = new ModelAndView("helloHtml");
		return "/helloHtml";
	}
	
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloFtl")
	public ModelAndView helloFtl(Map<String,Object> map){
		map.put("name","from TemplateController.helloHtml123");
		ModelAndView mv = new ModelAndView("helloFtl");
		return mv;
	}
}
