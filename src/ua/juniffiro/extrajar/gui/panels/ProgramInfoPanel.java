package ua.juniffiro.extrajar.gui.panels;

import javax.swing.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class ProgramInfoPanel extends JPanel {

    public ProgramInfoPanel() {
        JLabel jLabel = new JLabel();
        jLabel.setSize(5, 5);
        String s = "<html>" +
                "<p style=\"margin: 0 auto; text-align: center\">Select the desired JVM</p>" +
                "<br>" + "<p>If the process is not in the list, then the method does not work.</p>" +
                "<html>";
        jLabel.setText(s);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);

        add(jLabel);
    }
}
