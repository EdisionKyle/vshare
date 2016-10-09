package com.vnet.nosql;

import java.io.Serializable;

/**
 * Redis操作对象
 * 
 * @author Administrator
 *
 */
public class RedisUser implements Serializable {

	private static final long serialVersionUID = -4267454839951099635L;

	private String uid;
	private String name;
	private Integer age;

	public RedisUser() {
		super();
	}

	public RedisUser(String uid, String name, Integer age) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
	}

	public String getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
