package mvc.model;

import mvc.App;
import mvc.Config;
import mvc.sprite.BlackStone;
import mvc.sprite.Stone;
import mvc.sprite.WhiteStone;
import mvc.utilities.Phaseable;

public class Model implements Phaseable, Config.MODEL {

  public App app;
  private Stone[][] board = new Stone[19][19];
  private boolean isBlackTurn;

  public Model(App app) {
    trace(this);
    this.app = app;
  }

  public void init() {
    trace(this);
    isBlackTurn = true;
    for (int row = 0; row < ROWS; ++row) {
      for (int col = 0; col < COLS; ++col) {
        board[row][col] = null;
      }
    }
    // test();
  }

  public Stone getIntersection(int row, int col) {
    return board[row][col];
  }

  public int getNumCols() {
    return Config.MODEL.COLS;
  }

  public int getNumRows() {
    return Config.MODEL.ROWS;
  }

  public boolean setIntersection(int row, int col) {
    if (row < 0 || row > 18 || col < 0 || col > 18 || board[row][col] != null) {
      return false;
    }
    board[row][col] = isBlackTurn ? new BlackStone(row, col) : new WhiteStone(row, col);
    isBlackTurn = !isBlackTurn;
    return true;
  }

  // private void test() {
  // for (int row = 0; row < Config.MODEL.ROWS; ++row) {
  // for (int col = 0; col < Config.MODEL.COLS; ++col) {
  // setIntersection(row, col);
  // }
  // }
  // }

}
