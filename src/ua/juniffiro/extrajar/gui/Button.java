package ua.juniffiro.extrajar.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 06/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Button extends JButton {

    /*
    Wrapper for JButton
     */

    public Button() {}

    public Button(String s) {
        super(s);
    }

    public Button setTitle(String title) {
        setTitle(title);
        return this;
    }

    public Button onClick(ActionListener actionListener) {
        addActionListener(actionListener);
        return this;
    }
}
