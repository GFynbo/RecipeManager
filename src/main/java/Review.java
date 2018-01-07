import java.util.Scanner;

public class Review {
    private int stars;

    public Review(int givenStars) {
        this.stars = givenStars;
        System.out.println("This is the review constructor with a review of " + stars + "/5 stars!");
    }

    public Review() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the review constructor!");

        System.out.println("Please input your review out of five stars: ");
        this.stars = Integer.parseInt(sc.nextLine());
    }

    public int returnStars() {
        return this.stars;
    }
}
