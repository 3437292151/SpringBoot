package cn.gdj.test.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class MybatisConfigution {

	@Bean
	public PageHelper pageHelper(){
		System.out.println("pageHelper()");
		PageHelper pageHepler = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pageHepler.setProperties(p);
		return pageHepler;
	}
}
