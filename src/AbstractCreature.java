import java.util.Random;

public abstract class AbstractCreature implements Runnable {
	Grid grid;
	char identifier;
    Random rand = new Random();
    int x;
    int y;
    int lifespan;
	double FITNESS;
    int MAX_LIFESPAN;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean babyYayOrNay() {
        double d = rand.nextDouble() * 1;

        if (d < FITNESS) {
            return true;
        }
        else return false;
    }

    public char getIdentifier() {
    	return identifier;
    }
    
    public abstract void run();

    public double getFitness() {
        return FITNESS;
    }
}