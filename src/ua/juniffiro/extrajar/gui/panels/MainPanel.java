package ua.juniffiro.extrajar.gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        setLayout(new BorderLayout());
        add(new ProgramInfoPanel(), BorderLayout.NORTH);
        add(new ActionsPanel(), BorderLayout.CENTER);
    }
}
