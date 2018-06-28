package cn.gdj.test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class DemoThymeleaf {
	private Long id;
	private String name;
	private boolean inStock;
	
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
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	@Override
	public String toString() {
		return "DemoThymeleaf [id=" + id + ", name=" + name + ", inStock="
				+ inStock + "]";
	}
	
}
