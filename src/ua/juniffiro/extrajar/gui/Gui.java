package ua.juniffiro.extrajar.gui;

import ua.juniffiro.extrajar.gui.panels.MainPanel;

import javax.swing.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Gui extends JFrame {

    public Gui() {

        add(new MainPanel());

        setTitle("ExtraJar | Coded by Juniffiro");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // setSize(500, 400);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
