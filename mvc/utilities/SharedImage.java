package mvc.utilities;

import java.awt.image.BufferedImage;

public class SharedImage {

  private BufferedImage image;
  private int width;
  private int height;

  public SharedImage(BufferedImage image, int width, int height) {
    this.image = image;
    this.width = width;
    this.height = height;
  }

  public BufferedImage getImage() {
    return image;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

}
