package algorithms.s1501082.ac.uk;

import jxl.Cell;
import jxl.write.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Bidi;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Damon on 13/02/2017.
 */
public class ExcelHandler extends JFrame {
    String filePath;
    Workbook excel;
    Sheet sheet;
   static String[][] data;
    public static String columnNames[];
    static int noOfRows;
    static int noOfColumns;
    static String sheetNumber;
    int columns;
    static int test;

    public void getNoOfSheet() {
        try {
            SelectExcel populateSheetBox = new SelectExcel();
            filePath = getFilePath();
            System.out.println(filePath);
            excel = Workbook.getWorkbook(new File(filePath)); // Get excel file
            test = excel.getNumberOfSheets();
            System.out.println("Number of sheets" + test);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "The file could not be found.");
        } catch (BiffException ex) {

        }
    }


    public void readExcel(){
        try {

            Gui gui = new Gui();
            SelectExcel populateSheetBox = new SelectExcel();
            filePath = getFilePath();

            excel = Workbook.getWorkbook(new File(filePath)); // Get excel file

            sheet = excel.getSheet(test); // Get sheet
            System.out.println("Columns " + sheet.getColumns());
            System.out.println("Rows " + sheet.getRows());

            noOfColumns = sheet.getColumns();
            noOfRows = sheet.getRows();


            data = new String [sheet.getRows()][sheet.getColumns()]; // MD array holds cell values
            columnNames = new String[noOfColumns]; // seperate column headers from data

            for (int x = 0; x < noOfColumns; x++){
                columnNames[x] = sheet.getCell(x,0).getContents(); // Gets header names

            }

            for (int i = 1; i < noOfRows ; i++){
                for (int j = 0; j < noOfColumns; j++){


                    data[i - 1][j] = sheet.getCell(j, i).getContents(); // populate array with data from sheet

                }

            }


        } catch(IOException e){
            e.printStackTrace();

        } catch (BiffException ex){

        }

        excel.close();

    }


// TODO Look at making these static, might remove stupid workaround- not urgent
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public String getFilePath(){
        return filePath;
    }



}
