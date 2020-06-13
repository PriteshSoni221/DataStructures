/*
 * Linked List can contain any kind of data and it does not has to unique.
 * Slow to get nth element but insertion and deletion is quite faster. (Unless you are appending at the end).
 * Doubly linked list will solve the above problem
 */

public class LinkedList {
	Node head;
	
	
	//append an element at the end of our linked list
	public void append(int data) {
		Node current = head;
		
		if(head == null) {
			head = new Node(data);
			return;
		}
		//here we are connecting next node with our current node
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	
	// add an element at the beginning of our linked list
	public void prepend(int data) {
		
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
		
	}
	
	
	//delete the first value which is equal to the data argument
	public void delete(int data) {
		
		//if there is no node (head is null then we will return)
		if(head == null) {
			return;
		}
		
		//if head is that data then we will shift the head to next node
		if(head.data == data) {
			head = head.next;
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			if(current.next.data == data) {
				//so we are simply skipping that node instead of deleting it.
				current.next = current.next.next;
				//we will return as soon as we "delete" first node
				return;
			}
			current = current.next;
		}
	}
	
	public void show() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	//insert a node at some specific index
	public void insert(int index, int data) {
		Node newNode = new Node(data);
		Node current = head;
		
		//if inserting at index 0, basically we are prepending. prepend method will take care of head.
		if(index==0) {
			prepend(data);
			return;
		}
		
		for (int i = 0; i<index-1; i++) {
			current = current.next;
		}
		
		
		newNode.next = current.next; //current's previous next node will become newNode's next node
		current.next = newNode; //current's next node is now our newNode
	}
	
	public static void main(String [] args) {
		LinkedList l1 = new LinkedList();
		l1.append(1);
		l1.append(2);
		l1.prepend(3);
		l1.show();	
		System.out.println();
		l1.delete(3);
		l1.show();
		System.out.println();
		l1.insert(2, 7);
		l1.show();
	}
	
}
