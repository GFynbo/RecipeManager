package recipe;

import java.util.Scanner;

public class Ingredient implements java.io.Serializable {
    private String ingredient;

    public Ingredient(String ingredientName) {
        System.out.println("This is the ingredient constructor!");
        this.ingredient = ingredientName;
    }

    public Ingredient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the ingredient constructor!");
        System.out.println("Please input the ingredient name and measurement: ");
        this.ingredient = sc.nextLine();
    }

    public String returnIngredient() {
        return this.ingredient;
    }
}
