package jp.co.axiz.web.entity;

import java.io.Serializable;

public class Login implements Serializable {
	/*---  Field  ---*/
	private String userId;
	private String userName;
	private String password;	//変数名概要

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {
		this.userId = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*---  Method End  ---*/
}

