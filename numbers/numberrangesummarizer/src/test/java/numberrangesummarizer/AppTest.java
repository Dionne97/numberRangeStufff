package numberrangesummarizer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Collection;

import org.junit.Test;

/**
 * Unit test for NumberRangeSummariser.
 */
public class AppTest 
{
   
    @Test
    public void checkData() {
        String input = "31,1,24,2,3,4";
        Numbers data = new Numbers();
        Collection<Integer> fixedData = data.collect(input);
        String ranges = data.summarizeCollection(fixedData);
        assertFalse(fixedData.contains(','));
    }
   
   @Test
   public void checkifSummarised() {
       String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
       Numbers data = new Numbers();
       Collection<Integer> fixedData = data.collect(input);
       String ranges = data.summarizeCollection(fixedData);
       assertTrue(compareLengths(input, ranges));
    }

    @Test
   public void checkifSummarised() {
       String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
       Numbers data = new Numbers();
       Collection<Integer> fixedData = data.collect(input);
       String ranges = data.summarizeCollection(fixedData);
       assertTrue(compareLengths(input, ranges));
    }

    @Test
   public void checkBiggerNumbers() {
       String input = "1000,122,543666,7,8,12,13,14,15,21,22,23,24,31";
       Numbers data = new Numbers();
       Collection<Integer> fixedData = data.collect(input);
       String ranges = data.summarizeCollection(fixedData);
       assertTrue(compareLengths(input, ranges));
    }

    @Test
    public void checkifNotSummarised() {
       String input = "1,3,5,7,9,11,13";
       Numbers data = new Numbers();
       Collection<Integer> fixedData = data.collect(input);
       String ranges = data.summarizeCollection(fixedData);

       assertFalse(compareLengths(input, ranges));
    }

    @Test
    public void checkSummarisedOutput() {
       String input = "12,1,13,14,15";
       Numbers data = new Numbers();
       Collection<Integer> fixedData = data.collect(input);
       String ranges = data.summarizeCollection(fixedData);
       System.out.println(ranges);
       String expected_output = "1,12-15";

       assertTrue(ranges.equals(expected_output));
    }

    @Test
    public void checkSummarisedOutputofBigNumbers() {
       String input = "1200,11234,13001,13002,13003, 10000000";
       Numbers data = new Numbers();
       Collection<Integer> fixedData = data.collect(input);
       String ranges = data.summarizeCollection(fixedData);
       String expected_output = "1200,11234,13001-13003,10000000";
       assertTrue(ranges.equals(expected_output));
    }

    public static boolean compareLengths(String in , String out) {
        boolean result = false;

        if (out.length() < in.length()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
