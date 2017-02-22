/* Creature2 is almost the exact object as Creature1.
Thus, for more extensive commenting, refer to Creature1*/

public class Creature2 extends AbstractCreature {

    public Creature2(Grid grid, int x, int y) {
        this.isAlive = true;
        // Creature2's identifier is '2'
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
            
            if (isAlive) {
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x+1, y));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x-1, y+1));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x+1, y+1));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x, y+1));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x-1, y));
                }    
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x+1, y-1));    
                }
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x-1, y-1));    
                }    
                if (reproduces()) {
                    grid.addCreature(new Creature2(grid, x, y-1));   
                }
                if (reproduces()) {
                	grid.addCreature(new Creature2(grid, x, y));
                }

                // after Creature1 remained on the grid for the
                // length of its lifetime it is removed from the grid
                grid.remove(this);
            }       
        }
    }
}