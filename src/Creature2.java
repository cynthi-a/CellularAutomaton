public class Creature2 extends AbstractCreature {

    public Creature2(Grid grid, int x, int y) {
        this.isAlive = true;
        this.identifier = '2';
        this.FITNESS = 0.4;
        this.MAX_LIFESPAN = 5000;
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
            if (isAlive) {
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x+1, y));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x-1, y+1));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x+1, y+1));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x, y+1));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x-1, y));
                }    
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x+1, y-1));    
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x-1, y-1));    
                }    
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature2(grid, x, y-1));   
                }
            }       
        }
    }
}