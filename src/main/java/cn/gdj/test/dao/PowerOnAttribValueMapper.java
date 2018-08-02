package cn.gdj.test.dao;

import cn.gdj.test.pojo.PowerOnAttribValue;
import com.github.pagehelper.Page;

import java.util.List;

public interface PowerOnAttribValueMapper {
    int insert(PowerOnAttribValue record);

    int insertSelective(PowerOnAttribValue record);

    List<PowerOnAttribValue> findAll();

    Page<PowerOnAttribValue> findPage();

}