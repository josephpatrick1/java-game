package utils;

import layers.Player;

public class Respawn {
    Player player;
    private int x = 0;
    private int y = 0;
    private int offsetX = 0;
    private int offsetY = 0;
    public Respawn (Player player) {
        this.player = player;
    }
    public void setRespawnPoint() {
        x = player.getX();
        y = player.getY();
        offsetX = player.getOffSetX();
        offsetY = player.getOffSetY();
    }
    public void goToRespawn () {
        player.setX(x);
        player.setY(y);
        player.setOffSetX(offsetX);
        player.setOffSetY(offsetY);
    }
}
