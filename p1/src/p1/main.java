/*
 * Nadya Novak
 * 11/16/17
 * https://github.com/bluebronze/EMU
 */



package p1;

import java.io.*;
import java.util.*;
import java.util.regex.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		String fileName = keyboard.next();
		File file = new File(fileName);
		
		ArrayList name = new ArrayList();
		ArrayList type = new ArrayList();
		ArrayList level = new ArrayList();
		ArrayList line = new ArrayList();
		
		
		
		String[]types = new String[3];
		
		boolean semi;
		
		types[0] = "proc";
		types[1] = "int";
		types[2] = "real";
		
		String temp;
		int lvl = 0;
		int ln = 1;
		
	
		
		try{
	Scanner in = new Scanner (file);
	
	boolean c = false;
	
	
	
		while(in.hasNext()){
			temp = in.next();
			
			for(int i = 0; i<types.length; i++){
				if(temp.equals(types[i])){
					type.add(temp);//Fills Type Arrlist with current value
					
					
					level.add(lvl);//Adds Level count
					line.add(ln);//Adds line #
		
					
					temp = in.next();
					name.add(temp);//fills name arrlist with next value, advances to said value
					
					
					System.out.println(type);//works
					System.out.println(name);//works
					System.out.println(level);//works
					System.out.println(line);
				}
				
				else if (temp.equals("{")){
				ln++; //Increments line count
				lvl++; //increments level count
				temp = "";
				
				}
				else if (temp.equals("}")){
					ln++; //Increments line count
					lvl--; //decrements level count
				}
				else if (temp.equals(";")){
					ln++; //Increments line count
				}
				else{
					
				}
			}
			
		}
	
		in.close();
		} catch (FileNotFoundException e) {
			   e.printStackTrace();
		  }
		String [] table = new String[(name.size())*3];
		
		int counter = 0;
		for (int i = 0; i<table.length; i = i+3) {
			
			table[i] =  name.get(counter).toString();
			table[i+1] =  type.get(counter).toString();
			table[i] =  level.get(counter).toString();
			counter++;
		}
		
		//String[][][] table = new String[name.size()] [name.size()] [name.size()] ;
	}
}
