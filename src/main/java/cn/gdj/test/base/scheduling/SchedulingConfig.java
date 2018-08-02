package cn.gdj.test.base.scheduling;

import cn.gdj.test.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时任务
 * @author 虞昌龙
 *
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
	
	private final static Logger log = LoggerFactory.getLogger(SchedulingConfig.class);

	@Autowired
	private RedisUtil redisUtil;
	@Scheduled(fixedRate = 1000*1000)//每5秒执行一次
	@Async
	public void schedulder1(){

		redisUtil.set("schedulder1", System.currentTimeMillis());
		log.info(">>>>>>>>SchedulingConfig.schedulder1()");
	}
	
	@Scheduled(fixedRate = 2000*1000)//每5秒执行一次
	@Async
	public void schedulder2(){
		redisUtil.set("schedulder2", System.currentTimeMillis());
		log.info(">>>>>>>>SchedulingConfig.schedulder2()");
	}
}
