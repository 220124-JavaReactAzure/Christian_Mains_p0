package com.revature.course_college.util;
/*
 * Class for a custom LinkedList
 * @author Christian Mains
 * @date 01/29/2022
 */
public class LinkedList<T> {
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public LinkedList(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	/*
	 * returns the number of entries in this LinkedList
	 */
	public int getSize() {
		return this.size;
	}
	/*
	 * returns false if entry is null or a duplicate, otherwise adds entry and returns true;
	 */
	public boolean add(T data) {
		if(data == null) {return false;}
		if(this.contains(data)) {
			return false;
		}
		Node<T> newNode = new Node<T>(data);
		if(this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
			return true;
		}
		else {
			newNode.nextNode = this.head;
			this.head = newNode;
			this.size++;
			return true;
		}
	}
	
	/*
	 * If entry is null or is not present in list then returns false, otherwise removes entry containing data and returns true;
	 */
	public boolean remove(T data) {
		if(data == null) {return false;}
		if(head.data.equals(data)) {
			head = head.nextNode;
			size--;
			return true;
		}
		Node<T> oldNode = head.nextNode;
		Node<T> previousNode = head;
		for(int i = 2; i <= size; i++) {
			if(oldNode.data.equals(data)) {
				if(oldNode.equals(tail)) {
					previousNode.nextNode = null;
					tail = previousNode;
					size--;
					return true;
				}
				else {
					previousNode.nextNode = oldNode.nextNode;
					oldNode = null;
					size--;
					return true;
				}
			}
			oldNode = oldNode.nextNode;
			previousNode = previousNode.nextNode;
		}//end for
		return false;
	}
	
	/*
	 * If LinkedList is empty returns null. Throws IndexOutOfBoundsException if index out of list rang. Returns the data at this index.
	 */
	public T get(int i) throws Exception{
		if(size == 0) {
			return null;
		}
		if(i < 0 || i+1 > size) {
			throw new IndexOutOfBoundsException();
		}
		Node myNode = this.head;
		for(int j = 0; j < size; j++) {
			if(j == i) {return (T)myNode.data; }
			myNode = myNode.nextNode;
		}
		return null;
	}
	
	/*
	 * If LinkedList contains entry then returns true, otherwise returns false
	 */
	public boolean contains(T data) {
		if(data == null) {return false;}
		Node<T> runner = this.head;
		for(int i = 1; i <= this.size; i++) {
			if(runner.data.equals(data)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Node carries data and pointer to the next node.
	 */
	private class Node<T>{
		T data;
		Node<T> nextNode;
		
		private Node(T data) {
			this.data = data;
			this.nextNode = null;
		}
	}
}
