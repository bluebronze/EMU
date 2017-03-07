import java.util.*;

/*
 * Nadya Novak
 * 
 * COSC 311
 * HW03/02
 * Winter 2017
 */

public class zip {
	public static void main(String[] args) {

		lList one  = populate(1,3);
		lList two = populate(11,3);
		lList zip = new lList();
		
		one.print();
		System.out.println();
		two.print();
		
		zipper(one, two, zip, one.length(), two.length());
		System.out.println();
		zip.print();
		
		one = populate(1,1);
		two = populate(100,3);
		zip = new lList();
		
		System.out.println();
		System.out.println();
		one.print();
		System.out.println();
		two.print();
		
		zipper(one, two, zip, one.length(), two.length());
		System.out.println();
		zip.print();
		
		one = populate(0,0);
		two = populate(1,4);
		zip = new lList();
		
		System.out.println();
		System.out.println();
		one.print();
		System.out.println();
		two.print();
		
		zipper(one, two, zip, one.length(), two.length());
		System.out.println();
		zip.print();
		
		one = populate(5,3);
		two = populate(2,3);
		zip = new lList();
		
		System.out.println();
		System.out.println();
		one.print();
		System.out.println();
		two.print();
		
		zipper(one, two, zip, one.length(), two.length());
		System.out.println();
		zip.print();
	}

	public static lList populate(int start, int times) {
		lList lst = new lList();
		int counter = start;

		for (int i = 0; i < times; i++) {

			lst.add(new Node(counter, null));
			if (start == 11) {
				counter = counter + 10;
			} 
			else if(start == 100){
				counter = counter+100;
			}
			else if(start == 5 || start == 2){
				counter--;
			}
			else {
				counter++;
			}
			if (i != 0) {
				lst.getter(i - 1).next = lst.getter(i);
			}
		}
		
		return lst;
	}
	
	public static lList zipper(lList first, lList second, lList zipList, int lOne, int lTwo){

		if (lOne != 0 && lTwo != 0){
			zipList.add(first.getter(0));
			zipList.add(second.getter(0));
			
			first.cut();
			second.cut();
			
			int lenOne = lOne-1;
			int lenTwo = lTwo-1;
			
			zipper(first, second, zipList, lenOne, lenTwo);		
		}
		return zipList;
	}
}

class lList {

	LinkedList<Node> list;

	public lList() {
		list = new LinkedList<Node>();
	}

	public void add(Object item) {
		list.add((Node) item);
	}

	public Node getter(int i) {
		return list.get(i);
	}

	public void print() {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
	
	public int length(){
		return list.size();
	}
	
	public void cut(){
		list.remove(0);
		
	}
}

class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public String toString() {
		return "" + data + " ";
	}
}
