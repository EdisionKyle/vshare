package com.vnet.netty;

import java.io.Serializable;

/**
 * Netty复杂对象传输
 * 
 * @author Administrator
 *
 */
public class NettyUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uno;
	private String name;
	private Integer age;
	private Double salary;

	public NettyUser() {
		super();
	}

	public NettyUser(String uno, String name, Integer age, Double salary) {
		super();
		this.uno = uno;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getUno() {
		return uno;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "NettyUser [uno=" + uno + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}

}
