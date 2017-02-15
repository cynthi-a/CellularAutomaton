import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // setWrappingBoolean();

        Grid grid = new Grid(setWrappingBoolean(), 20, 20);

        new Creature1(grid, 0,0);
        new Creature2(grid, 19,19);
        new Creature2(grid, 10,10);

        while (true) {
            System.out.println(grid);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean setWrappingBoolean() {
        System.out.println("Do you want to enable wrapping? (y/n): ");
        Scanner sc = new Scanner(System.in);
        if (sc.next().equals("y")) {
            System.out.println("Wrapping enabled.");
            return true;
        }
        else System.out.println("Wrapping disabled.");
        return false;
    }
}
