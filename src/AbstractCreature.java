/*  Abstract class from which Creature1 and Creature2 inherit. */

import java.util.Random;

public abstract class AbstractCreature implements Runnable {
    // each creature is passed the same Grid object
	Grid grid;
    // identifier that is needed to tell the creatures apart
	char identifier;
    Random rand = new Random();
    int x;
    int y;
    int lifespan;
	double FITNESS;
    int MAX_LIFESPAN;
    // this boolean will act as a flag in the Creature.run() method
    boolean isAlive;

    // Accessor methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getIdentifier() {
        return identifier;
    }

    public double getFitness() {
        return FITNESS;
    } 

    // Mutator methods
    public void kill() {
        isAlive = false;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    // method to determines whether the creature
    // reproduces or not based on its fitness
    public boolean reproduces() {
        double d = rand.nextDouble() * 1;

        if (d < FITNESS) {
            return true;
        }
        else return false;
    }
    
    public abstract void run();
}