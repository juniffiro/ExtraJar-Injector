package ua.juniffiro.extrajar.gui.listcell;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import javax.swing.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class VMListModel extends DefaultListModel<VirtualMachineDescriptor> {

    /**
     * Create a new list of VMs
     */
    public void addElements() {
        VirtualMachine.list().forEach(vmd -> {
            System.out.println(vmd.displayName());
            addElement(vmd);
        });
    }

    /**
     * Refresh model
     */
    public void refreshElements() {
        clear();
        addElements();
    }
}
