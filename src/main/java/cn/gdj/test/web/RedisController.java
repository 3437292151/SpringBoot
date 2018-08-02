package cn.gdj.test.web;

import cn.gdj.test.pojo.PowerOnAttribValue;
import cn.gdj.test.pojo.User;
import cn.gdj.test.service.RedisService;
import com.github.pagehelper.Page;
import net.logstash.logback.encoder.org.apache.commons.lang.builder.ReflectionToStringBuilder;
import net.logstash.logback.encoder.org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by dell on 2018-7-30.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/hello")
    public String hello(String key,String value){
        redisService.hello(key,value);
        return "redis hello";
    }

    @GetMapping("/hello/get")
    public String get(String key){
        String value = redisService.get(key);
        return value;
    }

    @PostMapping("/users")
    public String create(@Valid @RequestBody User user){
        System.out.println(user);
        redisService.create(user);
        return "添加成功";
    }

    @GetMapping("/users")
    public User getUser(String key){

        User user = redisService.getUser(key);
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.DEFAULT_STYLE));
        return user;
    }

    @GetMapping("/users/list")
    public List<User> getUsers(String key){
        List<User> users = redisService.getUserList(key);
        return users;
    }

    @PostMapping("/powerOnAttribValues")
    public List<PowerOnAttribValue> createPowerOnAttribValue(String key){
        List<PowerOnAttribValue> powerOnAttribValueList = redisService.createPowerOnAttribValue(key);
        return powerOnAttribValueList;
    }

    @GetMapping("/powerOnAttribValues/page")
    public Page<PowerOnAttribValue> getPowerOnAttribValuePage(Pageable pageable){
        Page<PowerOnAttribValue> powerOnAttribValuePage = redisService.getPowerOnAttribValuePage(pageable);
        return powerOnAttribValuePage;
    }

    @GetMapping("/powerOnAttribValues")
    public List<PowerOnAttribValue> getPowerOnAttribVauleAll(){
        long start = System.currentTimeMillis();
        List<PowerOnAttribValue> powerOnAttribValueList = redisService.getPowerOnAttribValueAll();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(powerOnAttribValueList.size());
        return powerOnAttribValueList;
    }

    @GetMapping("/powerOnAttribValues/redis")
    public List<PowerOnAttribValue> getPowerOnAttribValueAllByRedis(){
        long start = System.currentTimeMillis();
        List<PowerOnAttribValue> powerOnAttribValueList = redisService.getPowerOnAttribValueAllByRedis();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(powerOnAttribValueList.size());
        return powerOnAttribValueList;
    }

}
