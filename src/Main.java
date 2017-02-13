import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid(10, 10);

        AbstractCreature creature1 = new Creature1(grid, 5, 5);

        while (true) {
            System.out.println(grid);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
