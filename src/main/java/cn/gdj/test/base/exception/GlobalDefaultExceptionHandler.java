package cn.gdj.test.base.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
/**
 * 1.创建一个calss GlobalDefaultExceptionHandler并添加注解@ControllerAdvice
 * 2.创建一个方法添加注解@ExceptionHandler拦截相应的异常信息
 * 3.如果返回值是View ---则返回的是ModelAndView
 * 4.如果返回值为String或者Json ，则要在方法上添加@ResponseBody注解
 * @author dell
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class) 
	@ResponseBody
	public String defaultErroHandler(HttpServletRequest req, Exception e){
		System.out.println("GlobalDefaultExceptionHandler.defaultErroHandler()");
		//打印异常信息
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return "对不起，出错了！！！！";
	}
	@ExceptionHandler(ArithmeticException.class) 
	@ResponseBody
	public ModelAndView defaultZeroErroHandler(HttpServletRequest req, Exception e){
		System.out.println("GlobalDefaultExceptionHandler.defaultZeroErroHandler()");
		//打印异常信息
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.html");
		return mv;
	}
}
