package jp.co.axiz.game;

import java.applet.Applet;
import java.awt.Image;

import jp.co.axiz.game.Common.BlockType;

public class SetImg extends Applet{

	private final String FILEPATH = "../../../../WEB-INF/img/";

	public SetImg() {
	}

	public String getPath(BlockType setBlockType) {
		String imgName;

		switch(setBlockType) {
		case PLAYERBLOCK:
			imgName = "PlayerBlock";
			break;
		case WHITEBLOCK:
			imgName = "WhiteBlock";
			break;
		case BLACKBLOCK:
			imgName = "BlackBlock";
			break;
		case OUTPUTBLOCK:
			imgName = "OutputBlock";
			break;
		case BASEBLOCK:
		default:
			imgName = "BaseBlock";
			break;
		}

		return FILEPATH + imgName + Common.EXTENSION;
	}

	public Image getImg(BlockType setBlockType){
		return getImage(getCodeBase(), getPath(setBlockType));
	}
}
