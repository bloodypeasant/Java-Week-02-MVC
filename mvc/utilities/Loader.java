package mvc.utilities;

import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.imageio.ImageIO;

public class Loader {

  public static BufferedImage loadImage(String filename) throws IOException {
    return ImageIO.read(new File(filename));
  }

  public static Properties loadProperties(String filename) throws URISyntaxException, IOException {
    File resource = new File(filename);
    // File resource = new File(Loader.getRoot(), fileName);
    FileInputStream in = new FileInputStream(resource);
    Properties properties = new Properties();
    properties.load(in);
    return properties;
  }

  public static BufferedImage resizeImageByWidth(BufferedImage originalImage, int newWidth) {
    int originalWidth = originalImage.getWidth();
    int originalHeight = originalImage.getHeight();
    double ratio = newWidth / (double) originalWidth;
    int newHeight = (int) (originalHeight * ratio);
    BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
    g.dispose();
    return resizedImage;
  }

  public static BufferedImage rotateImage(BufferedImage originalImage, double rads) {
    // final double rads = Math.toRadians(90);
    final double sin = Math.abs(Math.sin(rads));
    final double cos = Math.abs(Math.cos(rads));
    final int w = (int) Math.floor(originalImage.getWidth() * cos + originalImage.getHeight() * sin);
    final int h = (int) Math.floor(originalImage.getHeight() * cos + originalImage.getWidth() * sin);
    final BufferedImage rotatedImage = new BufferedImage(w, h, originalImage.getType());
    final AffineTransform at = new AffineTransform();
    at.translate(w / 2, h / 2);
    at.rotate(rads, 0, 0);
    at.translate(-originalImage.getWidth() / 2, -originalImage.getHeight() / 2);
    final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
    rotateOp.filter(originalImage, rotatedImage);
    return rotatedImage;
  }
}
