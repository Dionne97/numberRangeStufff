package numberrangesummarizer;

import java.util.Collection;
import java.util.Iterator;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Numbers implements NumberRangeSummarizer {

    public Collection<Integer> collect(String input) {
        Collection<Integer> data =  new HashSet<Integer>();
        char [] numChars = input.toCharArray();
        int val = 0;
        
        for (int i = 0; i < numChars.length;) {
            if (Character.isDigit(numChars[i])) {
                if (numChars.length != i+1 && numChars[i+1] != ',' ) {
                    StringBuilder str = new StringBuilder();
                    str.append(numChars[i++]);
                    while (i < numChars.length && Character.isDigit(numChars[i])) {

                        str.append(numChars[i++]);
                        //String num = Character.toString(numChars[i]) + Character.toString(numChars[i+1]);
                    }
                    
                    val = Integer.parseInt(str.toString());
                    data.add(val);


                } else {
                    val = Character.getNumericValue(numChars[i]);
                    data.add(val);
                }    
            }
            
            i++;
        }
        System.out.println(data);
        return data;
    }

    public String summarizeCollection(Collection<Integer> input) {
        Collection<Integer> numSet =  new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>(input);
        Collections.sort(list);
        String ranges = "";
        for (Integer num : list) {
            System.out.println(num);
            int temp = num + 1;
            if (input.contains(temp)) {
                numSet.add(num);
                numSet.add(temp);
            } else {
                if (numSet.size()>0) {
                    int max = Collections.max(numSet);
                    int min = Collections.min(numSet);
                    String tempStr = Integer.toString(min) + "-" + Integer.toString(max) + ",";
                    ranges = ranges + tempStr;
                    numSet = new HashSet<Integer>(); 
                } else {
                    String tempStr2 = Integer.toString(num) + ", ";
                    ranges = ranges + tempStr2;
                }
            }
        }
        return ranges;
    } 

}