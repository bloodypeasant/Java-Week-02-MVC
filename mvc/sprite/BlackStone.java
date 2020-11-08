package mvc.sprite;

import mvc.Config;

public class BlackStone extends Stone implements Config.SPRITE.BLACK_STONE {

  static {
    Sprite.shareImage("BlackStone", Config.SPRITE.BLACK_STONE.IMAGE_URL, 0, Config.SPRITE.BLACK_STONE.WIDTH);
  }

  public BlackStone(int row, int col) {
    super("BlackStone", row, col);
  }
}
