package Prueba;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.Scanner;

public class ArchiveManager {
	
	//writes the file habit
	protected void writer(String args) {
		try {
			Writer w = new FileWriter("habit.txt");
			w.write(args);
			w.close();
			System.out.println("saludos padre");
		}
		
		catch(IOException e) {
			e.printStackTrace();}
		
	}
//reads the file habit
	 protected String read() {
		
		 try {
			 String data ="";
			 File file =  new File("habit.txt");
			 Scanner reader = new Scanner(file);
			 while(reader.hasNextLine()) {
				 data+=reader.nextLine();}
			 reader.close();
			 return data;
		 }
		 
		 catch(FileNotFoundException e) {
			 return "none";
		 }
		 
		 }
	 
//writes a string in file alarm
	 protected void writeAllAlarms(String str) {
			try {
				Writer w = new FileWriter("alarm.txt");
				w.write(str);
				w.close();
				System.out.println("saludos padre");
			}
			
			catch(IOException e) {
				e.printStackTrace();
				}
	 }
	 
//writes an alarm without erasing his content 
	 protected void writerAlarm(String args) {
			try {
				FileWriter w = new FileWriter("alarm.txt",true);
				BufferedWriter out = new BufferedWriter(w);
				out.write(args);
				out.close();
				}
			
			catch(IOException e) {
				e.printStackTrace();}
			
		}
	 
//reads the file alarm	 
	 protected String readAlarms() {
			
		 try {
			 String data ="";
			 File file =  new File("alarm.txt");
			 Scanner reader = new Scanner(file);
			 while(reader.hasNextLine()) {
				 data+=reader.nextLine();}
			 reader.close();
			 return data;
		 }
		 catch(FileNotFoundException e) {
			 return "";
		 } 
	 	}
//deletes the file alarm	 
	 protected void  deleteAlarms() {
		 try {
			 File file = new File("alarm.txt");
			 file.delete();}
		 
		 
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
//checks if the file alarm exists 	 
	 protected boolean isFileAlarm() {
			
			try{
				File file =  new File("alarm.txt");
				Scanner reader = new Scanner(file);
				return true;}
			
			catch(FileNotFoundException e) {
				return false;}
		}
	 
	 
	 
//checks if the file habit exists		
		protected boolean isFile() {
			
			try{
				File file =  new File("habit.txt");
				Scanner reader = new Scanner(file);
				return true;}
			
			catch(FileNotFoundException e) {
				return false;}
		}
	
	
	
	
}
