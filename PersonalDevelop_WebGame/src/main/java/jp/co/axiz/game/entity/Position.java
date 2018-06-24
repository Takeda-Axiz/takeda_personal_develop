package jp.co.axiz.game.entity;

public class Position {
	/*---  Field  ---*/
	private Integer xPos;
	private Integer yPos;

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	//  処理概要
	public Position() {
		this.xPos = 0;
		this.yPos = 0;
	}

	/*---  Constructor End  ---*/

	public Position(Integer xPos, Integer yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	/*---  Method  ---*/
	//  処理概要
	public Integer getxPos() {
		return xPos;
	}

	public void setxPos(Integer xPos) {
		this.xPos = xPos;
	}

	public Integer getyPos() {
		return yPos;
	}

	public void setyPos(Integer yPos) {
		this.yPos = yPos;
	}

	/*---  Method End  ---*/
}
