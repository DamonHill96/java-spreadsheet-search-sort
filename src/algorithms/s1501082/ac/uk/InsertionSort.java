package algorithms.s1501082.ac.uk;

import javax.swing.*;
import java.awt.*;
import java.beans.ExceptionListener;
import java.text.Collator;
import java.util.*;
import java.util.List;

/**
 * Created by Damon on 05/04/2017.
 */
public class InsertionSort extends JFrame {

    public void sort(String values[]) {

        if (values[0].matches("\\d+")) { //If it's actually an int
            int [] val = new int [values.length - 1];
            //convert to integer
            for (int i = 0; i < values.length - 1; i++) {
                val[i] = Integer.parseInt(values[i]);
            }
            sortNumerical(val);
        }
        else {
            sortCharacters(values);
        }
    }

    public boolean sortNumerical(int values[]) { //Insertion, n^2
        String[][] result = new String[ExcelHandler.noOfRows][ExcelHandler.noOfColumns];
        String[][] tempArray = new String[ExcelHandler.noOfRows][ExcelHandler.noOfRows];
        boolean isSorted = true;
        try {
            for (int i = 1; i < values.length; i++) {
                int j = i;

                while (j > 0 && values[j - 1] > (values[j])) {
                    //swap v[j] with v[j-1]
                    int temp;
                    String temp2;
// Swaps values
                    temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
// Swaps corresponding values on row
                    for (int m = 1; m < ExcelHandler.noOfColumns; m++) {
                        temp2 = ExcelHandler.data[j][m];
                        ExcelHandler.data[j][m] = ExcelHandler.data[j-1][m];
                        ExcelHandler.data[j-1][m] = temp2;

                    }
                    j--;

                }

            }
            // Final result
            for (int k = 0; k < values.length; k++) {
                System.out.println(values[k]);

            }
// Pushes to table
            for (int k = 0; k < values.length; k++) {
                String[] newValues = new String[values.length];
                int convert;

                convert = values[k];
                newValues[k] = Integer.toString(convert);

                System.out.println(values[k]);
                ExcelHandler.data[k][0] = newValues[k];

            }
            DataTable table = new DataTable();
            table.showTable(ExcelHandler.data, ExcelHandler.columnNames);


            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] > values[i + 1]) {
                    isSorted = false;
                    break;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "An empty field was encountered.");
        } return isSorted;
    }
        // check for JUnit



    public boolean sortCharacters(String values[]) {

//Treeset implementation
        Collection<String> treeset = new TreeSet<String>(Collator.getInstance());

        for (int i = 0; i < values.length - 1; i++) {
        treeset.add(values[i]); //Auto sort, Log(n)
        }

        Iterator<String> iterator = treeset.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }
        return true;
    }
}
