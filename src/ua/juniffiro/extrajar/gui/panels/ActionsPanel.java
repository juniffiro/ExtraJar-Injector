package ua.juniffiro.extrajar.gui.panels;

import ua.juniffiro.extrajar.gui.listcell.VMListModel;
import ua.juniffiro.extrajar.gui.panels.actions.VMJList;
import com.sun.tools.attach.VirtualMachineDescriptor;

import javax.swing.*;
import java.awt.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class ActionsPanel extends JPanel  {

    private final VMListModel listModel; // Virtual Machines list model for JList
    private final JScrollPane scrollPane;
    private final JPanel buttonsPanel;

    public ActionsPanel() {
        setLayout(new GridLayout(2, 1));
        this.listModel = new VMListModel();
        JList<VirtualMachineDescriptor> jList = new VMJList(listModel);

        this.scrollPane = new JScrollPane(jList);
        this.buttonsPanel = new ButtonsPanel(jList, listModel);

        init();
    }

    private void init() {
        listModel.addElements();
        add(scrollPane);
        add(buttonsPanel);
    }
}
