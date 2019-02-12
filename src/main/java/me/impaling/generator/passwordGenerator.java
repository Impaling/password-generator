package me.impaling.generator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Random;

public class passwordGenerator extends Application {

    private String lowercase = "abcdefghijklmnopqrstuvwxyz";
    private String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String numbers = "0123456789";
    private String symbols = "!@#$%^&*()<>.,";
    Notification notification = new Notification();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Impaling's Password Generator");
        primaryStage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("impaling.png")); // JavaFX image.
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene (root, 238, 278));
        primaryStage.show();
        notification.initiateTray();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String characterBuilder(boolean uppercase, boolean numeric, boolean symbolic) {
        String characterLibrary = this.lowercase;

        if (uppercase) {
            characterLibrary += this.uppercase;
        }
        if (numeric) {
            characterLibrary += this.numbers;
        }
        if (symbolic) {
            characterLibrary += this.symbols;
        }
        Random randomPosition = new Random();
        int arrayPosition = randomPosition.nextInt(characterLibrary.length() - 1); // Gets a random number between 0 and the character length but one less, as array positions start at 0, length would return 1 as the first value.
        return String.valueOf(characterLibrary.charAt(arrayPosition)); // Returns the string value of the random character selected out of the string "characterLibrary".
    }

}
