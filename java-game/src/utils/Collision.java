package utils;

import layers.Layer;
import layers.Player;

public class Collision {
    public static boolean isTopCollision(Player player, Layer layer) {
        if (player.getY() + player.getHeight() <= layer.getY()
                && player.getY() + player.getHeight() + player.getVelocityY() >= layer.getY()
                && player.getX() + player.getWidth() >= layer.getX()
                && player.getX() <= layer.getX() + layer.getWidth()) {
            return true;
        }
        return false;
    }
}
