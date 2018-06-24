package jp.co.axiz.game;

public interface Common {
	public static final Integer MAXAREA = 7;

	public static final String EXTENSION = ".png";

	public BlockType getBlockType();

	public static enum BlockType {
		/** ベースブロック */
		BASEBLOCK,
		/** プレイヤーブロック */
		PLAYERBLOCK,
		/** ブラックブロック */
		BLACKBLOCK,
		/** ホワイトブロック */
		WHITEBLOCK,
		/** アウトプットブロック */
		OUTPUTBLOCK;
	}
}
