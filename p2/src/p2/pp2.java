package p2;

import java.io.*;
import java.util.*;

/*
 * Nadya Novak
 * 2017/04/18
 * https://github.com/bluebronze/EMU/tree/master/p2
 * 
 * Instructions unclear, probed stackexchange
 */

public class pp2 {
	public static void main (String[] args) throws IOException{
		
		int tableSize = 16;
		String blanks = "";
		String input = "";
		String data;
		
		RandomAccessFile ht =  new RandomAccessFile ("test.txt", "rw");
		Scanner scan = new Scanner(System.in);
		
		hashTab hash = new hashTab(16);//creates new hash table
		
		
		
		scan = new Scanner (new File ("input.dat"));
		// reads in File line by line
		while (scan.hasNextLine()){
			input = scan.nextLine();
			String intest = input.substring(0, 5);
			if(input.substring(0, 5).equals("input")){
				input = input.substring(7, input.length()-2);
				
				//Adjusts input length
				if (input.length()<10){
					for (int i = 10- input.length() ;i>0; i--){
						blanks = blanks +" ";
					}
					data = (input + blanks);
					
					
				}
				else if(input.length()>10){
					data = input.substring(0, 9);
				}
				else{ 
					data =  input;	
				}
				//turn into Node
				//add to hash table
				
			hash.input(hash, data.hashCode()%tableSize, new Node(data.hashCode(), data));
									
				//TEST CODE
				//System.out.println(data.hashCode());
				//System.out.println(data.hashCode()%tableSize);
				}
			else if (input.substring(0, 6).equals("delete")){
				//delete from table
				
				//hash.delete(hash, data.hashCode()%tableSize, new Node(data.hashCode(), data));
			}
			
			else{
					//print hash table
					hash.toString(hash);
			}
			}

		ht.close();
		scan.close();		
}
}

class hashTab{
	 //int tSize;
	 Node [] arr;
	 int tSize;
	public hashTab(int tabSize){
		
		arr = new Node[tabSize];

		 tSize	 = tabSize;
	}
	

	
public void input(hashTab h ,int key, Node item){
	
	arr = h.arr;

	if (key>=0){
	if(arr[key] == null){
		arr[key] = item;
		
		sizeCheck(h);
	}
	else{
		input (h,  key+1,  item);
	}
	}
	else{
		input (h, 0,  item);
	}

	}
	

	public void sizeCheck(hashTab h){
		int counter = 0;
		arr = h.arr;
		int size = h.tSize;
		
		for (int i = 0; i <size;i++ ){
			if(arr[i] != null){
				counter++;
			}
		}
		
		if(counter >= h.tSize/2){
			rehash(h, h.tSize);
		}
	}
	//Delete
	
	public void delete(hashTab h, int key, Node obj){
		arr = h.arr;
		if (arr[key] == obj){
			arr[key] =  null;
		}
		
		else {
			for (int i = 0; i< h.tSize; i++){
				if (arr[i] == obj){
					arr[i] =  null;
				}
				
			}
		}
		
	}
	
	//Rehash
	public void rehash(hashTab h, int size){
		hashTab temp = new hashTab(size*2);
		arr = h.arr; 
		int key;

		
		for (int i = 0; i<size; i++){
			if(arr[i] != null){
				key = arr[i].hash;
				
				
				
				input (temp, key, arr[i]);
				
				h = temp;
				
				
			}
		}
	}
	
	
	public String toString(hashTab h) {
		return "" + h.arr + " ";
	}

	
	

	
}

class Node{
	int hash;
	String data;
	
	public Node(int hash, String data){
		this.hash = hash;
		this.data = data;
	}
}

