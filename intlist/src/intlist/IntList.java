package intlist;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van deze klasse slaat een array Int waardes op. (niet immutable)
 */
public class IntList {
	
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
//		return elements;	!!! REPRESENTATION EXPOSURE !!!
		return elements.clone();
	}
	
	/**
	 * @post | result == getElements().length
	 */
	public int getLength() {
		return elements.length;
	}
	
	/**
	 * @pre | 0 <= index && index <= getLength()
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) {
		return elements[index];
	}
	
	/**
	 * @post | getLength() == 0
	 */
	public IntList() {
//		elements = new int[0];
		elements = new int[] {};
	}
	
	/**
	 * @mutates | this
	 * @post | getLength() == old(getLength()) + 1
	 * @post De bestaande elementen zijn ongewijzigd
	 * 	| IntStream.range(0, old(getLength())).allMatch(i -> getElementAt(i) == old(getElements())[i])
	 */
	public void add(int element) {
		elements = Arrays.copyOf(elements, elements.length + 1);
		elements[elements.length - 1] = element;
	}
	
	/**
	 * @throws IllegalStateException | getLength() == 0 
	 * @mutates | this
	 * @post | getLength() == old(getLength()) - 1
	 * @post | IntStream.range(0, getLength()).allMatch(i -> getElementAt(i) == old(getElements())[i])
	 */
	public void removeLast() {
		if (elements.length == null) 
			throw new IllegalStateException("This intlistobject is empty");
		elements = Arrays.copyOf(elements, elements.length - 1);
	}
}
