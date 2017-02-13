public class Creature implements Runnable {
    private Grid grid;
    private final int x;
    private final int y;

    public Creature(Grid grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        grid.addCreature(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (grid) {
            grid.remove(this);
            grid.addCreature(new Creature(grid, x+1, y));
            grid.addCreature(new Creature(grid, x+1, y+1));
            grid.addCreature(new Creature(grid, x, y+1));
            grid.addCreature(new Creature(grid, x-1, y));
            grid.addCreature(new Creature(grid, x-1, y-1));
            grid.addCreature(new Creature(grid, x, y-1));
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
