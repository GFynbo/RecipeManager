public class Review {
    int stars;

    public Review(int givenStars) {
        stars = givenStars;
        System.out.println("This is the review constructor with a review of " + stars + " stars!");
    }

    public Review() {
        System.out.println("This is the review constructor!");
    }
}
