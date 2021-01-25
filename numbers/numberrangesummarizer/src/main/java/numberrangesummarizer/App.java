package numberrangesummarizer;

import java.util.Collection;
import java.util.Iterator;

/**
* This NumberRangeSummarizer program implements an application that
* simply produces a comma delimited list of numbers, grouping the 
* numbers into a range when they are sequential.
* Assumption: Numbers may not always be sorted
*
* @author  Dionne Chasi
* @since   2020-01-22 
*/

public class App {
    public static void main( String[] args ) {

        String input = "31,1,24,2,3,4";
        Numbers data = new Numbers();
        data.collect(input);

    }


}
