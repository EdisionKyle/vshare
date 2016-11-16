package com.vnet.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Article implements Serializable {

	private static final long serialVersionUID = -3100978814553263282L;
	private Integer id;
	private Integer userId;
	private String title;
	private String abst;
	private String content;
	private Date publishTime;

	public Article() {
		super();
	}

	public Article(Integer id, Integer userId, String title, String abst,
			String content, Date publishTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.abst = abst;
		this.content = content;
		this.publishTime = publishTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbst() {
		return abst;
	}

	public void setAbst(String abst) {
		this.abst = abst;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

}
