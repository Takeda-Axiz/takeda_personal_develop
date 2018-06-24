package jp.co.axiz.game;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

import jp.co.axiz.game.entity.Position;

public class Views extends Applet{

	private Image img;
	private Position pos;

//	@Override
//	public void init() {
//		this.img = getImage(getCodeBase(), "../../../../WEB-INF/img/BaseBlock.png");
//	}

	public void setInit(Image img, Position pos){
		this.img = img;
		this.pos = pos;
	}

	@Override
	public void paint(Graphics g){
		g.drawImage(img, pos.getxPos(), pos.getyPos(), this);
	}
}
