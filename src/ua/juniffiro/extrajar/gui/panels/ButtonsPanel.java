package ua.juniffiro.extrajar.gui.panels;

import ua.juniffiro.extrajar.gui.Button;
import ua.juniffiro.extrajar.gui.listcell.VMListModel;
import ua.juniffiro.extrajar.log.Log;
import ua.juniffiro.extrajar.utils.WindowMessage;
import ua.juniffiro.extrajar.utils.FileUtils;
import ua.juniffiro.extrajar.utils.VMUtils;
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachineDescriptor;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 06/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class ButtonsPanel extends JPanel {

    public ButtonsPanel(JList<VirtualMachineDescriptor> jList, VMListModel listModel) {
        add(new Button("Next").onClick(actionEvent -> {
            JFileChooser fileChooser = FileUtils.chooseFile(FileUtils.HOME);
            int result = fileChooser.showOpenDialog(null);
            if (result != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File agent = fileChooser.getSelectedFile();
            if (agent == null) {
                return;
            }
            if (!FileUtils.checkExtension(agent, ".jar")) {
                WindowMessage.info("File error", "The Java-Agent must have a " +
                        ".jar file extension.");
                return;
            }
            try {
                VMUtils.attach(agent, jList.getSelectedValue());
            } catch (IOException | AgentInitializationException | AttachNotSupportedException | AgentLoadException e) {
                e.printStackTrace();
                WindowMessage.info("Load result", e.getMessage());
            }
        }));

        add(new Button("Refresh").onClick(actionEvent -> listModel.refreshElements()));
    }
}
