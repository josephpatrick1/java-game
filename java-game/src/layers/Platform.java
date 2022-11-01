package layers;

import utils.Collision;

public class Platform extends Background {
    boolean topColision = false;
    public boolean isTopColision() {
        return topColision;
    }
    @Override
    public void preRender() {
        super.preRender();
        if (Collision.isTopCollision(getPlayer(), this)) {
            topColision = true;
            if (getPlayer().getVelocityY() != 0) {
                getPlayer().setVelocityY(0);
            }
            if (getPlayer().getJumpNumber() > 0) {
                getPlayer().setJumpNumber(0);
            }
        } else {
            topColision = false;
        }
    }
    public Platform(Player player, int i, int j, String spriteId) {
        super(player, i, j, spriteId);
    }
}