package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import layers.Layer;

public class Level {
    List<Layer> layers = new ArrayList<>();
    List<List<String>> map = new ArrayList<>();
    public void loadLevel(String src) {
        try {
			Scanner scanner = new Scanner(new File(src));
			while (scanner.hasNextLine()) {
                List<String> mapLine = new ArrayList<>();
                String line = scanner.nextLine();
                for (String split : line.split(",")) {
                    mapLine.add(split);
                }
                map.add(mapLine);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
