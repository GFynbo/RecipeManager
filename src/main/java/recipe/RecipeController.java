package recipe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class RecipeController {
    @FXML MenuBar myMenu;
    @FXML MenuItem myMenuClose;

    @FXML
    protected void closeWindow(ActionEvent actionEvent) {
        Stage stg = (Stage)myMenu.getScene().getWindow();
        Scene scn = stg.getScene();
        stg.setScene(scn);
        stg.close();
    }
}
