package com.leablogs.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;
public class TestOne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3014532216324906982L;
	
	private Integer id;
	private String nickname;
	private Integer age;
	private String rank;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	private List<TestTwo> testTwos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public List<TestTwo> getTestTwos() {
		return testTwos;
	}
	public void setTestTwos(List<TestTwo> testTwos) {
		this.testTwos = testTwos;
	}

}
