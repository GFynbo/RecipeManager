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
    @FXML private Label recipeCookTime;
    @FXML private Label recipeReview;
    @FXML private Label recipeIngredients;
    @FXML private Label recipeDirections;
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
        Label nameLabel = new Label("Recipe name: ");
        TextField name = new TextField();
        Label cookLabel = new Label("Total cooking time: ");
        TextField cook = new TextField();
        Label ingsLabel = new Label("Ingredients: ");
        TextArea ingredients = new TextArea();
        Label dirsLabel = new Label("Directions: ");
        TextArea directions = new TextArea();
        Button createRecipe = new Button("Create");
        recipeMain.getChildren().addAll(recipeTitle, nameLabel, name, cookLabel, cook, ingsLabel, ingredients, dirsLabel,
                directions, createRecipe);
        createRecipe.addEventHandler(ActionEvent.ACTION, (e) -> {
            recipeListBox.setDisable(false);
            recipeListBox.requestFocus();
            recipeMain.getChildren().clear();
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Recipe> recipes = FXCollections.observableArrayList();

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
                recipeCookTime.setText("Total cooking time: " + newValue.getCookTime() + " minutes");
                recipeReview.setText("Your review: " + newValue.getReview() + "/5 stars");
                recipeIngredients.setText("Ingredients:\n\n" + newValue.getIngredients() + "\n");
                recipeDirections.setText("Directions:\n\n" + newValue.getDirections());
                recipeMain.getChildren().addAll(recipeTitle, recipeCookTime, recipeReview, recipeIngredients, recipeDirections);
                recipeMain.setPadding(new Insets(10));
                recipeMain.setSpacing(10);
            }
        });
    }
}
