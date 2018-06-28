package cn.gdj.test.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController相当于@Controller+@ResponseBody
 * @author dell
 *
 */
@RestController
@RequestMapping("hello")
public class HelloController {

	@RequestMapping("/hello1")
	public String hello1(){
		return "Hello1 Word!!!2017-8-21";
	}
	@RequestMapping("/hello2")
	public String hello2(){
		return "hello2 -2017-8-21";
	}
}
