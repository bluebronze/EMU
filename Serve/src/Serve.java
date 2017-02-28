
/*
 * Nadya Novak
 * 02-08-17
 * COSC 311
 * 
 * //http://www.mycstutorials.com/articles/data_structures/queues
 * //http://stackoverflow.com/questions/12557550/decrementing-value-stored-in-a-queue
 */

import java.util.*;

public class Serve {
	public static void main(String[] args) {

		int cCount = 0;
		int cash = 0;
		int ticks = 0;
		int adder;
		int servers = 1;

		int servTime = 1;
		int servTime2 = 1;

		int liveCusts = 0;
		int waitTotal = 0;
		int totalServiced = 0;

		Random r = new Random(10);

		Queue line = new Queue();

		while (ticks < 30) {

			cash = cash - (3 * servers); // decrements server cost

			if (servTime == 0) {
				servTime = 2 + r.nextInt(6 - 2 + 1); // sets service time

				if (servers == 2 && servTime2 != 0) {
					line.cut(1);
				} else {
					line.dequeue(); // kills served customer
				}
				cash++; // adds profit from served customer
				liveCusts--;
				totalServiced++;

			}

			servTime--;// reduces service time

			if (servers == 2) {
				if (servTime2 == 0) {
					servTime2 = 2 + r.nextInt(6 - 2 + 1);// 2+(int)(Math.random()*
															// 6)-1;
					if (servers == 2 && servTime != 0) {
						line.cut(1);
					} else {
						line.dequeue(); // kills served customer
					}
					cash++;
					liveCusts--;
					totalServiced++;
				}
				servTime2--;

			}

			adder = Poisson(5);

			while (adder > 0) {
				line.enqueue(new Customer(cCount, 0));
				liveCusts++;
				cCount++;
				adder--;
			}

			for (int i = 0; i < line.size(); i++) {

				((Customer) line.getSpot(i)).inc();
				waitTotal++;

				if (((Customer) line.getSpot(i)).getWait() == 8) {
					// REMOVE
					line.cut(i);
					cash = cash - 10;
					liveCusts--;
				}
			}

			ticks++;
			System.out.println(cash);
		}

	}

	static int Poisson(int mean) {

		Random r = new Random(10);
		double L = Math.exp(-mean);
		int k = 0;
		double p = 1.0;
		do {
			p = p * r.nextDouble();
			k++;
		} while (p > L);
		return k - 1;
	}

}

class Queue {

	private LinkedList<Customer> list;

	public Queue() {
		list = new LinkedList<Customer>();
	}

	public boolean isEmpty() {
		return (list.size() == 0);
	}

	public int size() {
		return (list.size());
	}

	public void enqueue(Object cust) {
		list.add((Customer) cust);
	}

	public Object dequeue() {

		Object cust = list.get(0);
		list.remove(0);

		return cust;
	}

	public Object cut(int i) {

		Object cust = list.get(i);
		list.remove(i);

		return cust;
	}

	public Object peek() {
		return list.get(0);
	}

	public Object getSpot(int dex) {
		return list.get(dex);
	}

}

class Customer {

	int number;
	int wait;

	// Constructor
	public Customer(int no, int wt) {
		number = no;
		wait = wt;
	}

	public int inc() {
		wait++;
		return wait;
	}

	public int getNum() {
		return number;
	}

	public int getWait() {
		return wait;
	}

}