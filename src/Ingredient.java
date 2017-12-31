public class Ingredient {
    String[] ingredients;

    public Ingredient(int numIngredients) {
        ingredients = new String[numIngredients];
        System.out.println("This is the ingredient constructor!");
    }

    public Ingredient() {
        System.out.println("This is the ingredient constructor!");
    }
}
