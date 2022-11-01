package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import engine.ImageTools;
import engine.Sprite;

public class SpriteSheet extends ImageTools {
    private List<Sprite> sprites = new ArrayList<>();
    private int defaultWidth = 16;
    private int defaultHeight = 16;

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }

    public Sprite getSpriteById(String id) {
        return sprites.stream().filter(sprite -> sprite.getId().equals(id)).findFirst().get();
    }

    public SpriteSheet() throws IOException {
        BufferedImage image = this.getImage("./assets/tilemap.png");

        // Player movements right
        addDefaultSizeSprite("r1", image, 0, 0);
        addDefaultSizeSprite("r2", image, 1, 0);
        addDefaultSizeSprite("r3", image,2, 0);
        addDefaultSizeSprite("r4", image,3, 0);
        addDefaultSizeSprite("r5", image,4, 0);
        addDefaultSizeSprite("r6", image,5, 0);
        addDefaultSizeSprite("r7", image,6, 0);
        addDefaultSizeSprite("r8", image,7, 0);
        addDefaultSizeSprite("r9", image,8, 0);

        // player movements left
        addDefaultSizeSprite("l1", image,0, 1);
        addDefaultSizeSprite("l2", image, 1, 1);
        addDefaultSizeSprite("l3", image,2, 1);
        addDefaultSizeSprite("l4", image,3, 1);
        addDefaultSizeSprite("l5", image, 4, 1);
        addDefaultSizeSprite("l6", image,5, 1);
        addDefaultSizeSprite("l7", image, 6, 1);
        addDefaultSizeSprite("l8", image, 7, 1);
        addDefaultSizeSprite("l9", image, 8, 1);
        addDefaultSizeSprite("t1", image, 1, 2);

        int count = 0;
        for(int y = 0; y < 32; y++) {
            for(int x = 0; x < 32; x++) {
                addDefaultSizeSprite(Integer.toString(count), image, x, y);
                count++;
            }
        }

        // Tree
        addCustomSizeSprite("224", image, 16, 16, 5, 7);


    }

    private void addDefaultSizeSprite(String id, BufferedImage image, int x, int y) {
        this.sprites.add(new Sprite(image, id, x * defaultWidth, y * defaultHeight, defaultWidth, defaultHeight));
    }

    private void addCustomSizeSprite(String id, BufferedImage image, int x, int y, int multiplyWidth, int multiplyHeight) {
        this.sprites.add(new Sprite(image, id, x * defaultWidth, y * defaultHeight, defaultWidth * multiplyWidth, defaultHeight * multiplyHeight));
    }
}