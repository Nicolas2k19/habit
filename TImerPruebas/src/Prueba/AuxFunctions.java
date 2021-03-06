package Prueba;

import java.util.ArrayList;
import java.util.Set;

public class AuxFunctions {
	
//cast a string to a positive integer  
	protected int cast(String arg) {
		try {
			 return Integer.parseInt(arg);}
		catch(Exception e) {
			return -1;
			}}
	
		
//returns true if the string is a number
	
	protected boolean isInteger(String arg) {
			try {
				 Integer.parseInt(arg);
				 return true;}
			catch(Exception e) {
				return false;
				}
		
	}
//returns true if a char is an integer
	protected boolean isInt(char arg) {
		
			 int integer = (int) arg;
			
			 if(integer>47&&integer<58)
				 return true;
			 
			 return false;
			 
	}
		
	

//returns true if the given index is a letter and the i-1 is a number	
	protected boolean charAfterInt(int i,String data) {
		if(i>0&&data.length()!=i+1)
			{
			
			if(isInt(data.charAt(i))==false&&isInt(data.charAt(i+1))) {
				return true;}
			}
		
		
		return false;
	}
	
	 
	

//quicksort method that takes an array of objects as an argument. In the method "partition" we cast the elements of the array to hour   
	protected void quickSort(Object [] r) {
		
		qs(r,0,r.length-1);
}
	
	
	
	
	private void qs (Object[] r,int low, int high){
			if(low>=high)
				return ;
		
		
		int p  = partition(r,low,high);
		
		
		qs(r,0,p-1);
		
	    qs(r,p+1,high);
		
		
		
	}





	private int  partition(Object [] r,int low, int high) {
		Object p = (Hour)r[high];
		Hour pivot = (Hour) p;  
		int i = low -1;
		
		for(int j=low;j<high;j++) {
			Object cast = (Hour)r[j];
			Hour cast1 = (Hour)r[j];
			if (cast1.compareHour(pivot)==-1) {
				i++;
				Object x = r[j];
				r[j] = r[i];
				r[i] =x;}
			}
		
		Object x = r[high];
		r[high] = r[i+1];
		r[i+1] =x;
		
		return i+1;
	}











}
