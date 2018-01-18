package recipe;

import java.util.Scanner;

public class Directions implements java.io.Serializable {
    private String directions;

    public Directions(String directions) {
        System.out.println("This is the directions constructor!");
        this.directions = directions;
    }

    public Directions() {
        // get the number of steps
        Scanner getDirections = new Scanner(System.in);

        // setup directions
        this.directions = new String();
        int stepCount = 0;

        // have the user input the directions
        while (true) {
            stepCount++;
            System.out.println("Input step (q/Q to quit):");
            String tempDirections = getDirections.nextLine();
            if (tempDirections.equals("q") || tempDirections.equals("Q")) {
                break;
            }
            else {
                directions += "\nStep " + stepCount + ": " + tempDirections +"\n\n";
            }
        }
    }

    public int returnDirectionCount() {
        return 1;
    }

    public String returnDirections() {
        return this.directions;
    }
}
