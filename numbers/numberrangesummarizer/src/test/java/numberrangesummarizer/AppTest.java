package numberrangesummarizer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Collection;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    } 

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
   public void checkBiggerNumbers() {
       String input = "1000,122,543666,7,8,12,13,14,15,21,22,23,24,31";
       Numbers data = new Numbers();
       Collection<Integer> fixedData = data.collect(input);
       String ranges = data.summarizeCollection(fixedData);
       System.out.println(ranges);
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
