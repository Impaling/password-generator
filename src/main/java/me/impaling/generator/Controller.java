package me.impaling.generator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Controller {

    private passwordGenerator passwordGenerator = new passwordGenerator();

    public JFXButton generateButton;
    public CheckBox uppercase;
    public CheckBox numbers;
    public CheckBox symbols;
    public Slider length;
    public JFXTextField passwordField;
    public Text lengthNumber;


    public void handleSliderUpdate(){
        lengthNumber.setText(String.valueOf(Math.round(length.getValue())));
    }

    public void handleButtonClick() throws AWTException {
        String password = "";
        for (int i = 0; i < length.getValue(); i++) { password += passwordGenerator.characterBuilder(uppercase.isSelected(), numbers.isSelected(), symbols.isSelected());}
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(password), null); // copies the password generated to the clipboard.
        passwordField.setText(password); // Sets the password text to the newly generated password.
        passwordGenerator.notification.displayNotification("The password was copied to your clipboard!");
    }
}
