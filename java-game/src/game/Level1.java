package game;

import layers.MovePlatform;
import layers.Player;
import layers.Platform;

import java.io.IOException;
import java.util.Arrays;
import layers.Background;
import layers.MainBackground;

public class Level1 extends Level {
    public Level1(Player player) throws IOException {
        loadLevel("./assets/level1.csv");
        for (int j = 0; j < map.size(); j++) {
            for (int i = 0; i < map.get(j).size(); i++) {
                String block = map.get(j).get(i);

                String[] platforms = { "64", "65", "66" };
                Boolean containsPlatform = Arrays.asList(platforms).contains(block);

                if (containsPlatform) {
                    layers.add(new Platform(player, i, j, block));
                }
                else if( block.contains("161")) {
                    layers.add(new MovePlatform(player, i, j, block, 10));
                }
                else if (block.contains("-1") == false) {
                    //System.out.println("probaly bg");
                    layers.add(new Background(player, i, j, block));
                }
            }
        }
        layers.add(new MainBackground(player));
    }
}