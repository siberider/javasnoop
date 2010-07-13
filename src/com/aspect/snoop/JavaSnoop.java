/*
 * Copyright, Aspect Security, Inc.
 *
 * This file is part of JavaSnoop.
 *
 * JavaSnoop is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JavaSnoop is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JavaSnoop.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aspect.snoop;

import java.util.EventObject;

import com.aspect.snoop.ui.*;

import com.aspect.snoop.util.SnoopClassLoader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.Application.ExitListener;

/**
 * The main class of the application.
 */
public class JavaSnoop extends SingleFrameApplication {

    public static final String VERSION = "version";
    public static final String SEPARATE_VM = "exec_separate_vm";
    public static final String LOAD_WAIT="load_wait";

    private static Properties props;
    private static JavaSnoopView mainForm;
    private static SnoopClassLoader loader;

    public static SnoopClassLoader getClassLoader() {
        if ( loader == null ) {
            loader = new SnoopClassLoader();
        }
        return loader;
    }

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {

        /*
         * First thing to do is check if we're in a JDK. If not, offer them the
         * option to exit, since they won't be able to really Snoop well.
         */

        ExitListener maybeExit = new ExitListener() {

            public boolean canExit(EventObject e) {
                // FIXME: Give the user the chance to save rules before exit
                //int option = JOptionPane.showConfirmDialog(null, "Really Exit?");
                //return option == JOptionPane.YES_OPTION;
                return true;
            }

            public void willExit(EventObject e) {
            }
        };
        
        addExitListener(maybeExit);

        props = new Properties();

        String propFile = System.getProperty("user.home") + File.separator + "JavaSnoop.properties";

        try {

            if (!new File(propFile).exists()) {
                initializePropertiesFile(propFile);
            }

            props.load(new FileReader(propFile));
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        mainForm = new JavaSnoopView(this);
        show(mainForm);
    }

    public static JavaSnoopView getMainForm() {
        return mainForm;
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of JavaSnoop
     */
    public static JavaSnoop getApplication() {
        return Application.getInstance(JavaSnoop.class);
    }

    public static Properties getProperties() {
        return props;
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static int getIntProperty(String key) {
        try {
            return Integer.parseInt(props.getProperty(key));
        } catch(NumberFormatException nfe) {
            return 0;
        }
    }

    public static boolean getBooleanProperty(String key) {
        return props.getProperty(key).equalsIgnoreCase("true");
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(JavaSnoop.class, args);
    }

    private void initializePropertiesFile(String propFile) throws IOException {
        getDefaultProperties().store(new FileWriter(new File(propFile)), null);
    }

    private Properties getDefaultProperties() {
        Properties p = new Properties();
        p.setProperty(VERSION, "1.0");
        p.setProperty(SEPARATE_VM, "true");
        p.setProperty(LOAD_WAIT, "3000");
        return p;
    }
}