package cn.gdj.test.service;

import cn.gdj.test.dao.PowerOnAttribValueMapper;
import cn.gdj.test.dao.UserMapper;
import cn.gdj.test.pojo.PowerOnAttribValue;
import cn.gdj.test.pojo.User;
import cn.gdj.test.util.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2018-7-30.
 */
@Service
public class RedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PowerOnAttribValueMapper powerOnAttribValueMapper;

    public void hello(String key, Object value){

        redisUtil.set(key,value);
    }

    public String get(String key) {
        /*RedisConnectionFactory connectionFactory = redisUtil.getRedisTemplate().getConnectionFactory();
        Object nativeConnection = connectionFactory.getConnection().getNativeConnection();
        System.out.println(nativeConnection);*/
        return (String) redisUtil.get(key);
    }

    public void create(User user) {
        redisUtil.lSet("user",user);

    }

    public User getUser(String key) {
        List<Object> objects = redisUtil.lGet(key, 0, 1);
        //Object object = redisUtil.get(key);
        //return (User) object;//
        return (User) objects.get(0);
    }

    public List<User> getUserList(String key) {

        List<User> userList = userMapper.findAll();//(List<User>) redisUtil.get("userObject");
        //List userList1 = redisUtil.lGet("userList", 0L, -1L);

        return userList;
    }

    public List<User> createUser(String key){
        List<User> userList = userMapper.findAll();

        redisUtil.lSet("userList",userList);
        redisUtil.set("userObject",userList);
        //redisUtil.lGet("user",0,0);
        return userList;
    }

    public Page<PowerOnAttribValue> getPowerOnAttribValuePage(Pageable pageable){
        String sort = "";
        //字段排序
        if (pageable.getSort() != null){
            Iterator it = pageable.getSort().iterator();//sort1.iterator();
            while (it.hasNext()){
                sort += it.next() + ", ";
            }
            if(sort.length()>0){
                sort = sort.substring(0,sort.length()-2).replaceAll(":","");
            }
        }
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize() , sort);
        Page<PowerOnAttribValue> powerOnAttribValueList = powerOnAttribValueMapper.findPage();
        System.out.println(powerOnAttribValueList.getTotal());
        return powerOnAttribValueList;
    }



    public List<PowerOnAttribValue> createPowerOnAttribValue(String key) {
        List<PowerOnAttribValue> powerOnAttribValueList = powerOnAttribValueMapper.findAll();
        redisUtil.set(key, powerOnAttribValueList);

        return powerOnAttribValueList;
    }

    public List<PowerOnAttribValue> getPowerOnAttribValueAllByRedis() {
        List<PowerOnAttribValue> powerOnAttribValueList = (List<PowerOnAttribValue>) redisUtil.get("powerOnAttribValues");
        if (powerOnAttribValueList == null || powerOnAttribValueList.size() == 0){
            powerOnAttribValueList = powerOnAttribValueMapper.findAll();
            redisUtil.set("powerOnAttribValues", powerOnAttribValueList);
        }
        return powerOnAttribValueList;
    }

    public List<PowerOnAttribValue> getPowerOnAttribValueAll() {
        List<PowerOnAttribValue> powerOnAttribValueList = powerOnAttribValueMapper.findAll();
        return powerOnAttribValueList;
    }

    public String test(String key){
        Object o = redisUtil.get(key);
        String jsonString = JSONObject.toJSONString(o);
        System.out.println(jsonString);
        return jsonString;
    }
}
