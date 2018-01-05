public class Recipe {
    // class variables for the recipe
    private Ingredient ings;
    private Directions dirs;
    private CookTime cts;
    private Review rv;
    private String name;

    // constructor for the recipe class, gets the required components and assembles the recipe
    public Recipe(String recipeName, Ingredient ingredients, Directions directions, CookTime ct, Review review) {
        System.out.println("Assembling the new recipe!");
        ings = ingredients;
        dirs = directions;
        cts = ct;
        rv = review;
        name = recipeName;
    }

    public Recipe() {
        System.out.println("Assemble recipe without given ingredients.");
    }

    public String toString() {
        String recipePrint = new String();

        String[] steps = dirs.returnDirections();

        recipePrint += (name + "\n\n");
        recipePrint += ("Cooking time: " + cts.returnTime() + " minutes\n\n");
        recipePrint += ("Ingredients:\n");
        recipePrint += (ings.returnIngredient() + " - " + ings.returnMeasurement() + "\n\n");
        recipePrint += ("Directions:\n");
        for (int i = 0; i < dirs.returnDirectionCount(); i++) {
            recipePrint += ("Step " + (i + 1) + ": " + steps[i] + "\n");
        }
        recipePrint += ("\n");
        recipePrint += ("Review: " + rv.returnStars() + "/5");

        return recipePrint;
    }
}
