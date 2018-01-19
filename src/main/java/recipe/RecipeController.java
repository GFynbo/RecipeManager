package recipe;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.lang.reflect.Type;
import java.net.URL;
import java.io.*;
import java.util.*;

public class RecipeController implements Initializable {

    @FXML private MenuBar myMenu;
    @FXML private ListView<Recipe> recipeList = new ListView<Recipe>();
    @FXML private Label recipeTitle;
    @FXML private VBox recipeMain;
    @FXML private VBox recipeListBox;
    @FXML private ObservableList<Recipe> recipes = FXCollections.observableArrayList();
    final File file = new File("/tmp/recipes.json");

    public void saveChanges() {
        try {
            Gson gson = new Gson();

            try (final FileWriter fileWriter = new FileWriter(file)) {
                gson.toJson(recipes, fileWriter);
            }
            System.out.printf("Serialized data is saved in /tmp/recipes.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

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
        rate.setUpdateOnHover(false);

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

        // deserialize and add recipes from saved data
        Gson gson = new Gson();
        try (final FileReader fileReader = new FileReader(file)) {
            ArrayList<Recipe> tempRecipes = gson.fromJson(fileReader, new TypeToken<ArrayList<Recipe>>() {}.getType());
            recipes = FXCollections.observableArrayList(tempRecipes);
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }

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
                recipeTitle.setStyle("-fx-font: 24 arial;");
                Label recipeCookTime = new Label("Total cooking time: " + newValue.getCookTime() + " minutes.\n");
                Label recipeReview = new Label("Your review: " + newValue.getReview() + "/5 stars.\n");
                Label recipeIngredients = new Label("Ingredients:\n\n" + newValue.getIngredients() + "\n");
                Label recipeDirections = new Label("Directions:\n\n" + newValue.getDirections());
                FlowPane textFlow = new FlowPane(recipeCookTime, recipeReview, recipeIngredients, recipeDirections);
                //textFlow.setStyle("-fx-font: 14 arial;");
                recipeMain.getChildren().addAll(recipeTitle, textFlow);
            }
        });
    }
}
