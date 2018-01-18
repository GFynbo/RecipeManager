package recipe;

import java.util.Scanner;

public class CookTime implements java.io.Serializable {
    private String totalTime;

    public CookTime(String time) {
        this.totalTime = time;
        System.out.println("This is the cook time constructor with a total time " + totalTime + "!");
    }

    public CookTime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the cook time constructor!");
        System.out.println("Please input the total cooking time: ");
        String time = (sc.nextLine());
        this.totalTime = time;
    }

    public String returnTime() {
        return this.totalTime;
    }
}
