/**
 * Name: Nathan Dowd
 * PID: A17417179
 * Date: 1/30/2023
 * Sources: PA2 writeup, Piazza
 * 
 * This file contains the MyLinkedListCustomTester class. 
 * Writes more intensive testers for MyLinkedList.
 */

/**
 * IMPORTANT: Do not change the method headers. Your tests will be run against
 * good and bad implementations of MyLinkedList. You will only receive points
 * if your test passes when run on a good implementation and fails for the
 * corresponding bad implementation.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class MyLinkedListCustomTester {

	private MyLinkedList<Integer> emptyIntList;
	private MyLinkedList<String> filledStringList;
	private String strData[] = { "John" , "Hendrix" , "Abby" };

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		emptyIntList = new MyLinkedList<>();
		filledStringList = new MyLinkedList<>();
		filledStringList.add(strData[0]);
		filledStringList.add(strData[1]);
		filledStringList.add(strData[2]);
	}

	@Test
	public void testConstruction() {
		assertEquals("Dummy head should be null for emptyIntList",
			null, emptyIntList.head.getElement() );
		assertEquals("Dummy tail should be null for emptyIntList",
			null, emptyIntList.tail.getElement() );
		assertEquals("Size should be 0",
			0, emptyIntList.size() );

		assertEquals("Dummy head should be null for filledStringList",
			null, filledStringList.head.getElement() );
		assertEquals("Dummy tail should be null for filledStringList",
			null, filledStringList.tail.getElement() );
		assertEquals("Size should be 3",
			3, filledStringList.size() );
		assertEquals("Node 0 should be John",
			strData[0], filledStringList.get(0) );
		assertEquals("Node 1 should be Hendrix",
			strData[1], filledStringList.get(1) );
		assertEquals("Node 0 should be Abby",
			strData[2], filledStringList.get(2) );
	}

	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		emptyIntList.add(4);
		MyLinkedList<Integer>.Node added = emptyIntList.getNth(0);
		assertEquals("added data should be 4" , (Integer) 4, added.data);
		assertEquals("Node 0 data should be 4",
			(Integer) 4, emptyIntList.head.next.data );
		assertEquals("Size should be 1",
			1, emptyIntList.size );
		assertEquals("Node 0 prev should be head",
			emptyIntList.head, added.prev );
		assertEquals("Node 0 next should be tail",
			emptyIntList.tail, added.next );
		assertEquals("Head next should be node 0",
			emptyIntList.head.next , added );
		assertEquals("Tail prev should be node 0",
			emptyIntList.head.next, added );
		assertEquals("Head next and tail prev should point to same thing",
			emptyIntList.head.next , emptyIntList.tail.prev );

	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		filledStringList.add(0 , "new" );
		MyLinkedList<String>.Node added = filledStringList.getNth(0);
		assertEquals("added data should be new" , "new", added.data);
		assertEquals("Node 0 should be new",
			"new", filledStringList.head.next.data );
		assertEquals("Size should be 4",
			4, filledStringList.size );
		assertEquals("Node 0 prev should be head",
			filledStringList.head, added.prev );
		assertEquals("Node 0 next should be node 1",
			filledStringList.head.next.next, added.next );
		assertEquals("Head next should be node 0",
			filledStringList.head.next , added );
		assertEquals("Node 1 prev should be node 0",
			filledStringList.getNth(1).prev, added );
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		filledStringList.add(2 , "new" );
		MyLinkedList<String>.Node added = filledStringList.getNth(2);
		assertEquals("added data should be new" , "new", added.data);
		assertEquals("Node 2 should be new",
			"new", filledStringList.head.next.next.next.data );
		assertEquals("Size should be 4",
			4, filledStringList.size );
		assertEquals("Node 2 prev should be node 1",
			filledStringList.head.next.next, added.prev );
		assertEquals("Node 2 next should be node 3",
			filledStringList.tail.prev, added.next );
		assertEquals("node 1 next should be added",
			filledStringList.head.next.next.next , added );
		assertEquals("Node 3 prev should be added",
			filledStringList.tail.prev.prev, added );
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
	}
}
