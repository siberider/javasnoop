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

package com.aspect.snoop.ui.tamper;

import com.aspect.snoop.util.IOUtil;
import com.aspect.snoop.util.ReflectionUtil;
import com.aspect.snoop.util.UIUtil;
import com.thoughtworks.xstream.XStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.apache.log4j.Logger;
import org.jdesktop.application.Action;

public class EditObjectView extends javax.swing.JDialog {

    private static Logger logger = Logger.getLogger(EditObjectView.class);

    private Object toEdit;

    private List<Field> primitiveFields;
    private List<Field> objectFields;

    /** Creates new form EditObjectView */
    public EditObjectView(java.awt.Frame parent, boolean modal, Object toEdit) {

        super(parent, modal);
        initComponents();

        this.toEdit = toEdit;

        initialize();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNonPrimitives = new javax.swing.JTable();
        lblClassName = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPrimitives = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnSerialize = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.aspect.snoop.JavaSnoop.class).getContext().getResourceMap(EditObjectView.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tblNonPrimitives.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 2"
            }
        ));
        tblNonPrimitives.setName("tblNonPrimitives"); // NOI18N
        jScrollPane2.setViewportView(tblNonPrimitives);
        tblNonPrimitives.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblNonPrimitives.columnModel.title1")); // NOI18N

        lblClassName.setText(resourceMap.getString("lblClassName.text")); // NOI18N
        lblClassName.setName("lblClassName"); // NOI18N

        btnSave.setText(resourceMap.getString("btnSave.text")); // NOI18N
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        tblPrimitives.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 2"
            }
        ));
        tblPrimitives.setName("tblPrimitives"); // NOI18N
        jScrollPane3.setViewportView(tblPrimitives);
        tblPrimitives.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblNonPrimitives.columnModel.title1")); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.aspect.snoop.JavaSnoop.class).getContext().getActionMap(EditObjectView.class, this);
        btnSerialize.setAction(actionMap.get("serialize")); // NOI18N
        btnSerialize.setText(resourceMap.getString("btnSerialize.text")); // NOI18N
        btnSerialize.setName("btnSerialize"); // NOI18N

        btnSave1.setText(resourceMap.getString("btnSave1.text")); // NOI18N
        btnSave1.setName("btnSave1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblClassName))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSerialize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblClassName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnSerialize)
                    .addComponent(btnSave1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed
   
    @Action
    public void deserialize() {

        JFileChooser fc = null;

        if ( currentOutputFile.length() > 0 && new File(currentOutputFile).exists() ) {
            fc = new JFileChooser(new File(currentOutputFile).getParentFile());
        } else {
            fc = new JFileChooser();
        }

        fc.setApproveButtonText("Load");
        
        fc.setFileFilter(new FileFilter() {

            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".ser");
            }

            public String getDescription() {
                return "Serialized object file (.ser)";
            }

        });
        
        int rc = fc.showOpenDialog(this);

        if (rc == JFileChooser.APPROVE_OPTION) {
            File input = fc.getSelectedFile();
            try {

                byte[] xml = IOUtil.getBytesFromFile(input);
                toEdit = serializer.fromXML(new String(xml));
                replaceObject = true;
                initialize();

            } catch (IOException ioe) {
                UIUtil.showErrorMessage(this, "Error deserializing object: " + ioe.getMessage());
                logger.error("Error deserializing object: " + ioe.getMessage(),ioe);
            }
        }
    }

    private String currentOutputFile = "";
    private XStream serializer = new XStream();

    boolean replaceObject = false;

    public boolean shouldReplaceObject() {
        return replaceObject;
    }

    @Action
    public void serialize() {
        JFileChooser fc = null;

        if ( currentOutputFile.length() > 0 && new File(currentOutputFile).exists() ) {
            fc = new JFileChooser(new File(currentOutputFile).getParentFile());
        } else {
            fc = new JFileChooser();
        }

        fc.setApproveButtonText("Save");
        fc.setFileFilter(new FileFilter() {

            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".ser");
            }

            public String getDescription() {
                return "Serialized object file (.ser)";
            }

        });

        int rc = fc.showOpenDialog(this);

        if (rc == JFileChooser.APPROVE_OPTION) {
            File of = fc.getSelectedFile();
            try {
                
                FileOutputStream fos = new FileOutputStream(of.getAbsolutePath());

                currentOutputFile = of.getAbsolutePath();
                serializer.toXML(toEdit, fos);

                fos.close();

            } catch (IOException ioe) {
                UIUtil.showErrorMessage(this, "Error serializing object: " + ioe.getMessage());
                logger.error("Error serializing object: " + ioe.getMessage(),ioe);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSerialize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblClassName;
    private javax.swing.JTable tblNonPrimitives;
    private javax.swing.JTable tblPrimitives;
    // End of variables declaration//GEN-END:variables

    private void initialize() {
        
        lblClassName.setText(this.toEdit.getClass().getName());

        primitiveFields = ReflectionUtil.getAllPrimitiveFields(toEdit);
        objectFields = ReflectionUtil.getAllNonPrimitiveFields(toEdit);

        tblNonPrimitives.setModel( new ObjectTableModel(toEdit, objectFields));
        tblPrimitives.setModel( new PrimitiveTableModel(toEdit, primitiveFields));

        ParameterTableCellRenderer renderer = new ParameterTableCellRenderer();
        tblNonPrimitives.setDefaultEditor(JButton.class, renderer);
        tblNonPrimitives.setDefaultRenderer(JButton.class, renderer);

        tblPrimitives.setRowHeight(25);
        tblNonPrimitives.setRowHeight(25);
    }

    public Object getObjectReplacement() {
        return toEdit;
    }

}
