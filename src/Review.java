import java.util.Scanner;

public class Review {
    int stars;

    public Review(int givenStars) {
        stars = givenStars;
        System.out.println("This is the review constructor with a review of " + stars + " stars!");
    }

    public Review() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the review constructor!");

        System.out.println("Please input your review out of five stars: ");
        stars = Integer.parseInt(sc.nextLine());
    }
}
