package Controllers;

import DataBase.DBConnection;
import Model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ListController implements Initializable {


    private ObservableList<Word> wordList = FXCollections.observableArrayList();

    Runnable updateData = new Runnable() {
        @Override
        public void run() {
            try {
                wordList = new DBConnection().select();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    };

    @FXML
    public TableColumn<Word, String> wordColumn;
    @FXML
    public TableColumn<Word, String> translationColumn;
    @FXML
    public TableColumn<Word, Integer> idColumn;
    @FXML
    public TableView<Word> tableView ;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        wordColumn.setCellValueFactory(new PropertyValueFactory<>("word"));
        translationColumn.setCellValueFactory(new PropertyValueFactory<>("translation"));

        updateData.run();

        tableView.setItems(wordList);
    }

    public void updateView() {
        initialize();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
