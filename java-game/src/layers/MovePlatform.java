package layers;

import interfaces.Move;

public class MovePlatform extends Platform implements Move {
    Player player;
    boolean moveToRight = true;
    int minX = getX();
    int maxX = getX() + 16 * 18;

    @Override
    public void preRender() {
        super.preRender();
        if (getX() <= minX) {
            moveToRight = true;
        }
        if (getX() >= maxX) {
            moveToRight = false;
        }
        this.move(moveToRight ? "→" : "←", 1);
        if (isTopColision()) {
            player.move(moveToRight ? "→" : "←", 1);
        }
    }

    public void move(String direction, int speed) {
        if (direction == "←") {
            setX(getX() - speed);
        }
        if (direction == "→") {
            setX(getX() + speed);
        }
        if (direction == "↑") {
            setY(getY() - speed);
        }
        if (direction == "↓") {
            setY(getY() + speed);
        }
    }

    public MovePlatform(Player player, int x, int y, String spriteId, int moveBlocks) {
        super(player, x, y, spriteId);
        this.maxX = getX() + 16 * moveBlocks;
        this.player = player;
    }
}
