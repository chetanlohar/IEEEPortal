package com.ieeeportal.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenUtil {
   
		List<Integer> ints = new ArrayList<Integer>();
	    int i = 0;

	   public RandomGenUtil() {
	        for (int i = 0; i < 10000; i++) {
	            ints.add(i);
	        }
	        Collections.shuffle(ints);
	    }

	    public int nextInt() {
	        return ints.get(i++);
	    }
	
}
