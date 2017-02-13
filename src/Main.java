import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid(10, 10);
        List<Creature> creatures = new ArrayList<>();
        creatures.add(new Creature(grid, 5, 5));

        for (Creature creature : creatures) {
            Thread thread = new Thread(creature);
            thread.start();
        }

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
