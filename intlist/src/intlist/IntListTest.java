package intlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntListTest {

	@Test
	void test() {
		IntList myintlist = new IntList();
		assertEquals(0, myintlist.getLength());
		assertArrayEquals(new int[] {}, myintlist.getElements());
		
		myintlist.add(10);
		assertEquals(1, myintlist.getLength());
		assertArrayEquals(new int[] {10}, myintlist.getElements());
		
		myintlist.add(20);
		assertEquals(2, myintlist.getLength());
		assertArrayEquals(new int[] {10, 20}, myintlist.getElements());
		assertEquals(10, myintlist.getElementAt(0));
		assertEquals(20, myintlist.getElementAt(1));
		
		myintlist.removeLast();
		assertEquals(1, myintlist.getLength());
		assertArrayEquals(new int[] {10}, myintlist.getElements());
		assertEquals(10, myintlist.getElementAt(0));
		
		myintlist.removeLast();
		assertEquals(0, myintlist.getLength());
		assertArrayEquals(new int[] {}, myintlist.getElements());		
		
		
		
		
		
		intLinkedList intlist = new intLinkedList();
		assertEquals(0, intlist.getLength());
		assertArrayEquals(new int[] {}, intlist.getElements());
		
		intlist.add(10);
		assertEquals(1, intlist.getLength());
		assertArrayEquals(new int[] {10}, intlist.getElements());
		
		intlist.add(20);
		assertEquals(2, intlist.getLength());
		assertArrayEquals(new int[] {10, 20}, intlist.getElements());
		assertEquals(10, intlist.getElementAt(0));
		assertEquals(20, intlist.getElementAt(1));
		
		intlist.add(30);
		assertEquals(3, intlist.getLength());
		assertArrayEquals(new int[] {10, 20, 30}, intlist.getElements());
		assertEquals(10, intlist.getElementAt(0));
		assertEquals(20, intlist.getElementAt(1));
		assertEquals(30, intlist.getElementAt(2));
		
		intlist.add(40);
		assertEquals(3, intlist.getLength());
		assertArrayEquals(new int[] {10, 20}, intlist.getElements());
		assertEquals(10, intlist.getElementAt(0));
		assertEquals(20, intlist.getElementAt(1));
		assertEquals(30, intlist.getElementAt(2));
		assertEquals(40, intlist.getElementAt(3));
		
		intlist.removeLast();
		assertEquals(1, intlist.getLength());
		assertArrayEquals(new int[] {10}, intlist.getElements());
		assertEquals(10, intlist.getElementAt(0));
		
		intlist.removeLast();
		assertEquals(0, intlist.getLength());
		assertArrayEquals(new int[] {}, intlist.getElements());	
	}

}
