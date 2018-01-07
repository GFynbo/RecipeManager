package recipe;

import javafx.scene.control.Label;

import javafx.event.ActionEvent;

public class RecipeController {
    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        this.helloWorld.setText("Hello, world!");
    }
}
