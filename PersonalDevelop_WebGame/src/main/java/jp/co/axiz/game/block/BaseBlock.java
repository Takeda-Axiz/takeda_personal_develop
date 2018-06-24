package jp.co.axiz.game.block;

import jp.co.axiz.game.SetImg;

public class BaseBlock extends Block {

	SetImg setting = new SetImg();

	@Override
	public void ReadBlock() {
		// Blockを追加
		setting.getImg(getBlockType());
	}

	public void OnPlayer() {
		// GameOver
	}

	@Override
	public BlockType getBlockType() {
		return BlockType.BASEBLOCK;
	}
}
