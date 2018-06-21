package jp.co.axiz.game;

public abstract class Block {

	private Integer XPos;
	private Integer YPos;

	public Integer getXPos() {
		return XPos;
	}

	public void setXPos(Integer xPos) {
		XPos = xPos;
	}

	public Integer getYPos() {
		return YPos;
	}

	public void setYPos(Integer yPos) {
		YPos = yPos;
	}

	// Blockを左に移動
	public void MoveLeft(){
		this.XPos = this.XPos - 1;
	}

	public abstract void AddBlock();
}
