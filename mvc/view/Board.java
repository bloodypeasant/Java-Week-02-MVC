package mvc.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import mvc.Config;
import mvc.model.Model;
import mvc.sprite.Goban;
import mvc.sprite.Stone;
import mvc.utilities.Phaseable;

public class Board extends JPanel implements Phaseable, Config.VIEW.BOARD {

  private static final long serialVersionUID = 1L;
  public View view;
  public Goban goban = new Goban();
  private int numCols, numRows;
  private Model model;
  private RenderingHints renderingHints = new RenderingHints(null);

  public Board(View view) {
    trace(this);
    this.view = view;
    model = view.app.model;
    addMouseListener(view.app.controller);
    numCols = model.getNumCols();
    numRows = model.getNumRows();
    setPreferredSize(new Dimension(Config.VIEW.BOARD.WIDTH, Config.VIEW.BOARD.HEIGHT));
    renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHints(renderingHints);
    goban.updateView(g2d);
    Stone stone;
    for (int row = 0; row < numRows; ++row) {
      for (int col = 0; col < numCols; ++col) {
        stone = model.getIntersection(row, col);
        if (stone == null)
          continue;
        stone.updateView(g2d);
      }
    }
    g2d.dispose();
  }

}
