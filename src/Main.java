import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean wrapping;

    public static void main(String[] args) {
        wrapping = false;
        System.out.println("Do you want to enable wrapping? (y/n): ");
        Scanner sc = new Scanner(System.in);
        if (sc.next().equals("y")) {
            wrapping = true;
            System.out.println("Wrapping enabled.");
        }
        else System.out.println("Wrapping disabled.");

        Grid grid = new Grid(20, 20);

        new Creature1(grid, 0,0);
        new Creature2(grid, 19,19);

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
