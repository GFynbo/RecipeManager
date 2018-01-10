package recipe;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {

    @FXML private MenuBar myMenu;
    @FXML private ListView<Recipe> recipeList = new ListView<Recipe>();
    @FXML private Label recipeTitle;
    @FXML private Label recipeCookTime;
    @FXML private Label recipeReview;

    @FXML
    protected void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) myMenu.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void addRecipe(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Recipe> recipes = FXCollections.observableArrayList();

        String name = "Meatballs";
        Ingredient ings = new Ingredient("Salt", "1 Tbsp");
        Directions direct = new Directions(3);
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
                recipeTitle.setText(newValue.getName());
                recipeCookTime.setText("Total cooking time: " + newValue.getCookTime() + " minutes");
                recipeReview.setText("Your review: " + newValue.getReview() + "/5 stars");
            }
        });
    }
}
