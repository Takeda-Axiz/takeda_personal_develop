package jp.co.axiz.game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import jp.co.axiz.game.block.Block;
import jp.co.axiz.game.block.OutputBlock;
import jp.co.axiz.game.entity.Position;

public class ImgMergeCol {

	private Position imgPos;

	Block opBlock = new OutputBlock();

	SetImg setting = new SetImg();

	public void MergeCol(List<Block> list) {
		Boolean isSetFlg = false;
		Block srcBlock = null;
		Block destBlock = null;

		try {
			for(Block block : list) {
				if(isSetFlg == false) {
					srcBlock = block;
					isSetFlg = true;
				}else {
					destBlock = block;
					JoinImg.JoinImages(setting.getPath(srcBlock.getBlockType()),
							setting.getPath(destBlock.getBlockType()),
							setting.getPath(opBlock.getBlockType()), true);
					srcBlock = opBlock;
				}
			}
		}catch(FileNotFoundException eFNF) {
			eFNF.printStackTrace();
		}catch(IOException eIO) {
			eIO.printStackTrace();
		}
	}

	public Position getImgPos() {
		return imgPos;
	}

	public void setImgPos(Position imgPos) {
		this.imgPos = imgPos;
	}
}
