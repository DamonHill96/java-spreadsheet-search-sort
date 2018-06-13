/*
 * Created by JFormDesigner on Tue Feb 14 20:03:26 GMT 2017
 */

package algorithms.s1501082.ac.uk;

import java.awt.*;
import javax.swing.*;

/**
 * @author Damon Hill
 */
public class DataTable extends JFrame {
    public DataTable() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Damon Hill
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {343, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 2, 3, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Damon Hill
    private JScrollPane scrollPane1;
    static JTable table1;

    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void showTable(String [][] data, String column[]){
        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.dispose();
        frame.repaint();
        frame.revalidate();
        table1 = new JTable(data, column);

        frame.add(new JScrollPane(table1));
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
