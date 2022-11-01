package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeysControl implements KeyListener {
    List<String> keysPressed = new ArrayList<>();
    List<KeyHandler> keyHandlers = new ArrayList<>();

    public boolean isKeyPressed(String key) {
        return keysPressed.stream().filter(keyFind -> keyFind == key).findAny().isPresent();
    }

    public void addKeyHandler(KeyHandler keyHandler) {
        keyHandlers.add(keyHandler);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        boolean isPresent = keysPressed.stream().filter(keyFind -> keyFind == key).findAny().isPresent();
        if (!isPresent) {
            keysPressed.add(key);
        }
        keyHandlers
                .stream()
                .filter(keyHandler -> (keyHandler.getKey() == key && keyHandler.getType() == "down"))
                .forEach(keyHandler -> {
                    new Thread(keyHandler.getRunnable()).start();
                });
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        keysPressed = keysPressed.stream().filter(keyFind -> keyFind != key).collect(Collectors.toList());
        keyHandlers.stream().filter(keyHandler -> (keyHandler.getKey() == key && keyHandler.getType() == "up"))
                .forEach(keyHandler -> {
                    new Thread(keyHandler.getRunnable()).start();
                });

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}