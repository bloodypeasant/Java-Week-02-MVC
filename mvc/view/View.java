package mvc.view;

import javax.swing.JFrame;

import mvc.App;
import mvc.Config;
import mvc.utilities.Phaseable;

public class View extends JFrame implements Phaseable, Config.VIEW {

  private static final long serialVersionUID = 1L;
  public App app;
  private Board board;

  public View(App app) {
    trace(this);
    this.app = app;
    board = new Board(this);
    add(board);
    setTitle(TITLE);
    if (IS_PACKED) {
      pack();
    } else {
      setSize(UNPACKED_WIDTH, UNPACKED_HEIGHT);
    }
    setDefaultCloseOperation(CLOSE_OP);
    setResizable(IS_RESIZABLE);
    if (IS_CENTERED) {
      setLocationRelativeTo(null);
    }
    setVisible(IS_VISIBLE);
  }

  public void update() {
    board.repaint();
  }

}
