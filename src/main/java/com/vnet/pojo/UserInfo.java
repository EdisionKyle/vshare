package com.vnet.pojo;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.vnet.utils.JsonDateSerializer;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Integer age;
	private String job;
	private Date birth;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getJob() {
		return job;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", age=" + age
				+ ", job=" + job + ", birth=" + birth + "]";
	}

}
