package engine;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import layers.Layer;

public class Render extends JPanel implements Runnable {
    Thread gameThread;
    int INTERVAL = 1000 / 64;
    private int timePassed = 0;
    private List<Layer> layers = new ArrayList<>();

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void clearLayers() {
        layers.clear();
    }

    public Render() {
        this.setPreferredSize(new Dimension(512, 512));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // wait for interval
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                // Add time to int timePassed in the class
                timePassed = timePassed >= 10000 ? 0 : timePassed + INTERVAL;
                // Execute preRender methods of layers
                layers.forEach(layer -> {
                    layer.preRender();
                });
                // Repaint objects
                this.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, 512, 512);
        for (int i = layers.size() - 1; i >= 0; i--) {
            Layer layer = layers.get(i);
            Sprite sprite = layer.getCurrentSprite(timePassed);
            g2.drawImage(sprite.getRendered(), layer.getX() - layer.getOffSetX(), layer.getY() - layer.getOffSetY(),
                    layer.getWidth(), layer.getHeight(), null);
        }
        g2.dispose();
    }
}
