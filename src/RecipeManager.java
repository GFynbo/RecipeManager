
public class RecipeManager {

    public RecipeManager() {

        Directions dirs = new Directions(3);
        CookTime time = new CookTime(15);
        Review rv = new Review(4);
        Ingredient ing = new Ingredient("Salt", "2 tbsp");
        String recipeName = "Meatballs";

        Recipe meatballs = new Recipe(recipeName, ing, dirs, time, rv);
    }

    public static void main(String[] args) {

        // create initial test recipe
        System.out.println("Hello! Welcome to the RecipeManager.");


        // run the frame for the actual app

        RecipeManager mainRecipeManager = new RecipeManager();

    }
}
