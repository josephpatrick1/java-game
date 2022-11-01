package layers;

import java.util.ArrayList;
import java.util.List;
import engine.LayerState;
import engine.Sprite;
import interfaces.PreRendered;

public abstract class Layer implements PreRendered {
    public abstract void preRender();

    private int x = 0;
    private int y = 0;
    private int offSetX = 0;
    private int offSetY = 0;
    private int width = 28;
    private int height = 28;
    private String currentStateId = "default";
    public List<LayerState> states = new ArrayList<>();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOffSetX() {
        return offSetX;
    }

    public void setOffSetX(int offSetX) {
        this.offSetX = offSetX;
    }

    public int getOffSetY() {
        return offSetY;
    }

    public void setOffSetY(int offSetY) {
        this.offSetY = offSetY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(String currentStateId) {
        this.currentStateId = currentStateId;
    }

    public Sprite getCurrentSprite(int timePassed) {
        LayerState currentState = this.states.stream()
                .filter((state) -> state.getId() == currentStateId)
                .findFirst()
                .get();
        int totalAnimationTime = currentState.getSpeed() * currentState.sprites.size();
        int index = (timePassed % totalAnimationTime) / currentState.getSpeed();
        return currentState.sprites.get(index);
    }
}