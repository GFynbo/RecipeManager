public class Recipe {
    // class variables for the recipe
    private Ingredient[] ings;
    private Directions dirs;
    private CookTime cts;
    private Review rv;

    // constructor for the recipe class, gets the required components and assembles the recipe
    public Recipe(Ingredient[] ingredients, Directions directions, CookTime ct, Review review) {
        System.out.println("Assembling the new recipe!");
        ings = ingredients;
        dirs = directions;
        cts = ct;
        rv = review;
    }
}
