package mvc.sprite;

import mvc.Config;

public class Goban extends Sprite implements Config.SPRITE.GOBAN {

  static {
    Sprite.shareImage("Goban", IMAGE_URL, 0, WIDTH);
  }

  public Goban() {
    super("Goban", POS_X, POS_Y);
  }

}
