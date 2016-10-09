package com.vnet.pojo;

public class Stu {

	private Integer uid;
	private String uname;
	private String uno;
	private Double score;

	public Stu() {
		super();
	}

	public Stu(Integer uid, String uname, String uno, Double score) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uno = uno;
		this.score = score;
	}

	public Integer getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public String getUno() {
		return uno;
	}

	public Double getScore() {
		return score;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
