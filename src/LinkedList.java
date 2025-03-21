
public class LinkedList<T extends Comparable<T>> {
	private Node<T> head;

	///////////////////////////////////////////////////////////////////////////////

	public void insert(T data) {// Sorted ---> Time Complexity O(n)
		Node<T> newNode = new Node<>(data);
		if (head == null) { // Linked List is Empty {case 1}
			head = newNode;
		} else { // Linked List is not Empty
			Node<T> curr = head;
			Node<T> prev = null;
			while (curr != null) {
				if (curr.getData().compareTo(data) < 0) {
					prev = curr;
					curr = curr.getNext();
				} else {
					break;
				}
			}
			if (curr == head) { // Insert first {case 2}
				newNode.setNext(head);
				head = newNode;

			} else if (curr == null) // Insert last {case 3}
				prev.setNext(newNode);
			else { // Insert between {case 4}
				newNode.setNext(curr);
				prev.setNext(newNode);
			}

		}

	}

	///////////////////////////////////////////////////////////////////////////////

	public boolean search(T target) { // Sorted --> Time Complexity O(n)
		if (head != null) { // Linked List is not Empty
			Node<T> curr = head;
			Node<T> prev = null;
			while (curr != null) {
				if (curr.getData().compareTo(target) == 0) // data equal target
					return true;
				else if (curr.getData().compareTo(target) < 0) { // data less than target
					prev = curr;
					curr = curr.getNext();
				} else // data grater than target
					return false;

			}

		}
		return false; // Linked List is Empty
	}

	///////////////////////////////////////////////////////////////////////////////

	public void delete(T target) { // Sorted --> Time Complexity O(n)
		if (head == null) { // Linked List is Empty
			System.out.println("Linked List is already empty!");
			return;
		} else { // Linked List is not Empty
			Node<T> curr = head;
			Node<T> prev = null;
			if (curr.getData().compareTo(target) == 0) { // data deleted in first
				head = head.getNext();
				return;
			}
			while (curr != null) {
				if (curr.getData().compareTo(target) == 0) { // target = data
					prev.setNext(curr.getNext()); // delete between or last
					return;
				}
				prev = curr;
				curr = curr.getNext();
			}

		}

	}

	///////////////////////////////////////////////////////////////////////////////

	public void getLength() { // --> Time Complexity O(n)
		Node<T> curr = head;
		int size = 0;
		while (curr != null) {
			size++;
			curr = curr.getNext();
		}
		System.out.println("length = " + size);
	}

	///////////////////////////////////////////////////////////////////////////////

	public void removeDuplicates() { // --> Time Complexity O(n)
		Node<T> curr = head;
		while (curr != null && curr.getNext() != null) {
			if (curr.getData().compareTo(curr.getNext().getData()) == 0) {
				curr.setNext(curr.getNext().getNext());
			} else
				curr = curr.getNext();
		}

	}

	///////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		Node<T> curr = head;
		String s = "Head -->";
		while (curr != null) {
			s = s + curr.toString();
			curr = curr.getNext();
		}
		return s + " Null";
	}

}
