package mvc.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mvc.App;
import mvc.Config;
import mvc.utilities.Phaseable;

public class Controller extends MouseAdapter implements Phaseable, Config.SPRITE.GOBAN {

  public App app;

  public Controller(App app) {
    trace(this);
    this.app = app;
  }

  public void mouseClicked(MouseEvent me) {
    trace(this);
    int col, row;
    if (me.getX() < MARGIN_X) {
      col = 0;
    } else if (me.getX() > WIDTH - MARGIN_X) {
      col = COLS - 1;
    } else {
      col = (int) ((me.getX() - MARGIN_X + COL_WIDTH / 2) / COL_WIDTH);
    }
    if (me.getY() < MARGIN_Y) {
      row = 0;
    } else if (me.getY() > HEIGHT - MARGIN_Y) {
      row = ROWS - 1;
    } else {
      row = (int) ((me.getY() - MARGIN_Y + ROW_HEIGHT / 2) / ROW_HEIGHT);
    }
    System.out.println("Detected mouse click at row = " + row + ", col = " + col);
    app.model.setIntersection(row, col);
    app.view.update();
  }

}
