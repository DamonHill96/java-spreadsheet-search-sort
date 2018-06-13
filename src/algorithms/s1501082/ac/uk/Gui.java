/*
 * Created by JFormDesigner on Fri Feb 10 16:57:23 GMT 2017
 */

package algorithms.s1501082.ac.uk;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Damon Hill
 */
public class Gui extends JFrame implements ActionListener {
    private SearchingAlgorithm search = new SearchingAlgorithm();
    private ExcelHandler excel = new ExcelHandler();
//   private SelectExcel select = new SelectExcel();

   static String newPath;
    public Gui() {

        initComponents();
    }


    public void actionPerformed(ActionEvent e) {

    }

    public void button1ActionPerformed(ActionEvent e) { //Search
try {

    search.setText(textField1.getText());


    search.linearSearch(newPath, 0); // 0 - called to do linear
    } catch (NullPointerException e1){
        JOptionPane.showMessageDialog(this, "No excel file specified! Please select a file.");
        button2ActionPerformed(e);

    }

    }

   public void button2ActionPerformed(ActionEvent e) { // Select File
        SelectExcel selectFile = new SelectExcel();
        selectFile.setPreferredSize(new Dimension(400,400));
        selectFile.setSize(400,400);
        selectFile.pack();
        this.setVisible(false);
        selectFile.setVisible(true);
    }

    public void button3ActionPerformed(ActionEvent e) {//check file path

      JOptionPane.showMessageDialog(this, excel.getFilePath());


    }

    private void readDataButtonActionPerformed(ActionEvent e) {
        DataTable table = new DataTable();

        search.linearSearch(newPath, 1); // Workaround, cuts out unneeded bits
        table.showTable(ExcelHandler.data, ExcelHandler.columnNames);


    }

    private void sortDataActionPerformed(ActionEvent e) {
        try {
            SortMenu sortMenu = new SortMenu();
            sortMenu.setPreferredSize(new Dimension(400, 400));
            sortMenu.setSize(400, 400);
            sortMenu.pack();
            this.setVisible(false);
            sortMenu.setVisible(true);
        } catch (NullPointerException e1){
            JOptionPane.showMessageDialog(this, "No excel file specified! Please select a file.");
            button2ActionPerformed(e);
        }
    }


    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Damon Hill
        textField1 = new JTextField();
        button1 = new JButton();
        sortData = new JButton();
        readDataButton = new JButton();
        button3 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {170, 106, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        contentPane.add(textField1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button1 ----
        button1.setText("Search!");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- sortData ----
        sortData.setText("Sort Data");
        sortData.addActionListener(e -> sortDataActionPerformed(e));
        contentPane.add(sortData, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- readDataButton ----
        readDataButton.setText("Read Data");
        readDataButton.addActionListener(e -> readDataButtonActionPerformed(e));
        contentPane.add(readDataButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button3 ----
        button3.setText("Check File Path");
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button2 ----
        button2.setText("View Excel Files");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents



        excel.setFilePath(newPath); //Default

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Damon Hill
    private JTextField textField1;
    private JButton button1;
    private JButton sortData;
    private JButton readDataButton;
    private JButton button3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
