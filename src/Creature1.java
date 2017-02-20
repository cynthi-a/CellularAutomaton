public class Creature1 extends AbstractCreature {

    // Creature1 takes in a grid and coordinates on the
    // grid as arguments
    public Creature1(Grid grid, int x, int y) {
        // by defult, the isAlive flag is set to true
        this.isAlive = true;
        // Creature1's identifier is the character 1
    	this.identifier = '1';
        // its fitness is always 0.8
        this.FITNESS = 0.8;
        // its lifespan does not exceed 10 seconds
        this.MAX_LIFESPAN = 10000;
        this.grid = grid;
        this.x = x;
        this.y = y;
        // the lifespan is randomly generated
        this.lifespan = rand.nextInt(MAX_LIFESPAN);
        // upon instantiation, Creature1 is added
        // on the grid and thus made visible
        grid.addCreature(this);
    }

    @Override
    public void run() {
        try {
            // Creature1 remains on the grid as long as
            // its lifespan is
            Thread.sleep(lifespan);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // grid can only be accessed by one Creature at the time
        synchronized (grid) {
            // if the creature has not been removed by Creature2
            // while its thread was asleep, it will reproduce
            if (isAlive) {
                // for each of the eight possible fields, the
                // boolean returned by reproduces() decides whether a child
                // is placed on the grid
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x+1, y));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x-1, y+1));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x+1, y+1));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x, y+1));
                }
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x-1, y));
                }    
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x+1, y-1));    
                }
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x-1, y-1));    
                }    
                if (reproduces()) {
                    grid.addCreature(new Creature1(grid, x, y-1));   
                }

                // after Creature1 remained on the grid for the
                // length of its lifetime it is removed from the grid
                grid.remove(this);
            }       
        }
    }
}
