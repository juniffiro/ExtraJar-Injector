package ua.juniffiro.extrajar.gui.panels.actions;

import ua.juniffiro.extrajar.gui.listcell.VMListCellRenderer;
import ua.juniffiro.extrajar.gui.listcell.VMListModel;
import com.sun.tools.attach.VirtualMachineDescriptor;

import javax.swing.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 06/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class VMJList extends JList<VirtualMachineDescriptor> {

    public VMJList(VMListModel vms) {
        setModel(vms);
        setCellRenderer(new VMListCellRenderer()); // jList view
        setVisibleRowCount(5);
        setFixedCellHeight(20);
        setFixedCellWidth(500);
    }
}
