package com.dequq;

// A custom Double Ended Queue (Deque) implementation:

public interface MyDeque<T> {

	public <T> T addHead(T data);
	public <T> T addTail(T data);
	
	public T getHead();
	public T getTail();
	
	public <T> boolean contains(T data);

	public T removeHead();
	public T removeTail();

	public T peekHead();
	public T peekTail();
	
	public T pollHead();
	public T pollTail();
	
	public T pop();
	
	public int size();

	public void printDequq() ;
	
	
}
