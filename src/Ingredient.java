import java.util.Scanner;

public class Ingredient {
    String ingredient;
    String measurement;

    public Ingredient(String ingredientName, String measurementAmt) {
        System.out.println("This is the ingredient constructor!");
        ingredient = ingredientName;
        measurement = measurementAmt;
    }

    public Ingredient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the ingredient constructor!");
        System.out.println("Please input the ingredient name: ");
        ingredient = sc.nextLine();
        System.out.println("Please input the amount: ");
        measurement = sc.nextLine();
    }
}
