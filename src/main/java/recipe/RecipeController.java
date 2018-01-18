package recipe;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {

    @FXML private MenuBar myMenu;
    @FXML private ListView<Recipe> recipeList = new ListView<Recipe>();
    @FXML private Label recipeTitle;
    @FXML private VBox recipeMain;
    @FXML private VBox recipeListBox;
    @FXML private ObservableList<Recipe> recipes = FXCollections.observableArrayList();

    @FXML
    protected void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) myMenu.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void addRecipe(ActionEvent actionEvent) throws Exception {
        // clear window for the inputs and disable the menu
        recipeMain.getChildren().clear();
        recipeListBox.setDisable(true);

        // update labels and set them on the page with inputs and validation
        ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.setErrorDecorationEnabled(false);
        recipeTitle.setText("New Recipe");
        Button backButton = new Button("Back");

        Label nameLabel = new Label("Recipe name: ");
        TextField name = new TextField();
        validationSupport.registerValidator(name, Validator.createEmptyValidator("Recipe name is required"));

        Label cookLabel = new Label("Total cooking time: ");
        TextField cook = new TextField();
        validationSupport.registerValidator(cook, Validator.createEmptyValidator("Cooking time is required"));

        Label ratingLabel = new Label("Rating: ");
        Rating rate = new Rating(5);

        Label ingsLabel = new Label("Ingredients: ");
        TextArea ingredients = new TextArea();
        validationSupport.registerValidator(ingredients, Validator.createEmptyValidator("Ingredients are required"));

        Label dirsLabel = new Label("Directions: ");
        TextArea directions = new TextArea();
        validationSupport.registerValidator(directions, Validator.createEmptyValidator("Directions are required"));

        Button createRecipe = new Button("Create");
        recipeMain.getChildren().addAll(recipeTitle, backButton, nameLabel, name, cookLabel, cook, ratingLabel, rate, ingsLabel, ingredients, dirsLabel,
                directions, createRecipe);

        // the two buttons on the main pane
        // back button
        backButton.addEventHandler(ActionEvent.ACTION, (e) -> {
            recipeListBox.setDisable(false);
            recipeMain.getChildren().clear();
            recipeList.getSelectionModel().selectFirst();
        });

        // create button
        createRecipe.addEventHandler(ActionEvent.ACTION, (e) -> {
            // show validation errors if its invalid
            if (validationSupport.isInvalid()) {
                validationSupport.setErrorDecorationEnabled(true);
                validationSupport.redecorate();
            }
            // create recipe and move back to the main menu
            else {
                // add the recipe here
                String recipeName = name.getText();
                Ingredient ings = new Ingredient(ingredients.getText());
                Directions direct = new Directions(directions.getText());
                CookTime ct = new CookTime(cook.getText());
                Review rv = new Review((int) rate.getRating());

                Recipe mb = new Recipe(recipeName, ings, direct, ct, rv);
                recipes.add(mb);

                // re-enable the menu and reload the screen
                recipeListBox.setDisable(false);
                recipeMain.getChildren().clear();
                recipeList.getSelectionModel().selectLast();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Add initial recipes for testing
        String name = "Meatballs";
        String dirs = "Combine beef, veal, and pork in a large bowl. Add garlic, eggs, cheese, parsley, salt and pepper.\n" +
                "Blend bread crumbs into meat mixture. Slowly add the water 1/2 cup at a time. The mixture should be very moist but still hold its shape if rolled into meatballs. (I usually use about 1 1/4 cups of water). Shape into meatballs.\n" +
                "Heat olive oil in a large skillet. Fry meatballs in batches. When the meatball is very brown and slightly crisp remove from the heat and drain on a paper towel. (If your mixture is too wet, cover the meatballs while they are cooking so that they hold their shape better.)";
        Ingredient ings = new Ingredient("1 Tbsp of salt");
        Directions direct = new Directions(dirs);
        CookTime ct = new CookTime("15 minutes");
        Review rv = new Review(4);

        Recipe mb = new Recipe(name, ings, direct, ct, rv);
        recipes.add(mb);

        name = "Spaghetti";
        String directs = "Combine ground beef, onion, garlic, and green pepper in a large saucepan. Cook and stir until meat is brown and vegetables are tender. Drain grease.\n" +
                "Stir diced tomatoes, tomato sauce, and tomato paste into the pan. Season with oregano, basil, salt, and pepper. Simmer spaghetti sauce for 1 hour, stirring occasionally.";
        ings = new Ingredient("1 pinch of salt");
        direct = new Directions(directs);
        ct = new CookTime("10 minutes");
        rv = new Review(5);

        Recipe spg = new Recipe(name, ings, direct, ct, rv);
        recipes.add(spg);

        // update the list item with the new recipes
        recipeList.setItems(recipes);

        // add custom list item functionality
        recipeList.setCellFactory(param -> new ListCell<Recipe>() {
            @Override
            protected void updateItem(Recipe item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });

        // update the main view when selection is changed
        recipeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Recipe>() {
            @Override
            public void changed(ObservableValue<? extends Recipe> observable, Recipe oldValue, Recipe newValue) {
                recipeMain.getChildren().clear();
                recipeTitle.setText(newValue.getName());
                Label recipeCookTime = new Label("Total cooking time: " + newValue.getCookTime() + " minutes");
                Label recipeReview = new Label("Your review: " + newValue.getReview() + "/5 stars");
                Label recipeIngredients = new Label("Ingredients:\n\n" + newValue.getIngredients() + "\n");
                Label recipeDirections = new Label("Directions:\n\n" + newValue.getDirections());
                recipeCookTime.setWrapText(true);
                recipeReview.setWrapText(true);
                recipeDirections.setWrapText(true);
                recipeIngredients.setWrapText(true);
                recipeMain.getChildren().addAll(recipeTitle, recipeCookTime, recipeReview, recipeIngredients, recipeDirections);
            }
        });
    }
}
