
public class kLast {
	public static void main(String[] args) {

		System.out.println("Nadya Novak");
		System.out.println("");
		System.out.println("COSC 311");
		System.out.println("HW 01/12");
		System.out.println("WINTER 2017 ");

		Node four = new Node(1, null);
		Node three = new Node(6, four);
		Node two = new Node(4, three);
		Node one = new Node(2, two);
		Node head = new Node(0, one);
		Node spot = head;
		int k = 4;
		int counter = 0;

		while (spot.next != null) {
			spot = spot.next;
			counter++;
		}

		counter = counter - k;
		spot = head;

		for (int i = 0; i < counter; i++) {
			spot = spot.next;
		}
		if (spot == head) {
			head = head.next;
		}

		spot.next = spot.next.next;
		spot = head;
		System.out.println();
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