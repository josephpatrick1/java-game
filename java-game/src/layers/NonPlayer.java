package layers;

public class NonPlayer extends Layer {
    private Player player;
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }
    @Override
    public void preRender() {
        setOffSetX(player.getOffSetX());
        setOffSetY(player.getOffSetY());
    }
}
