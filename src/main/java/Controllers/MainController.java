package Controllers;

import DataBase.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {

    @FXML
    private TextField wordField;
    @FXML
    private TextField translateField;

    @FXML
    private void buttonSave() throws SQLException {

        System.out.println(wordField.getText() + translateField.getText());
        int rand_num = (int) (Math.random() * 10);
        new DBConnection().insert(rand_num+1, wordField.getText(), translateField.getText());

    }

}
