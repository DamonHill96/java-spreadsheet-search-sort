/*
 * Created by JFormDesigner on Mon Feb 13 14:46:23 GMT 2017
 */

package algorithms.s1501082.ac.uk;



import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Damon Hill
 */
public class SelectExcel extends JFrame implements ActionListener {
    Gui gui = new Gui();
    Main main = new Main();
     ExcelHandler excel = new ExcelHandler();

    String selectedPath;
    String directory;
    public SelectExcel() {


        initComponents();
        this.setTitle("Select File");

        directory = System.getProperty("user.dir");
        currentDirectoryLabel.setText("Current Directory: " + directory);
        comboBox1.setEditable(true);
        comboBox1.setSelectedItem("Select Sheet");
        viewFiles();


    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        redrawGui();
    }


    public void list1ValueChanged(ListSelectionEvent e){

            ExcelHandler excel = new ExcelHandler();
            comboBox1.setEditable(false); // Removes preset message
            selectedPath = list1.getSelectedValue(); //gets clicked value
            gui.newPath = selectedPath;
            label1.setText("Currently Selected File: " + selectedPath);
            excel.filePath = selectedPath;
            excel.getNoOfSheet();
            comboBox1.removeAllItems();

            //populates the sheet selection list
            for (int i = 0; i < ExcelHandler.test; i++) {

                comboBox1.addItem(excel.excel.getSheetNames()[i]);
            }




    }



    private void refreshButton1ActionPerformed(ActionEvent e) {
         viewFiles();
    }

    public void okButtonActionPerformed(ActionEvent e) {


        this.setVisible(false);
     //   gui.newPath = selectedPath;

        ExcelHandler.test = comboBox1.getSelectedIndex(); // Get selected sheet
       redrawGui();
    }

    private void helpButtonActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "This program only supports the .xls file extension. If your files are .xlsx, open it in Excel and save it as an Excel 97-2003 file.");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Damon Hill
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        currentDirectoryLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        buttonBar = new JPanel();
        helpButton = new JButton();
        refreshButton1 = new JButton();
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
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {358, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 173, 25, 20, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- currentDirectoryLabel ----
                currentDirectoryLabel.setText("text");
                contentPanel.add(currentDirectoryLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- list1 ----
                    list1.setModel(new AbstractListModel<String>() {
                        String[] values = {
                            "No files found"
                        };
                        @Override
                        public int getSize() { return values.length; }
                        @Override
                        public String getElementAt(int i) { return values[i]; }
                    });
                    list1.addListSelectionListener(e -> list1ValueChanged(e));
                    scrollPane1.setViewportView(list1);
                }
                contentPanel.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label1 ----
                label1.setText("Currently Selected File: ");
                contentPanel.add(label1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(comboBox1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {85, 85, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};

                //---- helpButton ----
                helpButton.setText("No files?");
                helpButton.addActionListener(e -> helpButtonActionPerformed(e));
                buttonBar.add(helpButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- refreshButton1 ----
                refreshButton1.setText("Refresh");
                refreshButton1.setPreferredSize(new Dimension(95, 32));
                refreshButton1.setMinimumSize(new Dimension(0, 0));
                refreshButton1.addActionListener(e -> refreshButton1ActionPerformed(e));
                buttonBar.add(refreshButton1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
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
    private JLabel currentDirectoryLabel;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JLabel label1;
    private JComboBox comboBox1;
    private JPanel buttonBar;
    private JButton helpButton;
    private JButton refreshButton1;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
@Override
    public void actionPerformed(ActionEvent e) {

    }

    public void viewFiles(){
        try {
            final String extension = "xls";
            int count = 0;
            int noOfFiles = 0;
            File[] dir = new File(".").listFiles(); // Current Directory
            DefaultListModel<String> model = new DefaultListModel<>();
// Searches for .xls file
            for (File i : dir) {

                if (i.getName().toLowerCase().endsWith(extension)) {

                    String xlsFile = i.toString();
                    xlsFile = xlsFile.substring(2); // Trims ./ off the front
                    // System.out.println(xlsFile);


                    model.add(count, xlsFile); // Add to next free space on the list
                    count++;
                    noOfFiles ++; // if 0 inform user
                    list1.setModel(model);

                }

                }
            if (noOfFiles == 0){
                JOptionPane.showMessageDialog(this,"No files found!");

            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error. Please try again.");
        }
    }
    void redrawGui(){
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setPreferredSize(new Dimension(400,400));
        gui.setSize(400,400);
        gui.pack();
        gui.setVisible(true);
    }
}
