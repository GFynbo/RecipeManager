package recipe;

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
        this.ings = ingredients;
        this.dirs = directions;
        this.cts = ct;
        this.rv = review;
        this.name = recipeName;
    }

    public Recipe() {
        System.out.println("Assemble recipe without given ingredients.");
    }

    public String getName() {
        String recipePrint;

        recipePrint = name;

        return recipePrint;
    }

    public String getReview() {
        String review = new String(Integer.toString(rv.returnStars()));
        return review;
    }

    public String getCookTime() {
        String cook = new String(Integer.toString(cts.returnTime()));
        return cook;
    }

    public String toString() {
        String recipePrint;

        recipePrint = name;

//        String[] steps = dirs.returnDirections();
//
//        recipePrint += (name + "\n\n");
//        recipePrint += ("Cooking time: " + cts.returnTime() + " minutes\n\n");
//        recipePrint += ("Ingredients:\n");
//        recipePrint += (ings.returnIngredient() + " - " + ings.returnMeasurement() + "\n\n");
//        recipePrint += ("recipe.Directions:\n");
//        for (int i = 0; i < dirs.returnDirectionCount(); i++) {
//            recipePrint += ("Step " + (i + 1) + ": " + steps[i] + "\n");
//        }
//        recipePrint += ("\n");
//        recipePrint += ("recipe.Review: " + rv.returnStars() + "/5");

        return recipePrint;
    }
}
