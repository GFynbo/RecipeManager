package recipe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class RecipeController {

    @FXML private MenuBar myMenu;
    @FXML private ListView<Recipe> recipeList;

    @FXML
    protected void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) myMenu.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void addRecipe(ActionEvent actionEvent) {
        ObservableList<Recipe> recipes = FXCollections.observableArrayList();

        String name = "Meatballs";
        Ingredient ings = new Ingredient("Salt", "1 Tbsp");
        Directions direct = new Directions(3);
        CookTime ct = new CookTime(15);
        Review rv = new Review(4);

        Recipe mb = new Recipe(name, ings, direct, ct, rv);
        recipes.add(mb);

        recipeList = new ListView<>(recipes);

        recipeList.setCellFactory(param -> new ListCell<Recipe>() {
            @Override
            protected void updateItem(Recipe recp, boolean empty) {
                super.updateItem(recp, empty);

                if (empty || recp == null || recp.toString() == null) {
                    setText(null);
                } else {
                    setText(recp.toString());
                }
            }
        });
    }
}
