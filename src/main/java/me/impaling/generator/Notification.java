package me.impaling.generator;

import java.awt.*;

public class Notification {

    public static TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage("impaling.png"), "Password Generator by Impaling");

    public void initiateTray() throws AWTException {
        if (SystemTray.isSupported()) {
            trayIcon.setImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("impaling.png")));
            trayIcon.setImageAutoSize(true);
            SystemTray.getSystemTray().add(trayIcon);

        }
    }

    public void displayNotification(String message) throws AWTException {
        trayIcon.displayMessage("Impaling's Password Generator", message, TrayIcon.MessageType.NONE);
    }
}
