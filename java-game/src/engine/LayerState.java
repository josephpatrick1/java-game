package engine;

import java.util.ArrayList;
import java.util.List;

public class LayerState {
    private String id = "default";
    private int speed = 1000;
    public List<Sprite> sprites = new ArrayList<>();
    public String getId() {
        return id;
    }
    public int getSpeed() {
        return speed;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}