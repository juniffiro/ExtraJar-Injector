package ua.juniffiro.extrajar.utils;

import javax.swing.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class WindowMessage {

    /**
     * Displaying a message from an
     * application in a dialog box.
     *
     * @param title
     *        Window title
     * @param text
     *        Message text
     */
    public static void info(String title, String text) {
        JOptionPane.showConfirmDialog(null, text, title, JOptionPane.DEFAULT_OPTION);
    }
}
