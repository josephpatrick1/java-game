package layers;

import engine.ImageTools;
import engine.LayerState;
import engine.Render;
import engine.Sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainBackground extends NonPlayer {
    ImageTools imageTools = new ImageTools();
    @Override
    public void preRender() {
        setOffSetX((int)(this.getPlayer().getOffSetX() * 0.5));
        setOffSetY((int)(this.getPlayer().getOffSetY() * 0.5));
    }
    public MainBackground(Player player) throws IOException {
        setPlayer(player);
        Render render = player.getGame().getRender();
        setX(0);
        setY(0);
        setWidth(2048);
        setHeight(512);
        BufferedImage background = imageTools.getImage("./assets/mainbg.png");
        Sprite sprite = new Sprite(background, "bg", getX(), getY(), 320, 192);
        LayerState state = new LayerState();
        state.sprites.add(sprite);
        states.add(state);
        render.addLayer(this);
    }

}
