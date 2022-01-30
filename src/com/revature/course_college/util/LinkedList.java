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
			this.tail.nextNode = newNode;
			this.tail = newNode;
			return true;
		}
	}
	
	/*
	 * If entry is null or is not present in list then returns false, otherwise removes entry containing data and returns true;
	 */
	public boolean remove(T data) {
		if(data == null) {return false;}
		if(this.head.data.equals(data)) {
			this.head = this.head.nextNode;
			return true;
		}
		Node<T> oldNode = this.head.nextNode;
		Node<T> previousNode = this.head;
		for(int i = 2; i <= this.size; i++) {
			if(oldNode.data.equals(data)) {
				if(oldNode.equals(this.tail)) {
					previousNode.nextNode = null;
					this.tail = previousNode;
					return true;
				}
				else {
					previousNode.nextNode = oldNode.nextNode;
					oldNode = null;
					return true;
				}
			}
			oldNode = oldNode.nextNode;
			previousNode = previousNode.nextNode;
		}//end for
		return false;
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
