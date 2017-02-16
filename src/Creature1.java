public class Creature1 extends AbstractCreature {

    public Creature1(Grid grid, int x, int y) {
        this.isAlive = true;
    	this.identifier = '1';
        this.FITNESS = 0.8;
        this.MAX_LIFESPAN = 10000;
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
                    grid.addCreature(new Creature1(grid, x+1, y));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature1(grid, x-1, y+1));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature1(grid, x+1, y+1));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature1(grid, x, y+1));
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature1(grid, x-1, y));
                }    
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature1(grid, x+1, y-1));    
                }
                if (babyYayOrNay()) {
                    grid.addCreature(new Creature1(grid, x-1, y-1));    
                }    
                if (babyYayOrNay()) {
                     grid.addCreature(new Creature1(grid, x, y-1));   
                }
            }       
        }
    }
}
