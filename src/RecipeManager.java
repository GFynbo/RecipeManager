public class RecipeManager {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the RecipeManager.");

        Directions dirs = new Directions(4);
        CookTime time = new CookTime(15);
        Review rv = new Review(4);
        Ingredient[] ing = new Ingredient[5];

        Recipe meatballs = new Recipe(ing, dirs, time, rv);
    }
}
