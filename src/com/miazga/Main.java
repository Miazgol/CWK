package com.miazga;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CWK.fxml"));
        Scene myScene = new Scene(root);
        primaryStage.setScene(myScene);
        primaryStage.setHeight(198);
        primaryStage.setWidth(315);
        primaryStage.setMaxHeight(198);
        primaryStage.setMaxWidth(315);
        primaryStage.setTitle("CWK");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
