package jp.co.axiz.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JoinImg {
	public static void JoinImages(String srcImgPath, String joinImgPath,
			String resultImgPath, boolean isForVertical)
					throws FileNotFoundException, IOException {
		// 変数宣言
		int joinedImageWidth;
		int joinedImageHeight;
		int joinImgXAxis;
		int joinImgYAxis;
		BufferedImage srcImg = ImageIO.read(new FileInputStream(srcImgPath));
		BufferedImage joinImg = ImageIO.read(new FileInputStream(joinImgPath));

		if(isForVertical) {
			joinedImageWidth = srcImg.getWidth();
			joinedImageHeight = srcImg.getHeight() + joinImg.getHeight();

			joinImgXAxis = 0;
			joinImgYAxis = srcImg.getHeight();
		}else {
			joinedImageWidth = srcImg.getWidth() + joinImg.getWidth();
			joinedImageHeight = srcImg.getHeight();

			joinImgXAxis = srcImg.getWidth();
			joinImgYAxis = 0;
		}

		BufferedImage joinedImage = new BufferedImage(joinedImageWidth, joinedImageHeight, srcImg.getType());

		Graphics graphics = joinedImage.getGraphics();
		graphics.drawImage(srcImg, 0, 0, null);

		graphics.drawImage(joinImg, joinImgXAxis, joinImgYAxis, null);
		graphics.dispose();

		ImageIO.write(joinedImage, Common.EXTENSION, new File(resultImgPath));

	}
}