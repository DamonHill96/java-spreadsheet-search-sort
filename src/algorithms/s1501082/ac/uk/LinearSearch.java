package algorithms.s1501082.ac.uk;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.xml.crypto.Data;
//Third party Excel library

/**
 * Created by Damon on 10/02/2017.
 */ 

public class LinearSearch extends SearchingAlgorithm  {

    public int doLinearSearch(String text) {
        Boolean found = false;
        int rowFound = 0;
        String[][] searchResult = new String[1][ExcelHandler.noOfColumns];
     
loop:
try{
       for(int i = 0; i < ExcelHandler.noOfRows; i++){
           for (int j = 0;j < ExcelHandler.noOfColumns; j++) {
// Searches the spreadsheet
               if (ExcelHandler.data[i][j].equals(text)) {
                   found = true;
                   rowFound = i;
                   break loop;
               } else {
                   found = false;
               }
           }
           }
       } catch (NullPointerException n){
            found = false;
            break loop;
       }
       if (found == true) {
           System.out.println("Found!" + text);

           // Displays all Records on that row
           for(int x = 0; x < ExcelHandler.noOfColumns; x++){
             searchResult[0][x] = ExcelHandler.data[rowFound][x];
           }

           DataTable table = new DataTable();
           table.showTable(searchResult, ExcelHandler.columnNames);
           return 1;
       } else {
          JOptionPane.showMessageDialog(this, "We couldn't find the record in the file");
           return -1;
       }
    }

}
