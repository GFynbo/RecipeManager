package recipe;

import java.util.Scanner;

public class CookTime implements java.io.Serializable {
    private String totalTime;

    public CookTime(String time) {
        this.totalTime = time;
        System.out.println("This is the cook time constructor with a total time " + totalTime + "!");
    }

    public CookTime() {
        System.out.println("This is the cook time constructor!");
    }

    public String returnTime() {
        return this.totalTime;
    }
}
