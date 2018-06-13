package algorithms.s1501082.ac.uk.Tests;

import algorithms.s1501082.ac.uk.ExcelHandler;
import algorithms.s1501082.ac.uk.InsertionSort;
import algorithms.s1501082.ac.uk.SearchingAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Damon on 14/05/2017.
 */
public class InsertionSortTest {

    InsertionSort sort = new InsertionSort();

    @Test
    public void sortNumerical() throws Exception {
        int[] valuesToTest = {7,2,5,1,8};


       assertEquals(true ,sort.sortNumerical(valuesToTest));
    }

    @Test
    public void sortCharacters() throws Exception {
        String[] stringsToTest = {"Ahsan", "Aaron", "Captain Mog", "Zain", "Egads","Potter-kun"};


        assertEquals(true ,sort.sortCharacters(stringsToTest));
    }

}