/* This class represents the 2D world in which Creature1
and Creature 2 live.*/

public class Grid {

    // it has width (x) and height (y) as instance variables
    private final int x;
    private final int y;
    // and stores a boolean to indicate whether or
    // not wrapping is wanted
    private final boolean wrapping;
    // the world is a two dimensional array of Creatures
    private final AbstractCreature[][] grid;

    public Grid(boolean wrapping, int x, int y) {
        this.x = x;
        this.y = y;
        this.grid = new AbstractCreature[y][x];
        this.wrapping = wrapping;
    }

    // method to add creatures on the crid. It takes in a
    // creature as a parameter.
    public void addCreature(AbstractCreature creature) {
        // method checks which type of adding to chose
        // depending on whether or not user decided
        // to wrap.

        if (wrapping) {
            addWithWrappingOn(creature);
        }
        else if (!wrapping) {
            addWithWrappingOff(creature);
        }
    }

    // method to handle the adding creature process in case of
    // wrapping. Takes the creature to be added as an argument.
    private void addWithWrappingOn(AbstractCreature creature) {
        // the creatures' coordinates are computed by using modulo.
        int newX = calculateWrappedCoordinate(creature.getX(), this.x);
        int newY = calculateWrappedCoordinate(creature.getY(), this.y);

        creature.setX(newX);
        creature.setY(newY);

        AbstractCreature other = grid[newY][newX];

        // if there is no creature on the grid, it will 
        // place the creature on the grid and start its thread
        if (other == null) {               
            grid[newY][newX] = creature;
            new Thread(creature).start();
        }
        // otherwise, if the coordinate is already occuppied
        else if ((other != null) &&
            // by another species,
            (other.getIdentifier() != creature.getIdentifier())) {
            // it is tested if the creature will kill and replace the other
            
            if (Math.random() <= creature.getFitness() - other.getFitness()) {
                // by removing it from the grid
                this.remove(other);

                this.addCreature(creature);
            }
        }
    }

    // helper method to calculate new coordinates in case of wrapping
    // takes the old coordinate and a dimension of the grid as an argument
    private int calculateWrappedCoordinate(int coordinate, int dimensionSize) {
        return ((coordinate % dimensionSize) + dimensionSize) % dimensionSize;
    }

    // In case of the user setting wrapping to off,
    private void addWithWrappingOff(AbstractCreature creature){
        // it is tested if the creature's coordinates are
        // within the bounds of the 2D array
        if (
            creature.getX() < (x) &&
            creature.getX() >= (0) &&
            creature.getY() < (y) &&
            creature.getY() >= (0) &&
            // and unoccupied by other creatures
            grid[creature.getY()][creature.getX()] == null) {
            // before it is placed on the grid and its thread started
            grid[creature.getY()][creature.getX()] = creature;
            new Thread(creature).start();
        }
        else if (
            creature.getX() < (x) &&
            creature.getX() >= (0) &&
            creature.getY() < (y) &&
            creature.getY() >= (0) &&
            // If there is another creature on the coordinate,
            grid[creature.getY()][creature.getX()] != null) {

            AbstractCreature other = grid[creature.getY()][creature.getX()];
            // the method calculates whether or not the other creature
            // should be removed based on its fitness value.
            if ((Math.random() <= creature.getFitness() - other.getFitness()) &&
                // makes sure that the creature is from another species
                (other.getIdentifier() != creature.getIdentifier())) {
                this.remove(other);
                this.addCreature(creature);
            }
        }
    }

    // method to remove a creature by setting its coordinates
    // on the grid equal to null
    public void remove(AbstractCreature creature) {
        this.grid[creature.getY()][creature.getX()] = null;
        creature.kill();
    }

    // toString method to make the Creature grid
    // visible on the command line
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // iterates through each Creature
        // on each row in the 2D array
        for (AbstractCreature[] row : grid) {
            for (AbstractCreature creature : row) {
                // and appends a dash followed by a space
                // to the StringBuilder if there is no
                // creature with that coordinate
                if (creature == null) {
                    stringBuilder.append('-' + " ");
                }
                // otherwise, if a creature exists on that coordinate
                // its idenfitier will be added to the StringBuilder
                else {
                    stringBuilder.append(creature.getIdentifier() + " ");
                }
            }
            // each row in the 2D array is followed by a new line
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
