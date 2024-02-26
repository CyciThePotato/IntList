package intlist;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van deze klasse slaat een array Int waardes op. (niet immutable)
 */
public class intLinkedList {
	
	private class Node {
		/**
		 * @invar | previous != null
		 * @invar | next != null
		 * @invar | previous.next == this
		 * @invar | next.previous == this
		 * 
		 * @peerObject
		 */
		private Node previous;
		private int element;
		/** @peerObject */
		private Node next;
		
		private int getSize() {
			return this == sentinel ? 0 : 1 + next.getSize();
		}
	}
	
	/**
	 * @invar | sentinel != null
	 * @invar | size == sentinel.next.getSize()
	 * 
	 * @representationObject
	 * 
	 */
	private Node sentinel;
	private int size;
	
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public int[] getElements() {
		int[] result = new int[size];
		Node n = sentinel.next;
		for (int i = 0; i < size; i++) {
			result[i] = n.element;
			n = n.next;
		}
		return result;
	}
	
	/**
	 * @post | result == getElements().length
	 */
	public int getLength() {
		return size;
	}
	
	/**
	 * @pre | 0 <= index && index <= getLength()
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) {
		if (index < size / 2) {
			Node n = sentinel.next;
			while (index > 0) {
				n = n.next;
				index--;
			}
		}
		else {
			Node n = sentinel;
			while (index < size) {
				n = n.previous;
				index++
			}
			return n.element;
		}
	}
	
	/**
	 * @post | getLength() == 0
	 */
	public intLinkedList() {
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
	}
	
	/**
	 * @mutates | this
	 * @post | getLength() == old(getLength()) + 1
	 * @post De bestaande elementen zijn ongewijzigd
	 * 	| IntStream.range(0, old(getLength())).allMatch(i -> getElementAt(i) == old(getElements())[i])
	 */
	public void add(int element) {
		Node newNode = new Node();
		newNode.next = sentinel;
		newNode.previous = sentinel.previous;
		newNode.previous.next = newNode;
		newNode.next.previous = newNode;
		size++;
	}
	
	/**
	 * @throws IllegalStateException | getLength() == 0 
	 * @mutates | this
	 * @post | getLength() == old(getLength()) - 1
	 * @post | IntStream.range(0, getLength()).allMatch(i -> getElementAt(i) == old(getElements())[i])
	 */
	public void removeLast() {
		if (size == 0) 
			throw new IllegalStateException("intlist object is empty-");
		Node n = sentinel.previous;
		n.next.previous = n.previous;
		n.previous.next = n.next;
		size--;
	}
}
