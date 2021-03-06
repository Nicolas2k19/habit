package Prueba;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;



public class AlarmManager extends DateManager {
	private  String date;
	private  HashMap <Hour,String> toDo;
	private  String doo;
	private  AuxFunctions funcAux;
	 
	
	AlarmManager(){
		
		this.date = getDate();
		this.toDo = new HashMap<Hour,String>();
		this.funcAux = new AuxFunctions();
		}
	
	
	
//	protected String fechaCarta() {
		
		
//		return this.date;}
	

//returns true if an alarms is equal to the actual hour and minute
	protected boolean  alarm() {
		Set <Hour> hours = hoursInUse();
		hours.toArray();
		DateManager cal = new DateManager();
		
		Iterator it =  hours.iterator();
		
		
		while(it.hasNext()) {
			
			Hour alarm =(Hour)it.next();
			if(alarm.compaHour(cal.getHour(), cal.getMinu(),this.getSecond()))
					{	this.doo = this.toDo.get(alarm);
						return true;}
									}
		 
		
		return false;}
	



	//sets an alarm. Returns false if the enter string has a number or an exception in hour appears, else the method returns true

	protected  boolean setToDo(int hour,int minute,String toDo) {
			try
			{
			int i=0;
			while(i<toDo.length()) {
				 int parse = (int) toDo.charAt(i);
				 if(parse==48||parse==49||parse==50||parse==51||parse==52||parse==53||parse==54||parse==55||parse==56||parse==57)
					 return false;
				 i++;}
			
			Hour newHora = new Hour(hour,minute);
			this.toDo.put(newHora, toDo);
			return true;}
			
			catch(Exception e) {
				return false;
			}
	}


	
	//returns all the keys from the hashmap ToDo
	protected Set<Hour> hoursInUse() {
			return  this.toDo.keySet();
		}
	
	//gets all the alarms in a String format
	protected String getAlarms() {
			Set <Hour> hours = hoursInUse();
			Object [] toOrder = hours.toArray();
			this.funcAux.quickSort(toOrder);
		
			String strRet = "";
		
			for(int i =0;i<toOrder.length;i++) {
				Hour cast = (Hour) toOrder[i];
				strRet += toOrder[i].toString()+this.toDo.get(toOrder[i])+"\n";}
		
		
		
			return strRet;}
	

//erases all the alarms
	protected void turnOffAlarms() {
		this.toDo = new HashMap<Hour,String>();}

//erases one alarm
	protected boolean eraseAlarm(int hour,int minute) {
		try {Hour objH = new Hour(hour,minute);
		
		if(this.toDo.containsKey(objH)){
			this.toDo.remove(objH);
			return true;}
		else
			return false;}
		catch(Exception e) {
			return false;}
		
	}
	
	
//compares the actual date with a given date 	
	protected boolean givenADayTodayis(int year,int month,int day) {
		
		  if(day<1||month<1||year<1)
				return false;
		
		switch (month) {
		 
		case 0:
			if(day>daysInJan())
				return false;
			break;
		case 1:
			if(day>daysInFeb())
				return false;
			break;
		case 2:
			if(day>daysInMarch())
				return false;
			break;
			
		case 3:
			if(day>daysInApr())
				return false;
			break;
			
		case 4:
			if(day>daysInMay())
				return false;
			break;
			
		case 5:
			if (day>daysInJun())
				return false;
			break;
		
		case 6:
			if(day>daysInJul())
				return false;
			break;
			
		case 7:
			if(day>daysInAgo())
				return false;
			break;
			
		case 8:
			if(day>daysInSep())
				return false;
			break;
		case 9:
			if(day>daysInOct())
				return false;
			break;
			
		case 10:
			if(day>daysInNov())
				return false;
			break;
			
		case 11:
			if(day>daysInDec())
				return false;
			break;
			
		}
		
	
		
		
		Calendar cal = getCalendar();
		
		if(cal.get(Calendar.YEAR)<=year)
			{
			if(cal.get(Calendar.MONTH)<month)
				 return true;
			else if(cal.get(Calendar.MONTH)==month) {
				
				if(cal.getTime().getDate()<=day)
					return true;
				else
					return false;
			}
			else
				return false;
			
			
			}
		else
			return false;

	
	}
		
	
	
//retorno un string 
	protected String getDoo() {
		
		return this.doo;}
	
	

}











