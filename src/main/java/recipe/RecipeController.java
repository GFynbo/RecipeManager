package recipe;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {

    @FXML private MenuBar myMenu;
    @FXML private ListView<Recipe> recipeList = new ListView<Recipe>();
    @FXML private Label recipeTitle;
    @FXML private VBox recipeMain;
    @FXML private VBox recipeListBox;

    @FXML
    protected void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) myMenu.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void addRecipe(ActionEvent actionEvent) throws Exception {
        recipeMain.getChildren().clear();
        recipeListBox.setDisable(true);
        recipeTitle.setText("New Recipe");
        Button backButton = new Button("Back");
        Label nameLabel = new Label("Recipe name: ");
        TextField name = new TextField();
        Label cookLabel = new Label("Total cooking time: ");
        TextField cook = new TextField();
        Label ingsLabel = new Label("Ingredients: ");
        TextArea ingredients = new TextArea();
        Label dirsLabel = new Label("Directions: ");
        TextArea directions = new TextArea();
        Button createRecipe = new Button("Create");
        recipeMain.getChildren().addAll(recipeTitle, backButton, nameLabel, name, cookLabel, cook, ingsLabel, ingredients, dirsLabel,
                directions, createRecipe);
        backButton.addEventHandler(ActionEvent.ACTION, (e) -> {
            recipeListBox.setDisable(false);
            recipeMain.getChildren().clear();
            recipeList.getSelectionModel().selectFirst();
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Recipe> recipes = FXCollections.observableArrayList();

        // Add initial recipes for testing
        String name = "Meatballs";
        String[] dirs = {"Combine beef, veal, and pork in a large bowl. Add garlic, eggs, cheese, parsley, salt and pepper.",
                "Blend bread crumbs into meat mixture. Slowly add the water 1/2 cup at a time. The mixture should be very moist but still hold its shape if rolled into meatballs. (I usually use about 1 1/4 cups of water). Shape into meatballs.",
                "Heat olive oil in a large skillet. Fry meatballs in batches. When the meatball is very brown and slightly crisp remove from the heat and drain on a paper towel. (If your mixture is too wet, cover the meatballs while they are cooking so that they hold their shape better.)"};
        Ingredient ings = new Ingredient("Salt", "1 Tbsp");
        Directions direct = new Directions(3, dirs);
        CookTime ct = new CookTime(15);
        Review rv = new Review(4);

        Recipe mb = new Recipe(name, ings, direct, ct, rv);
        recipes.add(mb);

        name = "Spaghetti";
        String[] directs = {"Combine ground beef, onion, garlic, and green pepper in a large saucepan. Cook and stir until meat is brown and vegetables are tender. Drain grease.",
                "Stir diced tomatoes, tomato sauce, and tomato paste into the pan. Season with oregano, basil, salt, and pepper. Simmer spaghetti sauce for 1 hour, stirring occasionally."};
        ings = new Ingredient("Salt", "1 tsp");
        direct = new Directions(3, directs);
        ct = new CookTime(10);
        rv = new Review(5);

        Recipe spg = new Recipe(name, ings, direct, ct, rv);
        recipes.add(spg);

        recipeList.setItems(recipes);

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
                recipeMain.setPadding(new Insets(10));
                recipeMain.setSpacing(10);
            }
        });
    }
}
