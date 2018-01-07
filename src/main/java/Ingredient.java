import java.util.Scanner;

public class Ingredient {
    private String ingredient;
    private String measurement;

    public Ingredient(String ingredientName, String measurementAmt) {
        System.out.println("This is the ingredient constructor!");
        this.ingredient = ingredientName;
        this.measurement = measurementAmt;
    }

    public Ingredient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the ingredient constructor!");
        System.out.println("Please input the ingredient name: ");
        this.ingredient = sc.nextLine();
        System.out.println("Please input the amount: ");
        this.measurement = sc.nextLine();
    }

    public String returnIngredient() {
        return this.ingredient;
    }

    public String returnMeasurement() {
        return this.measurement;
    }
}
