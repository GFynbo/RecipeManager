import java.util.Scanner;

public class Directions {
    String[] directions;

    public Directions(int numSteps) {
        System.out.println("This is the directions constructor!");
        directions = new String[numSteps];

        Scanner getDirections = new Scanner(System.in);

        // have the user input the directions
        for (int i = 0; i < numSteps; i++) {
            System.out.println("Input step " + (i + 1) + ": ");
            directions[i] = getDirections.nextLine();
        }
        // return directions to user so they can see what they wrote
        for (int i = 0; i < numSteps; i++) {
            System.out.println("Step " + (i + 1) + ": " + directions[i]);
        }
    }

    public Directions() {
        // get the number of steps
        Scanner getDirections = new Scanner(System.in);
        System.out.println("Input the total number of steps here: ");
        int numSteps = Integer.parseInt(getDirections.nextLine());

        // setup directions
        directions = new String[numSteps];

        // have the user input the directions
        for (int i = 0; i < numSteps; i++) {
            System.out.println("Input step " + (i + 1) + ": ");
            directions[i] = getDirections.nextLine();
        }
        // return directions to user so they can see what they wrote
        for (int i = 0; i < numSteps; i++) {
            System.out.println("Step " + (i + 1) + ": " + directions[i]);
        }
    }

    public int returnDirectionCount() {
        return directions.length;
    }

    public String[] returnDirections() {
        return directions;
    }
}
