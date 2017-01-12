/*
 Nadya Novak
 
 COSC 311
 HW 01/10
 WINTER 2017 
 */
 
public class A {
	public static void main(String[] args) {

		Node four = new Node(1, null);
		Node three = new Node(6, four);
		Node two = new Node(4, three);
		Node one = new Node(2, two);
		Node head = new Node(0, one);
		Node spot = head;
		int k = 2;

		System.out.print("Original list: ");
		while (spot != null) {
			System.out.print(spot.toString());
			spot = spot.next;
		}

		spot = head;
		System.out.println("");

		if (k == 0) {
			head = head.next;
		} else {
			for (int i = 0; i < k - 1; i++) {
				spot = spot.next;
			}
		}
		if (spot == null) {
		} else
			spot.next = spot.next.next;

		spot = head;
		System.out.print("Modified list: ");
		while (spot != null) {
			System.out.print(spot.toString());
			spot = spot.next;
		}

	}
}

class Node {
	// Attribution: http://www.vias.org/javacourse/chap14_02.html
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
