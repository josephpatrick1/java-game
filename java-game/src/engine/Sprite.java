package engine;

import java.awt.image.BufferedImage;

public class Sprite extends ImageTools {
    private String id = "default";
    private int x = 0;
    private int y = 0;
    private int width;
    private int height;
    private BufferedImage rendered;

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getRendered() {
        return rendered;
    }

    public void setRendered(BufferedImage rendered) {
        this.rendered = rendered;
    }

    public Sprite(BufferedImage image, String id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rendered = this.getSubImage(image, x, y, width, height);
    }
}