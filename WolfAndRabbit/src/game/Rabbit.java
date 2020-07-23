package game;

import city.cs.engine.*;

public class Rabbit extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.31f, 0.747f, 0.688f, -1.053f, -0.707f, -1.039f, -0.297f, 1.058f);

    private static final BodyImage image =
            new BodyImage("data/bunny.png", 2.25f);

    private int cabbageCount;
    private int liveCount;

    public Rabbit(World world) {
        super(world, shape);
        addImage(image);
        cabbageCount = 0;
        liveCount = 3;
    }

    public int getCabbageCount() {
        return cabbageCount;
    }

    public void incrementCabbageCount() {
        cabbageCount++;
        System.out.println("Tasty!  Cabbage count = " + cabbageCount);
    }

    public int getLiveCount() {
        return liveCount;
    }

    public void decrementliveCount() {
        liveCount--;
        System.out.println("Oops, lost life. Life = " + liveCount);
    }

    public void incrementliveCount(){
        liveCount++;
        System.out.println("Healed up! Life = " + liveCount);
    }

    public void setCabbageCount(int cnt) {
        cabbageCount = cnt;
    }

    public void setLiveCount(int cntt) {
        liveCount = cntt;
    }

    }



