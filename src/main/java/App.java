
import Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private final int windowWidth = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("TableApp");
        TabPane tab = new TabPane();
        tab.setTabMinWidth(windowWidth/3.5);

        Tab tab1 = new Tab("Tab 1");
        tab1.setContent(getTab1());
        tab1.setClosable(false);

        Tab tab2 = new Tab("ListTab");
        tab2.setContent(getTab2());
        tab2.setClosable(false);

        Tab tab3 = new Tab("Tab 3");
        tab3.setContent(getTab3());
        tab3.setClosable(false);

        tab.getTabs().addAll(tab1, tab2, tab3);

        Scene scene = new Scene(tab, windowWidth, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void go() {
        launch();
    }

    public Parent getTab1() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/mockup/testW.fxml"));

        return loader.load();
    }

    public Parent getTab2() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/mockup/testW2.fxml"));

        return loader.load();
    }

    public Parent getTab3() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/mockup/testW3.fxml"));

        return loader.load();
    }

}
