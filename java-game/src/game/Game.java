package game;

import java.io.IOException;

import engine.KeysControl;
import engine.Render;
import layers.Player;

public class Game {
    Render render;
    SpriteSheet spriteSheet;
    KeysControl keysControl;
    Player player;

    public Render getRender() {
        return render;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public KeysControl getKeysControl() {
        return keysControl;
    }

    public Player getPlayer() {
        return player;
    }

    public Game(Render render, SpriteSheet spriteSheet, KeysControl keysControl) throws IOException {
        this.render = render;
        this.spriteSheet = spriteSheet;
        this.keysControl = keysControl;
        this.player = new Player(this, 50, 200);
        new Level1(player);
    }
}
