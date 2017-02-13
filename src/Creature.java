import java.util.Random;

public class Creature implements Runnable {
    private Grid grid;
    private Random rand;
    private final int x;
    private final int y;
    private int lifespan;

    private final double FITNESS = 0.8;
    private final int MAX_LIFESPAN = 10000;

    public Creature(Grid grid, int x, int y) {
        this.rand = new Random();
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.lifespan = rand.nextInt(MAX_LIFESPAN);
        grid.addCreature(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(lifespan);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (grid) {
            grid.remove(this);
            if (babyYayOrNay()) {
                grid.addCreature(new Creature(grid, x+1, y));
            }
            if (babyYayOrNay()) {
                grid.addCreature(new Creature(grid, x-1, y+1));
            }
            if (babyYayOrNay()) {
                grid.addCreature(new Creature(grid, x+1, y+1));
            }
            if (babyYayOrNay()) {
                grid.addCreature(new Creature(grid, x, y+1));
            }
            if (babyYayOrNay()) {
                grid.addCreature(new Creature(grid, x-1, y));
            }    
            if (babyYayOrNay()) {
                grid.addCreature(new Creature(grid, x+1, y-1));    
            }
            if (babyYayOrNay()) {
                grid.addCreature(new Creature(grid, x-1, y-1));    
            }    
            if (babyYayOrNay()) {
                 grid.addCreature(new Creature(grid, x, y-1));   
            }       
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean babyYayOrNay() {
        double d = rand.nextDouble() * 1;

        if (d < FITNESS) {
            return true;
        }
        else return false;
    }
}
