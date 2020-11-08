package mvc.sprite;

import mvc.Config;
import mvc.Config.SPRITE.GOBAN;

public abstract class Stone extends Sprite implements Config.SPRITE.GOBAN {

  private int row, col;

  public Stone(String sharedImageKey, int row, int col) {
    super(sharedImageKey, (int) Math.round(GOBAN.MARGIN_X + GOBAN.COL_WIDTH * col),
        (int) Math.round(GOBAN.MARGIN_Y + GOBAN.ROW_HEIGHT * row));
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

}
