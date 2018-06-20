package jp.co.axiz.web.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

	/*---  Field  ---*/
	private Integer userId;
	private String userName;
	private String telephone;
	private String password;	//変数名概要

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer id) {
		this.userId = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	/*---  Method End  ---*/
}
