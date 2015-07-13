package com.ieeeportal.util;

import java.util.ArrayList;
import java.util.List;

public class Comman 
{
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	    
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

	
 
}
