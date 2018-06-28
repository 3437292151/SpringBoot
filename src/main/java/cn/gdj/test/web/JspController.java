package cn.gdj.test.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/jsp")
public class JspController {
	// 从application.properties 中读取配置，如取不到默认值为Hello Shanhy
	@Value("${application.hello:Hello Angel}")
	private String hello;
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloJsp1")
	public ModelAndView helloJsp1(Map<String,Object> map){
		map.put("name","from TemplateController.helloHtml");
		ModelAndView mv = new ModelAndView("index");
		System.out.println("/helloJsp1");
		return mv;
	}
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloJsp")
	public String helloJsp(Map<String,Object> map){
		map.put("name","from TemplateController.helloHtml123");
		ModelAndView mv = new ModelAndView("index");
		System.out.println(hello);
		return "index";
	}
}
