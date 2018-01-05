public class RecipeManager {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the RecipeManager.");

        Directions dirs = new Directions();
        CookTime time = new CookTime();
        Review rv = new Review();
        Ingredient[] ing = new Ingredient[5];

        Recipe meatballs = new Recipe(ing, dirs, time, rv);

        Manager mg = new Manager();
    }
}
