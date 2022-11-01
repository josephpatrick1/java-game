package layers;

import engine.KeyHandler;
import engine.KeysControl;
import engine.LayerState;
import game.Game;
import interfaces.Move;
import utils.Respawn;

public class Player extends Layer implements Move {
    Respawn respawn;
    Game game;
    KeysControl keysControl;
    private int gravity = 1;
    private int velocityX = 0;
    private int velocityY = 1;
    private int speed = 2;
    private int jumpSize = 8;
    private int jumpNumber = 0;
    public Game getGame() {
        return game;
    }
    public int getJumpNumber() {
        return jumpNumber;
    }
    public void setJumpNumber(int jumpNumber) {
        this.jumpNumber = jumpNumber;
    }
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
    public int getVelocityY() {
        return velocityY;
    }
    @Override
    public void preRender() {
        if(getY() >= 512) {
            System.out.println("Go to Respawn");
            respawn.goToRespawn();
            return;
        }
        setX(getX() + velocityX);
        setY(getY() + velocityY);
        this.velocityY += this.gravity;
        if (keysControl.isKeyPressed("←")) {
            this.setCurrentStateId("runLeft");
            this.move("←", this.speed);
        }
        else if (keysControl.isKeyPressed("→")) {
            this.setCurrentStateId("runRight");
            this.move("→", this.speed);
        }
        else {
            if(this.getCurrentStateId() == "runLeft") {
                this.setCurrentStateId("stopLeft");
            }
            if(this.getCurrentStateId() == "runRight") {
                this.setCurrentStateId("stopRight");
            }
        }
    }
    public void move(String direction, int speed) {
        if(direction == "←") {
            if (getX() >= 100) {
                setOffSetX(getOffSetX() - speed);
            }
            else {
                setOffSetX(0);
            }
            setX(getX() - speed);
            return;
        }
        if(direction == "→") {
            if (getX() >= 100) {
                setOffSetX(getOffSetX() + speed);
            }
            setX(getX() + speed);
            return;
        }
        if (direction == "↑") {
            setY(getY() - speed);
        }
        if (direction == "↓") {
            setY(getY() + speed);
        }
    }
    public void jumpLogic() {
        KeyHandler keyHandlerJump = new KeyHandler("↑", "down", () -> {
            if (jumpNumber < 2) {
                this.jumpNumber += 1;
                this.velocityY = -jumpSize;
            }
        });
        keysControl.addKeyHandler(keyHandlerJump);
    }
    public Player(Game game, int x, int y) {
        this.game = game;
        this.respawn = new Respawn(this);
        this.keysControl = game.getKeysControl();
        setX(x);
        setY(y);
        setWidth(16);
        setHeight(16);

        LayerState runRight = new LayerState();
        runRight.setId("runRight");
        runRight.setSpeed(100);
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r1"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r2"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r3"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r4"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r5"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r6"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r7"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r8"));
        runRight.sprites.add(game.getSpriteSheet().getSpriteById("r9"));

        LayerState runLeft = new LayerState();
        runLeft.setId("runLeft");
        runLeft.setSpeed(100);
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l1"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l2"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l3"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l4"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l5"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l6"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l7"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l8"));
        runLeft.sprites.add(game.getSpriteSheet().getSpriteById("l9"));

        LayerState stopRight = new LayerState();
        stopRight.setId("stopRight");
        stopRight.sprites.add(game.getSpriteSheet().getSpriteById("r5"));

        LayerState stopLeft = new LayerState();
        stopLeft.setId("stopLeft");
        stopLeft.sprites.add(game.getSpriteSheet().getSpriteById("l5"));
        
        states.add(runRight);
        states.add(runLeft);
        states.add(stopRight);
        states.add(stopLeft);

        this.setCurrentStateId("stopRight");

        game.getRender().addLayer(this);
        jumpLogic();
        respawn.setRespawnPoint();
    }
}