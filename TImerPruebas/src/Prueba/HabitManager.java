package Prueba;

import java.util.ArrayList;
import java.util.Calendar;


public class HabitManager {
	
	private DateManager calendar;

	private boolean setHabit;
	private DateManager createCard;
	private SoundControl sound;
	private int month;
	private int day;
	
	HabitManager(){
		
		this.calendar = new DateManager();
		this.setHabit = false;
		this.createCard = new AlarmManager();
		this.sound = new SoundControl("ghost.wav");
	}
	
	
	
	

	
	//get days in every month
	
	protected ArrayList<Integer> daysInMonth(){
		
		return this.calendar.daysInMonths();} 
	
	//getters that return the days in a particular month
	
	protected int daysInJan() {
		return this.calendar.daysInJan();
	}
	protected int daysInFeb() {
		return this.calendar.daysInFeb();
	}
		
	protected int daysInMarch() {
		return this.calendar.daysInMarch();
	}
	protected int daysInApr() {
		return this.calendar.daysInApr();
	}
	protected int daysInMay() {
		return this.calendar.daysInMay();
	}
	protected int daysInJun() {
		return this.calendar.daysInJun();
	}
	protected int daysInJul() {
		return this.calendar.daysInJul();
	}
	protected int daysInAgo() {
		return this.calendar.daysInAgo();
	}
	protected int daysInSep() {
		return this.calendar.daysInSep();
	}
	protected int daysInOct() {
		return this.calendar.daysInOct();
	}
	protected int daysInNov() {
		return this.calendar.daysInNov();
	}
	protected int daysInDec() {
		return this.calendar.daysInDec();}

	//sets a habit
	protected boolean setHabit(int month, int day) {
		
		AlarmManager hoy = (AlarmManager) this.createCard;
		if (hoy.givenADayTodayis(this.calendar.getYear(),month,day)) {
			 this.month = month+1;
			 this.day = day;
			 this.setHabit = true;
			 return true;}
		
		else
			return false;}
	
	protected int year() {
		
		return this.calendar.getYear();}	
	
	protected void controlHabit() {
		AlarmManager hoy = (AlarmManager) this.createCard;
		if(!hoy.givenADayTodayis(this.calendar.getYear(), this.month, this.day)) {
			this.setHabit=false;}
		
	}
	
	
	//sets an alarm
	
	protected boolean setToDo(int hour,int minute, String toDo ) {
		if(this.setHabit) {
			AlarmManager hoy = (AlarmManager) this.createCard;
			if(hoy.setToDo(hour,minute ,toDo))
				return true;
			return false;}
			
		return false;}
	
	
	//return a boolean if the actual hour is equal to an alarm
	protected boolean alarm (int cont) {
		AlarmManager hoy = (AlarmManager) this.createCard;
		
		if (hoy.alarm()&&cont==0)
			{
			this.sound.start();
			return true;}
		return false;}
	
	protected void stopAlarm() {
		this.sound.stop();}
	protected boolean eraseAlarm(int hour,int minute) {
		AlarmManager hoy = (AlarmManager) this.createCard;
		return hoy.eraseAlarm(hour, minute);
	}
	
	
	//starts the alarm sound
	protected void startAlarm() {
		this.sound.start();}
	
	// gets the actualDate
	
	protected String getactualDate() {
		return calendar.getDate();}
	
	
	//gets the actual timer and the habit time
	protected String time() {
		
		return "From: "+calendar.getYear()+"/"+calendar.getMonth()+"/"+calendar.getDay()+" to "+calendar.getYear()+"/"+this.month+"/"+this.day;}
	
	protected void turnOffAlarms() {
		AlarmManager hoy =(AlarmManager)this.createCard;
		hoy.turnOffAlarms();}
	
	//gets the alarms from alarm and Habit manager

	protected String getAlarms() {
		
		return ((AlarmManager) this.createCard).getAlarms();
	}





}
