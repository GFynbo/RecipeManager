package recipe;

import java.util.Scanner;

public class CookTime {
    private int totalTime;

    public CookTime(int time) {
        this.totalTime = time;
        System.out.println("This is the cook time constructor with a total time " + totalTime + "!");
    }

    public CookTime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the cook time constructor!");
        System.out.println("Please input the total cooking time: ");
        int time = Integer.parseInt(sc.nextLine());
        this.totalTime = time;
    }

    public int returnTime() {
        return this.totalTime;
    }
}
