package mvc;

import javax.swing.JFrame;

public interface Config {

  public interface CONTROLLER {
  }

  public interface MODEL {

    public int COLS = 19;
    public int ROWS = 19;

  }

  public interface SPRITE {

    public interface BLACK_STONE {

      public String IMAGE_URL = "mvc/resources/black-stone.png";
      public int HEIGHT = (int) (0.9 * GOBAN.ROW_HEIGHT);
      public int WIDTH = (int) (0.9 * GOBAN.COL_WIDTH);

    }

    public interface GOBAN {

      public String IMAGE_URL = "mvc/resources/goban.png";
      public int HEIGHT = VIEW.BOARD.HEIGHT;
      public int WIDTH = VIEW.BOARD.WIDTH;
      public int ROWS = MODEL.ROWS;
      public int COLS = MODEL.COLS;
      public int POS_X = WIDTH / 2;
      public int POS_Y = HEIGHT / 2;
      public double MARGIN_X = 32.0 * WIDTH / 1024.0;
      public double MARGIN_Y = 32.0 * HEIGHT / 1024.0;
      public double ROW_HEIGHT = (HEIGHT - 2.0 * MARGIN_Y) / (ROWS - 1);
      public double COL_WIDTH = (WIDTH - 2.0 * MARGIN_X) / (COLS - 1);

    }

    public interface WHITE_STONE {

      public String IMAGE_URL = "mvc/resources/white-stone.png";
      public int HEIGHT = (int) (0.9 * GOBAN.ROW_HEIGHT);
      public int WIDTH = (int) (0.9 * GOBAN.COL_WIDTH);

    }

  }

  public interface VIEW {

    public String TITLE = "Go";
    public int CLOSE_OP = JFrame.EXIT_ON_CLOSE;
    public boolean IS_CENTERED = true;
    public boolean IS_PACKED = true;
    public boolean IS_RESIZABLE = false;
    public boolean IS_VISIBLE = true;
    public int UNPACKED_HEIGHT = 768;
    public int UNPACKED_WIDTH = 1024;

    public interface BOARD {

      public int HEIGHT = 680;
      public int WIDTH = 680;

    }

  }
}
