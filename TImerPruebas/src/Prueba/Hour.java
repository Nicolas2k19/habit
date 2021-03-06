package Prueba;

public class Hour {
	private int hour;
	private int minute;
	
	
	
	Hour(int hour,int minute){
		if (hour>23||hour<0)
			throw new RuntimeException("La hora dada inexistente");
		
		if (minute>59||minute<0)
			throw new RuntimeException("minuto dado inexistente");
			
		this.hour = hour;
		this.minute= minute;}
	
//returns true if hour,minute and are equal to true 
	
	protected boolean compaHour(int hour,int minute,int second)
		
	
		{
			
			return this.hour==hour&&this.minute==minute&& second==0;}
	
//compares the object  with another object type "hour" 
	protected int compareHour(Hour compara) {
		if(this.hour==compara.getHour()) {
			if(this.minute<compara.getMinute()) 
				return -1;
			else if(this.minute==compara.getMinute())
				return 0;
			else
				return 1;
		  }
		
		else if(this.hour<compara.getHour())
			return -1;
		else
			return 1;
			   
			
		
		
		
	}
	
	
	
	
	
	protected int getHour() {
		
			return this.hour;}
	
	protected int getMinute() {
		
			return this.minute;}
	
	public String toString() {
		
		return this.hour+":"+this.minute+" ";
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hour other = (Hour) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}
	
	
}
