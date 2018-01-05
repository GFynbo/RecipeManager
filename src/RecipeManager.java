import java.util.Scanner;

public class RecipeManager {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the RecipeManager.");
        Scanner sc = new Scanner(System.in);

        Directions dirs = new Directions();
        CookTime time = new CookTime();
        Review rv = new Review();
        Ingredient ing = new Ingredient();
        System.out.println("Input recipe name: ");
        String recipeName = sc.nextLine();

        Recipe meatballs = new Recipe(recipeName, ing, dirs, time, rv);

        System.out.println(meatballs);
    }
}
