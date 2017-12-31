public class Directions {
    String[] directions;

    public Directions(int numSteps) {
        System.out.println("This is the directions constructor!");
        directions = new String[numSteps];
    }

    public Directions() {
        System.out.println("Please input the number of steps.");
    }

    public int returnDirectionCount() {
        return directions.length;
    }
}
