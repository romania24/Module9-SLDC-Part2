package com.text.analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class TextAnalyzer is the word occurance application. 
 * Reads from a file and calculates how many times does a word occur in the file. 
 * @author Romania Brown
 *
 */
public class TextAnalyzer
{
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Adding a scanner to read from poem.txt line by line.
         */
        File file = new File("C:\\Users\\romaniabrown\\Documents\\poem.txt");
        Scanner scan = new Scanner(file);
        /**
         * map to store key value pair
         * key : word
         * value: frequency of the word
         */
        Map<String,Integer> map = new HashMap<String, Integer>(); 
        while (scan.hasNext())
        {
            String val = scan.next(); // reading line by line

  
	                val = val.replaceAll("<.*?>", "");
	                val = val.replaceAll("<.*", "");
	                val= val.replaceAll(".+>", "");
	                val = val.replaceAll("style=.*", "");
	                val = val.replaceAll("—", "");
	                val = val.replaceAll("\\P{L}", "").toLowerCase(); 
	                if (val=="")
	                	continue ;

            if(map.containsKey(val) == false) // if the string is not inserted in the map yet then insert by setting the frequency as 1
                map.put(val,1);
            else // otherwise remove the entry from map and again insert by adding 1 in the frequency
            {
                int count = (int)(map.get(val)); // finding the current frequency of the word
                map.remove(val);  // removing the entry from the map
                map.put(val,count+1); // reinserting the word and increase frequncy by 1
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet(); // retrieving the map contents
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); // make an array list 
        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() // sorting the array list
        {
            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) // comparator function for sorting
            {
                return (b.getValue()).compareTo( a.getValue() ); // for descending order 
//                return (a.getValue()).compareTo( b.getValue() ); // for ascending order 
            }
        } );
        // printing the list
        for(Map.Entry<String, Integer> i:sortedList){
            System.out.println(i.getKey()+" -> "+i.getValue());
        }
    }
}