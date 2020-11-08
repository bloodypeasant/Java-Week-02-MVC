package mvc.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import mvc.utilities.Loader;
import mvc.utilities.SharedImage;
import mvc.utilities.Traceable;

public abstract class Sprite implements Traceable {

  private static HashMap<String, SharedImage> sharedImages = new HashMap<>();
  private BufferedImage image;
  private int dimX, dimY, posX, posY;
  private double posA;
  private String sharedImageKey;

  public Sprite(String sharedImageKey, int posX, int posY) {
    trace(this);
    SharedImage sharedImage = sharedImages.get(sharedImageKey);
    image = sharedImage.getImage();
    dimX = sharedImage.getWidth();
    dimY = sharedImage.getHeight();
    this.sharedImageKey = sharedImageKey;
    this.posX = posX;
    this.posY = posY;
    this.posA = 0;
  }

  public Sprite(String sharedImageKey, int posX, int posY, double posA) {
    trace(this);
    SharedImage sharedImage = sharedImages.get(sharedImageKey);
    image = Loader.rotateImage(sharedImage.getImage(), posA);
    dimX = image.getWidth();
    dimY = image.getHeight();
    this.posX = posX;
    this.posY = posY;
    this.posA = posA;
  }

  public static void shareImage(String sharedImageKey, String sharedImageURL, double posA, int dimX) {
    Traceable.trace(Sprite.class.getName());
    try {
      BufferedImage originalImage = Loader.loadImage(sharedImageURL);
      BufferedImage resizedImage = Loader.resizeImageByWidth(originalImage, dimX);
      BufferedImage rotatedImage = posA == 0 ? resizedImage : Loader.rotateImage(resizedImage, posA);
      SharedImage sharedImage = new SharedImage(rotatedImage, rotatedImage.getWidth(), rotatedImage.getHeight());
      sharedImages.put(sharedImageKey, sharedImage);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void updateModel(double posA) {
    trace(this);
    this.posA = posA;
    image = Loader.rotateImage(image, posA);
    dimX = image.getWidth();
    dimY = image.getHeight();
  }

  public void updateModel(int posX, int posY) {
    trace(this);
    this.posX = posX;
    this.posY = posY;
  }

  public void updateModel(int posX, int posY, double posA) {
    trace(this);
    this.posX = posX;
    this.posY = posY;
    this.posA = posA;
    image = Loader.rotateImage(sharedImages.get(sharedImageKey).getImage(), posA);
    dimX = image.getWidth();
    dimY = image.getHeight();
  }

  public void updateView(Graphics g) {
    trace(this);
    g.drawImage(image, posX - dimX / 2, posY - dimY / 2, null);
  }

  public int getDimX() {
    trace(this);
    return dimX;
  }

  public int getDimY() {
    trace(this);
    return dimY;
  }

  public int getPosX() {
    trace(this);
    return posX;
  }

  public void setPosX(int posX) {
    trace(this);
    this.posX = posX;
  }

  public int getPosY() {
    trace(this);
    return posY;
  }

  public void setPosY(int posY) {
    trace(this);
    this.posY = posY;
  }

  public double getPosA() {
    trace(this);
    return posA;
  }

  public void setPosA(double posA) {
    this.posA = posA;
    image = Loader.rotateImage(sharedImages.get(sharedImageKey).getImage(), posA);
    dimX = image.getWidth();
    dimY = image.getHeight();
  }

}
