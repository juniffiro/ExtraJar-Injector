package ua.juniffiro.extrajar.utils;

import javax.swing.*;
import java.io.File;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class FileUtils {

    /**
     * User's home directory
     */
    public static File HOME = new File(System.getProperty("user.home"));

    /**
     * Get file extension.
     * On error it returns an empty string.
     *
     * @return File extension.
     */
    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }

    /**
     * Check if the file you are checking
     * has the required extension.
     * @param file
     *        File to check.
     * @param extension
     *        The necessary extension to check.
     */
    public static boolean checkExtension(File file, String extension) {
        return getFileExtension(file).equals(extension);
    }

    /**
     * Select file from directory.
     * @param openDirectory
     *        Directory that will be initially
     *        selected and opened in the file
     *        selection window.
     * @return Returns the file selection window.
     */
    public static JFileChooser chooseFile(File openDirectory) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(openDirectory);
        return fileChooser;
    }
}
