package recipe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController {

    @FXML
    private MenuBar myMenu;
    private MenuItem myMenuClose;

    @FXML
    protected void closeWindow(ActionEvent actionEvent) {
        Stage stg = (Stage)myMenu.getScene().getWindow();
        Scene scn = stg.getScene();
        stg.setScene(scn);
        stg.close();
    }
}
