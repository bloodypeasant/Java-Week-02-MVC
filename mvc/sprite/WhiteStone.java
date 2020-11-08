package mvc.sprite;

import mvc.Config;

public class WhiteStone extends Stone implements Config.SPRITE.WHITE_STONE {

  static {
    Sprite.shareImage("WhiteStone", Config.SPRITE.WHITE_STONE.IMAGE_URL, 0, Config.SPRITE.WHITE_STONE.WIDTH);
  }

  public WhiteStone(int row, int col) {
    super("WhiteStone", row, col);
  }

}
