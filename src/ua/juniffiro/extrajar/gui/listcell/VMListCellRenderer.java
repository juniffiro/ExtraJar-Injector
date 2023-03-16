package ua.juniffiro.extrajar.gui.listcell;

import com.sun.tools.attach.VirtualMachineDescriptor;

import javax.swing.*;
import java.awt.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class VMListCellRenderer extends DefaultListCellRenderer {

    /**
     * Modify ListCellRendererComponent.
     */
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof VirtualMachineDescriptor) {
            VirtualMachineDescriptor vmd = (VirtualMachineDescriptor) value;
            String title = vmd.displayName();
            if (title.isEmpty()) {
                title = "<unknown>";
            }
            if (title.length() > 50) {
                title = title.substring(0, 50);
            }
            label.setText(String.format(
                    "JVM => %s | %s", vmd.id(), title));
        } else {
            label.setText("{JVM}");
        }
        return label;
    }
}