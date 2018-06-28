package cn.gdj.test.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author 虞昌龙
 *
 */
@Entity
public class Demo {
	
	private Long id;
	private String name;
	private Date time;
	/**
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 指定主键的生成策略
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JSONField(format="yyyy-MM-dd HH:mm")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", time=" + time + "]";
	}
}
