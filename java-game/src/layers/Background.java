package layers;
import engine.LayerState;
import engine.Render;
import game.SpriteSheet;

public class Background extends NonPlayer {
    public Background (Player player, int x, int y, String spriteId) {
        setPlayer(player);
        SpriteSheet spriteSheet = player.getGame().getSpriteSheet();
        Render render = player.getGame().getRender();
        setX(x * spriteSheet.getDefaultWidth());
        setY(y * spriteSheet.getDefaultHeight());
        setWidth(spriteSheet.getDefaultWidth());
        setHeight(spriteSheet.getDefaultHeight());
        setCurrentStateId("normal");
        LayerState state = new LayerState();
        state.setId("normal");
        state.setSpeed(1000);
        state.sprites.add(spriteSheet.getSpriteById(spriteId));
        states.add(state);
        render.addLayer(this);
    }
}
