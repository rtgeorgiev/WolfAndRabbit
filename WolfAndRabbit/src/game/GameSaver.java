package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {

    private String fileName;

    public GameSaver(String fileName) {
        this.fileName = fileName;
    }

    public void saveGame(GameLevel gameWorld) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);

            writer.write(gameWorld.getLevelNumber() + "\n");

            writer.write(gameWorld.getRabbit().getClass().getSimpleName() + "," + gameWorld.getRabbit().getPosition().x + "," + gameWorld.getRabbit().getPosition().y + "," + gameWorld.getRabbit().getCabbageCount() + "," + gameWorld.getRabbit().getLiveCount() + "\n");


            for (DynamicBody body : gameWorld.getDynamicBodies()){
                if (!(body instanceof Rabbit))
                writer.write(body.getClass().getSimpleName() + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
            }
            for (StaticBody body : gameWorld.getStaticBodies()){
                if (body instanceof Platform)
                writer.write(body.getClass().getSimpleName() + "," +
                        body.getPosition().x + "," + body.getPosition().y + "," +
                        ((Platform) body).getWidth() + "," + ((Platform) body).getHeight() + "\n");
                else
                    writer.write(body.getClass().getSimpleName() + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
            }

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
