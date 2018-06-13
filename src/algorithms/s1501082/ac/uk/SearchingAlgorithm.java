package algorithms.s1501082.ac.uk;

import javax.swing.*;

/**
 * Created by Damon on 10/02/2017.
 */



public class SearchingAlgorithm extends JFrame{
    public String test;
    String textPassthrough ;

    public void setText(String test){
        this.test = test;

    }

    public String getText(){
        return test;
    }

    public void linearSearch(String path, int calledFrom){
        ExcelHandler excel = new ExcelHandler();
        LinearSearch binary = new LinearSearch();


        excel.setFilePath(path);
        excel.readExcel();
        if (calledFrom == 0){ // can do search
            textPassthrough = getText();
            binary.doLinearSearch(textPassthrough);

        }


    }

}
