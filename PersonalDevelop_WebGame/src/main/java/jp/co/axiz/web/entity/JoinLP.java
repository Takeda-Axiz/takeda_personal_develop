package jp.co.axiz.web.entity;

import java.io.Serializable;

public class JoinLP implements Serializable {
	/*---  Field  ---*/
	private String rank;
	private String score;
	private String userName;

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	/*---  Method End  ---*/
}

