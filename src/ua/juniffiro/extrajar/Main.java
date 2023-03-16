package ua.juniffiro.extrajar;

import ua.juniffiro.extrajar.gui.Gui;

import javax.swing.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Gui::new);
    }
}
