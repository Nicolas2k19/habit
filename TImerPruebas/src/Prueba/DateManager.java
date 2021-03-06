package Prueba;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateManager {

	private Calendar cal1;
	
	
	DateManager(){
		
		this.cal1 =GregorianCalendar.getInstance();
		this.cal1.setLenient(true);
	}
	
	//returns true if the year is leap
	protected boolean leapYear() {
		this.cal1=GregorianCalendar.getInstance();
		GregorianCalendar gre = (GregorianCalendar)GregorianCalendar.getInstance();
		return gre.isLeapYear(cal1.getTime().getYear());
		
	
	}
	
//returns the number of days that every month has	
	protected ArrayList<Integer> daysInMonths(){
		ArrayList<Integer> days = new ArrayList<Integer>();
		
		days.add(31);       //jan
		if(leapYear())      
			days.add(29);   //feb
		else
			days.add(28);	
		days.add(31);		//march
		days.add(30);		//apr
		days.add(31);		//may
		days.add(30);		//jun
		days.add(31);		//jul
		days.add(31);		//ago
		days.add(30);		//sep
		days.add(31);		//oct
		days.add(30);		//nov
		days.add(31);		//dec
		
		return days;}
	
//returns the days of every month	
	protected int daysInJan() {
		
		return 31;
	}
	
	protected int daysInFeb() {
		if(leapYear())
			return 29;
		
		return 28;}
	
	
	protected int daysInMarch() {
	
		return 31;}
	
	protected int daysInApr() {
	
		return 30;
}
	protected int daysInMay() {
	
		return 31;
}
	protected int daysInJun() {
	
		return 30;
}
	protected int daysInJul() {
	
		return 31;
}
	protected int daysInAgo() {
	
		return 31;
}
	protected int daysInSep() {
	
		return 30;
}
	
	protected int daysInOct() {
	
		return 31;
}
	
	protected int daysInNov() {
		
		return 30;
}
	
	
	protected int daysInDec() {
	
		return 31;
}
	
	
	protected int getYear() {
		this.cal1 =GregorianCalendar.getInstance();
		return this.cal1.get(Calendar.YEAR);}
	
	
//return the date in a string 	
	protected String getDate() {
		this.cal1 =GregorianCalendar.getInstance();
		return  this.cal1.getTime().toLocaleString();}
	
	
//returns a gregorian calendar
	protected  Calendar getCalendar() {
		this.cal1 = GregorianCalendar.getInstance();
		return this.cal1;}
//returns the actual month
	protected int getMonth() {
		this.cal1 = GregorianCalendar.getInstance();
		
		return this.cal1.get(Calendar.MONTH)+1;
	}
//returns the actual day
	protected int getDay() {
		this.cal1 = GregorianCalendar.getInstance();
		return this.cal1.getTime().getDate();
	}
	
//returns the actual hour 
	protected int getHour() {
		this.cal1 = GregorianCalendar.getInstance();
		return this.cal1.getTime().getHours();
	}
//return the actual minute	
	protected int getMinu() {
		this.cal1 = GregorianCalendar.getInstance();
		return this.cal1.getTime().getMinutes();}
//return the actual second	
	protected int getSecond() {
	this.cal1 = GregorianCalendar.getInstance();
	return this.cal1.getTime().getSeconds();}
	
	
	
	
	

		
		
	
	

	
	
	
	
	
	
	
	

}
