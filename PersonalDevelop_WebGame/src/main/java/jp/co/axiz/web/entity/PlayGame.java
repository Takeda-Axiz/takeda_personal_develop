package jp.co.axiz.web.entity;

import java.io.Serializable;

public class PlayGame implements Serializable {

	/*---  Field  ---*/
	private Integer playCnt;
	private String userId;
	private String gameId;
	private String score;
	private String date;

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public Integer getPlayCnt() {
		return playCnt;
	}

	public void setPlayCnt(Integer playCnt) {
		this.playCnt = playCnt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {
		this.userId = id;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/*---  Method End  ---*/
}
