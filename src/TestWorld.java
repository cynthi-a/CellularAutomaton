/*  
Cynthia Lee - AE1
    Cellular automaton program that lets the user decide whether
    or not to enable wrapping. Grid is always of fixed size
    (15, 20). Upon start, two creature of type Creature2
    and one creature of type Creature1 are placed on the grid 
    */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestWorld {

    public static void main(String[] args) {
        boolean wrappingOn = getWrappingBoolean();

        // new grid object
        Grid grid = new Grid(wrappingOn, 15, 20);

        // creatures are set on the grid
        new Creature1(grid, 0,0);
        new Creature2(grid, 13,19);
        new Creature2(grid, 10,10);

        // grid reprints itself every 0.5 seconds
        while (true) {
            System.out.println(grid);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // method to ask the user if they want to enable wrapping
    private static boolean getWrappingBoolean() {

        System.out.println("Do you want to enable wrapping? (y/n): ");
        Scanner sc = new Scanner(System.in);

        // input 'y' to indicate yes as an answer
        if (sc.next().equals("y")) {
            System.out.println("Wrapping enabled.");
            return true;
        }
        // otherwise it is assumed that no is the answer
        else {
            System.out.println("Wrapping disabled.");
            return false;
        }
    }
}
