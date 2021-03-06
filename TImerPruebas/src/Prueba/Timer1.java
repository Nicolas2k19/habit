package Prueba;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class Timer1 extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	JTextField fieldHour,fieldMinute,fieldToDo,fieldDayOfMonth;
    private ButtonGroup buttonGroup;
	private JOptionPane errorHan;
	private JButton button, buttonHabit,buttonStopAlarm,eraseBu;
	private JCheckBox jan,feb,march,apr,may,jun,jul,ago,sep,oct,nov,dec; 
	private JPanel panel ,panel1,panel2;
	private AuxFunctions auxFun;
	private HabitManager centro;
	private JTabbedPane pestañas;
	private JTextArea textAlarm,textHabit;
	private boolean stopAlarm;
	private int cont;
	private ArchiveManager ar;
	Timer1(){
		
		super();
		this.ar = new ArchiveManager(); //manages the txt files that store the habit ant the alarms
		this.centro = new HabitManager();  // manages the logic 
		this.auxFun = new AuxFunctions();  //aux Functions 
		
		configWin(); //creates the main window
		
		startComp(); //STARTS ALL THE COMPONENTS IN THE MAIN WINDOW
		
		
		this.stopAlarm=false;
		
		this.cont =0;
	}
	

//compares the actual time with the alarms that are register
	protected boolean alarm(int cont) {
		if (!stopAlarm)
			return this.centro.alarm(cont);
		
			return false;}
	
	
	protected void sumCont() {
		this.cont++;}
	
//set the counter equal to zero	
	protected void setContZero() {
		this.cont=0;}
	
	//sets stopAlarm equal to false
	protected void setStopAlarmFal() {
		this.stopAlarm=false;}

//getter of the boolean stopAlarm
	protected boolean getStop() {
		return this.stopAlarm;
	}
	
	
// getter of the counter for the alarm
	protected int getCont() {
		
		return this.cont;}
	
	
//stops alarms 
	
	protected boolean stopAlarm ()  {
		this.centro.stopAlarm();
		return true;}
	
	
//erases the alarm that the user puts
	

protected boolean  eraseAlarm(int hour,int minute) {
		 
		
		 
		 if(this.centro.eraseAlarm(hour, minute))
		 {	String alarms = this.centro.getAlarms();
		 	this.ar.deleteAlarms();
		 	this.ar.writeAllAlarms(alarms);
		 	this.textAlarm.setText(alarms);
		 	return true;}
		 
		 return false;
		 
		
		 
	}
	
	
	
	
	
	
	private void startComp() {
		
		
		    errorHan =new JOptionPane();
		
			panel = new JPanel();
			
			fieldDayOfMonth= new JTextField("Day");
			
			buttonHabit = new JButton();
			
			buttonGroup = new ButtonGroup();
			
			//checkbox
			
			jan = new JCheckBox("jan");
			feb = new JCheckBox("feb");
			march = new JCheckBox("march");
			apr = new JCheckBox("apr");
			may = new JCheckBox("may");
			jun = new JCheckBox("jun");
			jul = new JCheckBox("jul");
			ago = new JCheckBox("ago");
			sep = new JCheckBox("sep");
			oct = new JCheckBox("oct");
			nov = new JCheckBox("nov");
			dec = new JCheckBox("dec");
			
			//buttonGroup
			
			this.buttonGroup.add(jan); // unable the chance of selecting more than one checkbox
			this.buttonGroup.add(feb);
			this.buttonGroup.add(march);
			this.buttonGroup.add(apr);
			this.buttonGroup.add(may);
			this.buttonGroup.add(jun);
			this.buttonGroup.add(jul);
			this.buttonGroup.add(ago);
			this.buttonGroup.add(sep);
			this.buttonGroup.add(oct);
			this.buttonGroup.add(nov);
			this.buttonGroup.add(dec);
			
			
// adding the buttons to the panel
			
			
			panel.add(jan);
			panel.add(feb);
			panel.add(march);
			panel.add(apr);
			panel.add(may);
			panel.add(jun);
			panel.add(jul);
			panel.add(ago);
			panel.add(sep);
			panel.add(oct);
			panel.add(nov);
			panel.add(dec);
			panel.add(fieldDayOfMonth);
			panel.add(buttonHabit,BorderLayout.CENTER);
			
			
//adding the action listener to the buttons	
			jan.addActionListener(this);
			feb.addActionListener(this);
			march.addActionListener(this);
			apr.addActionListener(this);
			may.addActionListener(this);
			jun.addActionListener(this);
			jul.addActionListener(this);
			ago.addActionListener(this);
			sep.addActionListener(this);
			oct.addActionListener(this);
			nov.addActionListener(this);
			dec.addActionListener(this);
			buttonHabit.addActionListener(this);
			
			
		
			
			
			
			pestañas.addTab("Set Habit", panel);
			
			
			JPanel panelFieldSetAlarms = new JPanel();
			panelFieldSetAlarms.setLayout(new FlowLayout());
			
			panel1 = new JPanel();
			panel1.setLayout(new BorderLayout());
			
			
		    eraseBu = new JButton("eraseAlarm");
			eraseBu.setBackground(Color.red);
			eraseBu.addActionListener(this);
			
			button = new JButton("SetAlarm");
			button.setBackground(Color.GREEN);
			button.addActionListener(this);
			button.setActionCommand("ENTER");
			
			
		
			fieldMinute = new JTextField("Minute");
			
			fieldHour = new JTextField("Hour");
			
			fieldToDo = new JTextField("to Do");
			
			
			
			
			panel1.add(button,BorderLayout.WEST);
			panel1.add(eraseBu,BorderLayout.EAST);
			panel1.add(panelFieldSetAlarms);
			panelFieldSetAlarms.add(fieldHour);
			panelFieldSetAlarms.add(fieldMinute);
			panelFieldSetAlarms.add(fieldToDo);
			
			
			this.pestañas.add("Set Alarms", panel1);
			
			
			
			
			
			panel2 = new JPanel();
			panel2.setLayout(new BorderLayout());
			
			textAlarm = new JTextArea(24,30);
			
			
			
			textAlarm.setEditable(false);
			
			buttonStopAlarm = new JButton("STOP");
			
			buttonStopAlarm.setBackground(Color.red);
			
			
			buttonStopAlarm.addActionListener(this);
			
			panel2.add(buttonStopAlarm,BorderLayout.WEST);
			
			panel2.add(textAlarm,BorderLayout.CENTER);
			
			
			pestañas.addTab("Alarms", panel2);
			
			textHabit = new JTextArea(1,15);
			textHabit.setEditable(false);
			panel.add(textHabit);
			
			if(ar.isFile()) { //extract the store habit only if the file habit exists
				
				String data = this.ar.read();
				String num1="";
				String num2="";
				int i =0;
				boolean point=false;
				while(i<data.length()) {     //algorithm that extracts the stored habit
					if(data.charAt(i)==':')
					  {point=true;
					   i++;}
					else if(!point) {
						num1+=data.charAt(i);
						i++;}
					else {
						 num2+=data.charAt(i);
						 i++;}
				}
				setHabit(Integer.parseInt(num1),Integer.parseInt(num2));
				
				
				
			}
			
			
			
			
			
			
			
			if(ar.isFileAlarm()) { 	//extract the stored alarms only if the file alarms exists
				
				String data1 = this.ar.readAlarms();
				
				int j =0;
				boolean dots = false;
				String toDo = "";
				boolean space = false;
				String minute ="";
				String hour ="";
				boolean invBar = false;
				while (j<data1.length()) {  //algorithm that extracts the alarms stored in the file alarms.txt
					
					if(data1.charAt(j)==' ')
						space = true;
					
					if(data1.charAt(j)==':') {
						dots = true;
						j++;}
					
					else if(this.auxFun.charAfterInt(j, data1)||j+1==data1.length()) {
						toDo+=data1.charAt(j);
						dots = false;
						space = false;
						
						setToDo(Integer.parseInt(hour),Integer.parseInt(minute),toDo,false);
						hour = "";
						minute = "";
						toDo = "";
						j++;
					}
					
					else if (dots&&space) {
						  toDo+=data1.charAt(j);	
						  j++;}
					
					else if(dots&&!space) {
						minute+=data1.charAt(j);
						j++;}
					else {
						hour+=data1.charAt(j);
						j++;
					}
					
					
					
				}
				
				
				
				
				
			
			}
			
			
			
			
			
			
			
			
			getContentPane().add(pestañas);
		
			
			setVisible(true);
			
	
	
	
	}
	
	
	//control the actual date with the date entered by the user 
	protected void controlHabit() {
		this.centro.controlHabit();}
	
// adds a new habit
	
	protected boolean setHabit(int month,int day) {
			if(centro.setHabit(month, day)) {
				
				this.centro.turnOffAlarms();
				this.textHabit.setText("");
				this.textAlarm.setText("");
				this.ar.writer(month+":"+day);
				this.textHabit.append(this.centro.time());
				return true;}

			return false;
	}
	
	//add the alarm that the user puts within the textField
	
	protected boolean setToDo (int hour,int minute,String toDo,boolean rewrite) {
		if (this.centro.setToDo(hour, minute, toDo)) {
			if(rewrite)
				this.ar.writerAlarm(hour+":"+minute+" "+toDo+"\n");
		
			this.textAlarm.setText("");
			this.textAlarm.append(this.centro.getAlarms());
			return true;}	
		
		return false;}
	


//creates the main window
	private void configWin() {
			this.setTitle("la Ventana");
			this.setSize(800, 700);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pestañas =  new JTabbedPane();}
		

	//manages all the interactions between the user and the program
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getActionCommand().equals("ENTER")) {
			
			String textoHora = fieldHour.getText();
			String textoMinuto = fieldMinute.getText();
			String textoToDo = fieldToDo.getText();
			if(this.auxFun.cast(textoHora)==-1||this.auxFun.cast(textoMinuto)==-1)
				JOptionPane.showMessageDialog(this, "Invalid alarm");
			else
				{if(!setToDo(this.auxFun.cast(textoHora), this.auxFun.cast(textoMinuto), textoToDo,true)) {
					JOptionPane.showMessageDialog(this, "Invalid alarm");
				}
				}
				
		
				}
		
		if(e.getSource()==this.eraseBu) {
			String textoHora = fieldHour.getText();
			String textoMinuto = fieldMinute.getText();
			if(this.auxFun.cast(textoHora)==-1||this.auxFun.cast(textoMinuto)==-1)
				JOptionPane.showMessageDialog(this, "Invalid alarm");
			else
				if(!eraseAlarm(this.auxFun.cast(textoHora), this.auxFun.cast(textoMinuto)))
					JOptionPane.showMessageDialog(this, "Invalid Alarm");
		
				}
		
		
		
//manages  the panel setHabit
		
		if(this.jan.isSelected()&&e.getSource()==buttonHabit)
			{					
				String textoDia = fieldDayOfMonth.getText();
				
				if(!setHabit(0,this.auxFun.cast(textoDia))) {  // 			if the given input is invalid setHabit return false
					JOptionPane.showMessageDialog(this, "Invalid input");	//if setHabit()==false then a window appears 
					}
				else
					ar.deleteAlarms(); // if setHabit == true we need to erase the last file with the old alarms
				}					   //same in every single condition until december
		
		if(this.feb.isSelected()&&e.getSource()==buttonHabit)
				
		{		String textoDia = fieldDayOfMonth.getText();
		
		if(!(setHabit(1,this.auxFun.cast(textoDia)))) {
			JOptionPane.showMessageDialog(this, "Invalid input"); 
			}
		else
			ar.deleteAlarms();
		}
		if(this.march.isSelected()&&e.getSource()==buttonHabit)
		{		String textoDia = fieldDayOfMonth.getText();
		
		if(!(setHabit(2,this.auxFun.cast(textoDia)))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
				}
		
		if(this.apr.isSelected()&&e.getSource()==buttonHabit)
		{		String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(3,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.may.isSelected()&&e.getSource()==buttonHabit)
		{		String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(4,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.jun.isSelected()&&e.getSource()==buttonHabit)
		{			String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(5,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.jul.isSelected()&&e.getSource()==buttonHabit)
		{			String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(6,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.ago.isSelected()&&e.getSource()==buttonHabit)
		{			String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(7,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.sep.isSelected()&&e.getSource()==buttonHabit)
		{			String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(8,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.oct.isSelected()&&e.getSource()==buttonHabit)
		{			String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(9,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.nov.isSelected()&&e.getSource()==buttonHabit)
		{			String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(10,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
		if(this.dec.isSelected()&&e.getSource()==buttonHabit)
		{			String textoDia = fieldDayOfMonth.getText();
		
		if(!setHabit(11,this.auxFun.cast(textoDia))) {
			JOptionPane.showMessageDialog(this, "Invalid input");
			}
		else
			ar.deleteAlarms();
		}
	
	
		if(e.getSource()==this.buttonStopAlarm)
			{
			 this.stopAlarm = stopAlarm();}
			
	
	
	
	
	
	}


	
	
	public static void main(String [] args) {
	    Timer1 timer1 = new Timer1();
	    Timer timer = new Timer();
	    ArchiveManager ar = new ArchiveManager();
	    
	    
	    
		
	
	
	
	
	
	TimerTask tarea = new TimerTask() {

		@Override
		public void run() {
			boolean alarm =timer1.alarm(timer1.cont); //compares the hour and minute with the alarms
			
			
			
			if(alarm) {
				//adds an integer to the counter in 
				timer1.sumCont();
				}
			
			//if stop is true sets the stop to false and cont to zero 
			else if(timer1.getStop())
				{timer1.setStopAlarmFal();
				 timer1.setContZero();}
			timer1.controlHabit();
			
		
		}
		
	};
	
	timer.schedule(tarea, 20,20);
	
	}





	

	
}
	
		
			
		
	

	



