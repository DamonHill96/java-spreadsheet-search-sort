package algorithms.s1501082.ac.uk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Created by Damon on 05/04/2017.
 */
public class SortMenu extends JFrame {
    String listValues[];
    public SortMenu(){
        initComponents();

        //fill combobox with header names
        ExcelHandler excel = new ExcelHandler();
        excel.setFilePath(Gui.newPath);
        excel.readExcel();

        comboBox1.removeAllItems();
        System.out.println(ExcelHandler.noOfColumns);
        for(int i = 0; i < ExcelHandler.noOfColumns; i++){
            comboBox1.addItem(ExcelHandler.columnNames[i]);
        }
    }

    private void populateList(){
        System.out.println(comboBox1.getSelectedIndex());
        DefaultListModel<String> model = new DefaultListModel<>();
        listValues = new String[ExcelHandler.noOfRows];
        int count = 0;
        for (int j = 0; j < ExcelHandler.noOfRows; j++){
            listValues[j] = ExcelHandler.data[j][comboBox1.getSelectedIndex()];
            model.add(count, listValues[j]);
            count++;
            list1.setModel(model);
        }
    }

    private void okButtonActionPerformed(ActionEvent e) {
       InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(listValues);
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        populateList();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        SelectExcel excel = new SelectExcel();
        this.setVisible(false);
        excel.redrawGui();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Damon Hill
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {46, 302, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("Sort By:");
                contentPanel.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- comboBox1 ----
                comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
                contentPanel.add(comboBox1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label2 ----
                label2.setText("The Sheet will be sorted by the following Values");
                contentPanel.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(list1);
                }
                contentPanel.add(scrollPane1, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Damon Hill
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JList list1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
