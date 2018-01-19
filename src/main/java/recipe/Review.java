package recipe;

import java.util.Scanner;

public class Review implements java.io.Serializable {
    private int stars;

    public Review(int givenStars) {
        this.stars = givenStars;
        System.out.println("This is the review constructor with a review of " + stars + "/5 stars!");
    }

    public Review() {
        System.out.println("This is the review constructor!");
    }

    public int returnStars() {
        return this.stars;
    }
}
