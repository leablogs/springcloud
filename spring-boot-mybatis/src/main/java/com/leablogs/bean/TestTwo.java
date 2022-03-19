package com.leablogs.bean;

import java.io.Serializable;

public class TestTwo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7810568568553893031L;
	private Integer id;
	private String nickname;
	private Integer oneId;
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
	public Integer getOneId() {
		return oneId;
	}
	public void setOneId(Integer oneId) {
		this.oneId = oneId;
	}
	public TestOne getTestOne() {
		return testOne;
	}
	public void setTestOne(TestOne testOne) {
		this.testOne = testOne;
	}
	private TestOne testOne;
}
