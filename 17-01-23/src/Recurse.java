		/*
		 * Nadya Novak 
		 * https://github.com/bluebronze/EMU 
		 * COSC 311 
		 * HW 01/17 
		 * WINTER 2017
		 */
public class Recurse {
	public static void main(String[] args) {
		Node[] arr = { new Node(5, 1), new Node(4, 7), new Node(6, -1), new Node(2, 2), new Node(5, -1), new Node(9, 5),
				new Node(8, 3), new Node(1, 9), new Node(2, 4), new Node(7, 4) };
		
		print(arr, 0);
	}

	public static void print(Node[] array, int start) {
		Node ar[] = array;

		if (ar.length == 0) {
			return;
		}
		System.out.print(ar[start]);
		if (ar[start].next == -1) {
			return;
		}
		int newStart = ar[start].next;
		print(ar, newStart);
	}
}

class Node {
	// Attribution: http://www.vias.org/javacourse/chap14_02.html
	int data;
	int next;

	public Node(int data, int next) {
		this.data = data;
		this.next = next;
	}

	public String toString() {
		return "" + data + " ";
	}
}