package game;

import city.cs.engine.Body;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameLoader {

    private String fileName;
    private Game game;

    /**
     * Initialise a new HighScoreReader
     *
     * @param fileName the name of the high-score file
     */
    public GameLoader(String fileName, Game g) {
        this.fileName = fileName;
        game = g;

    }

    /**
     * Read the high-score data from the high-score file and print it to
     * the terminal window.
     */
    public GameLevel loadGame() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            int levelNumber = Integer.parseInt(line);

            GameLevel level = null;
            if (levelNumber == 1) {
                level = new Level1();
            } else if (levelNumber == 2) {
                level = new Level2();
            } else if (levelNumber == 3) {
                level = new Level3();
            }

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String className = tokens[0];
                float xPlayer = Float.parseFloat(tokens[1]);
                float yPlayer = Float.parseFloat(tokens[2]);
                Vec2 posPlayer = new Vec2(xPlayer, yPlayer);

                if (className.equals("Rabbit")) {
                    int cabbages = Integer.parseInt(tokens[3]);
                    int lives = Integer.parseInt(tokens[4]);
                    Rabbit b = new Rabbit(level);
                    b.setPosition(posPlayer);
                    b.setCabbageCount(cabbages);
                    b.setLiveCount(lives);
                    level.setRabbit(b);
                }
                if (className.equals("Wolf")) {
                    Body b = new Wolf(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new Pickup(level.getRabbit()));
                }
                if (className.equals("Door")) {
                    Body b = new Door(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new DoorListener(game));
                }
                if (className.equals("Cabbage")) {
                    Body b = new Cabbage(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new Pickup(level.getRabbit()));
                }
                if (className.equals("Carrot")) {
                    Body b = new Carrot(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new Pickup(level.getRabbit()));
                }
                if (className.equals("Platform")) {
                    float w = Float.parseFloat(tokens[3]);
                    float h = Float.parseFloat(tokens[4]);
                    Body b = new Platform(level, w, h);
                    b.setPosition(posPlayer);
                }

            }
            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
