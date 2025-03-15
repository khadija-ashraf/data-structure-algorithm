package com.dequq;


class Node<T>{
	T data;
	Node<T> prev;
	Node<T> next;
	
	public Node(T data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}


class MyDequeImpl<T> implements MyDeque<T>{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public MyDequeImpl(){
		head = null;
		tail = null;
		size = 0;
	}

	public <T> T addHead(T data) {
		Node current = new Node<>(data);
		if(head == null) {
			head = current;
			tail = current;
			size++;
			return data;
		}
		current.next = head;
		head.prev = current;
		head = current;
		size++;
		
		return data;
	}

	public <T> T addTail(T data) {
		Node current = new Node<T>(data);
		
		if(tail == null) {
			head = current;
			tail = current;
			size++;
			return data;
		}
		tail.next = current;
		current.prev = tail;
		tail = current;
		size++;
		return data;
	}

	public T getHead() {
		if (head == null)
			return null;
		return head.data;
	}

	public T getTail() {
		if(tail == null)
			return null;
		return tail.data;
	}

	public <T> boolean contains(T data) {
		if(head == null)
			return false;
		
		if(head.data == data) {
			return true;
		}
		
		if(tail.data == data) {
			return true;
		}
		
		Node current = head;
		
		while(current != null) {
			if(current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public T removeHead() {
		if(head == null) {
			return null;
		}
		
		T removedData = head.data;
		
		head = head.next;
		
		if(head == null) {
			tail = null;
		} else {
			head.prev = null;
		}
		size--;
		return removedData;
	}

	public T removeTail() {
		if(tail == null) {
			return null;
		}
		if(tail.prev == null) {
			return null;
		}
		T removedData = tail.data;
		tail = tail.prev;
		if(tail == null) {
			head = null;
		} else {
			tail.next = null;
		}
		size--;
		return removedData;
	}

	public T peekHead() {
		if(head == null)
			return null;
		
		return head.data;
	}

	public T peekTail() {
		if(tail == null)
			return null;
		
		return tail.data;
	}

	public T pollHead() {
		if(head == null)
			return null;
		
		T polledData = head.data;
		
		head = head.next;
		
		if(head == null) {
			tail = null;
		} else {
			head.prev = null;
		}
		size--;
		
		return polledData;
	}

	@Override
	public T pollTail() {
		if(tail == null) {
			return null;
		}
		T pollData = tail.data;
		
		tail = tail.prev;
		
		if(tail == null)
			head = null;
		else {
			tail.next = null;
		}
				
		size--;
		return pollData;
	}
	
//	 1 <-2 -> 3 <- 4 -> 5 <- 6 ->null
//							 T
	public T pop() {
		if(tail == null)
			return null;
		
		T popedData = tail.data;
		
		tail = tail.prev;
		
		if(tail == null)
			head = null;
		else {
			tail.next = null;
		}
		size--;
		return popedData;
	}
	
	public int size() {
		return size;
	}
	public void printDequq() {
		System.out.println("Printing the deque of size: "+size());
		if (head == null) {
			System.out.println("Dequq is empty.");
		}
		Node<T> current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

}
