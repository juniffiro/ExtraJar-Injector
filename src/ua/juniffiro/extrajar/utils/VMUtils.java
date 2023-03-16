package ua.juniffiro.extrajar.utils;

import com.sun.tools.attach.*;
import ua.juniffiro.extrajar.log.Log;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class VMUtils {

    /**
     * Get all virtual machine descriptors
     * at the current time.
     */
    public static List<VirtualMachineDescriptor> getAllVms() {
        return VirtualMachine.list();
    }

    /**
     * Get VMD by Display Name.
     * @return Returns the VMD in Optional wrapper.
     */
    public static Optional<VirtualMachineDescriptor> getVmdByName(String displayName) {
        return VirtualMachine.list()
                .stream()
                .filter(vmd -> {
                    Log.info(vmd.displayName());
                    return vmd.displayName().contains(displayName);
                })
                .findFirst();
    }

    /**
     * Get VMD by PID.
     * @return Returns the VMD in Optional wrapper.
     */
    public static Optional<VirtualMachineDescriptor> getVmdByPid(String pid) {
        return VirtualMachine.list()
                .stream()
                .filter(vmd -> {
                    Log.info(vmd.displayName());
                    return vmd.id().equals(pid);
                })
                .findFirst();
    }

    /**
     * Attach the Java agent to VMD.
     * @param agent
     *        Java agent
     * @param vmd
     *        VirtualMachineDescriptor
     * @return Operation Result
     *         You can check if the agent
     *         was loaded successfully.
     */
    public static boolean attach(File agent, VirtualMachineDescriptor vmd) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        if (!agent.exists() || agent.isDirectory()) {
            Log.log(Level.SEVERE, "File %s problem", agent.getName());
            return false;
        }
        if (vmd == null) {
            Log.log(Level.SEVERE, "VM %s not found.");
            return false;
        }
        String pid = vmd.id();
        VirtualMachine vm = VirtualMachine.attach(pid);
        loadAgent(vm, agent);
        return true;
    }

    /**
     * Method for loading a Java agent
     * into the JVM.
     * @param vm
     *        Virtual machine
     * @param agent
     *        Java agent
     */
    private static void loadAgent(VirtualMachine vm, File agent) throws AgentLoadException, IOException, AgentInitializationException {
        Log.info("Trying to load an agent into the JVM");
        vm.loadAgent(agent.getAbsolutePath());
        vm.detach();
        Log.info("Agent loaded in JVM.");
    }

    /**
     * Attach the Java agent to the VMD,
     * using the displayed name to find
     * the desired descriptor.
     *
     * @param agent
     *        Java agent
     * @param displayName
     *        VMD Display Name.
     * @return Operation Result
     *         You can check if the agent
     *         was loaded successfully.
     *
     * @throws AgentLoadException
     *         If agent cannot be loaded
     *         into the target Java virtual
     *         machine.
     *
     * @throws IOException
     *         If there is a problem with
     *         the agent file.
     *
     * @throws AttachNotSupportedException
     *         Thrown by VirtalMachine.attach when attempting
     *         to attach to a Java virtual machine for which
     *         a compatible AttachProvider does not exist.
     *         It is also thrown by AttachProvider.attachVirtualMachine
     *         if the provider attempts to attach to a Java virtual machine
     *         with which it not compatible.
     *
     * @throws AgentInitializationException
     *         If an agent initialization error has occurred.
     */
    public static boolean attach(File agent, String displayName) throws AgentLoadException, IOException, AttachNotSupportedException, AgentInitializationException {
        Optional<VirtualMachineDescriptor> vmd = getVmdByName(displayName);
        if (!vmd.isPresent()) {
            Log.log(Level.SEVERE, "VM %s not found.", displayName);
            return false;
        }
        attach(agent, vmd.get());
        return true;
    }
}