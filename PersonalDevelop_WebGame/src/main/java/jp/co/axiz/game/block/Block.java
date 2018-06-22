package jp.co.axiz.game.block;

import jp.co.axiz.game.Common;
import jp.co.axiz.game.entity.Position;

public abstract class Block implements Common {

	private Position position;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	// Blockを左に移動
	public void MoveLeft(){
		this.position.setxPos(this.position.getxPos() - 1);
	}

	public abstract void ReadBlock();
}
