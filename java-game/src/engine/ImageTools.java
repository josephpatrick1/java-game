package engine;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageTools {
    public BufferedImage getImage(String src) throws IOException {
        return ImageIO.read(new File(src));
    }

    public BufferedImage getSubImage(BufferedImage image, int x, int y, int width, int height) {
        return image.getSubimage(x, y, width, height);
    }
}