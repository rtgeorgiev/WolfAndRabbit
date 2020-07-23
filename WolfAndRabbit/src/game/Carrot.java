package game;

import city.cs.engine.*;

public class Carrot extends Walker {

    private static final Shape shape = new PolygonShape(-1.129f,-1.037f, -0.226f,0.222f, 0.728f,1.102f, 1.074f,0.747f, 0.217f,-0.272f, -0.936f,-1.092f);

    private static final BodyImage image =
            new BodyImage("data/carrot.png", 2.10f);

    public Carrot(World world) {
        super(world, shape);
        addImage(image);
        Fixture c = new GhostlyFixture(this, shape);

    }
}
