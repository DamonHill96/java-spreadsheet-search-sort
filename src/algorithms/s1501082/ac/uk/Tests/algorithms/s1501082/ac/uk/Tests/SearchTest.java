package algorithms.s1501082.ac.uk.Tests;

import algorithms.s1501082.ac.uk.LinearSearch;
import algorithms.s1501082.ac.uk.SearchingAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Damon on 13/05/2017.
 */
public class SearchTest {
    @Before
    public void setup(){
        // Loads in Excel File
        SearchingAlgorithm searchingAlgorithm = new SearchingAlgorithm();
        searchingAlgorithm.linearSearch("Details.xls", 0);
    }
    @Test
    public void testLinearSearch() throws Exception {
        String valueToTest = "Ahsan";
        LinearSearch testSearch = new LinearSearch();

        assertEquals(1, testSearch.doLinearSearch("Ahsan"));
    }


}