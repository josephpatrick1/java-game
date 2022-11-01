import java.io.IOException;
import javax.swing.JFrame;
import engine.KeysControl;
import engine.Render;
import game.Game;
import game.SpriteSheet;

public class App {
    public static void main(String[] args) throws IOException {
        SpriteSheet spriteSheet = new SpriteSheet();
        KeysControl keysControl = new KeysControl();
        JFrame window = new JFrame();
        Render render = new Render();
        render.addKeyListener(keysControl);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game orientado à objetos");
        window.add(render);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        new Game(render, spriteSheet, keysControl);
    }
}