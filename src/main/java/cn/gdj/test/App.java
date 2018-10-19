package cn.gdj.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
// extends WebMvcAutoConfigurationAdapter
@RestController
@SpringBootApplication
@ServletComponentScan
@MapperScan({"cn.gdj.test.mapper","cn.gdj.test.dao"})//扫描该包下的类
public class App extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	@RequestMapping("/hello")
	public String hello(){
		
		return "Hello Word!!!";
	}
	/*
	 * 要使用第三方的json解析框架：
	 * 1.在pom.xml中引入相应的依赖；
	 * 2.需要在App.java中
	 *   （1）继承 WebMvcAutoConfigurationAdapter重写configureMessageConverters（）；
	 *   	   添加第三方json解析框架
	 *   （2）@Bean注入第三方的json解析框架：
	 * @Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		
		//1.需要先定义一个convert转换消息对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
		//2.添加fastJson的配置信息，比如：是否要格式化返回的json数据；
		FastJsonConfig fastConfig = new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastConfig);
		
		//4.将convert添加到converts
		converters.add(fastConverter);
	}*/
	@Bean
	public HttpMessageConverters fastHttpMessageConverters(){
		//1.需要先定义一个convert转换消息对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//2.添加fastJson的配置信息，比如：是否要格式化返回的json数据；
		FastJsonConfig fastConfig = new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastConfig);
		//4.将convert转换为HttpMessageConverter
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
	
	/**
	 * 
	 * 这是springloaded的配置：-javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
		/*SpringApplication application = new SpringApplication(App.class);
		//application.setShowBanner(false);
		application.run(args); */

	}
}
