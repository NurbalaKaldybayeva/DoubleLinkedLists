package assignment3;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
  * @author Nurbala Kaldybayeva
 * @param <T> - data element type
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{

	
	  protected class Node {
	       
		  protected T item;
		  protected Node next, previous;

		  protected Node(T item, Node next, Node previous) {
		  this.item = item;
		  this.next = next;
		  this.previous = previous;
		  }
		  }


	
	protected Node head ;
	protected Node tail ;
	protected int size;
	
	public BasicDoubleLinkedList() {
		size = 0;
		head = tail = null;	
	}
	
	/**
	 * This method just returns the value of the instance variable 
	 * which used to keep track of size.
	 * @return size of the linked list
	 */
	public Object getSize() {
		return size;
	}
/**
 * Adds an element to the end of the list
 * @param data - the data for the Node within the linked list
 * @return reference to the current objects
 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node tmp = new Node(data, null, tail);
		if (tail != null) {
		tail.next = tmp;
		}
		tail = tmp;
		if (head == null) {
		head = tmp;
		}
		size++;
		return this;
	}
/**
 * Adds element to the front of the list. 
 * @param data - the data for the Node within the linked list
 * @return reference to the current object
 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node tmp = new Node(data, head, null);
		if (head != null) {
			head.previous = tmp;
		}
		head = tmp;
		if (tail == null) {
		tail = tmp;
		}
		size++;
		return this;
	}
	
/**
 * Returns but does not remove the first element from the list.
 * If there are no elements the method returns null.
 * @return the data element or null
 */
		public T getFirst() {
			// TODO Auto-generated method stub
			return head.item;
		}
	
/**
 * Returns but does not remove the last element from the list.
 * If there are no elements the method returns null.
 * @return the data element or null
 */
	public T getLast() {
		return  tail.item;
	}
/**
 * This method must be implemented using an inner class that implements ListIterator 
 * and defines the methods of hasNext(), next(), hasPrevious() and previous().
 *  
 * @return iterator element or null
 * @throws UnsupportedOperationException
 * @throws NoSuchElementException
 */
//	public ListIterator<T> iterator()  throws UnsupportedOperationException,
//                   NoSuchElementException{
//		return null;
//	}
	
/**
 * Removes the first instance of the targetData from the list.
 * @param targetData - the data element to be removed
 * @param comparator - the comparator to determine equality of data elements
 * @return data element or null
 */
	public BasicDoubleLinkedList<T> remove(T targetData,
            java.util.Comparator<T> comparator){
		Node prev = null, curr = head;
		while (curr != null) {
		if (comparator.compare(curr.item, targetData) == 0) {
		if (curr == head) {
			head = head.next;
		curr = head;
		} else if (curr == tail) {
		curr = null;
		tail = prev;
		prev.next = null;
		} else {
		prev.next = curr.next;
		curr = curr.next;
		}
		size--;
		} else {
		prev = curr;
		curr = curr.next;
		}
		}
		return this;
	}
/**
 * Removes and returns the first element from the list.
 * If there are no elements the method returns null.
 * @return data element or null
 */
	public T retrieveFirstElement() {
		if (size == 0) {
			throw new NoSuchElementException("Linked list is empty");
			}
			Node tmp = head;
			head = head.next;
			head.previous = null;
			size--;
			return tmp.item;
	}
/**
 * Removes and returns the last element from the list.
 * If there are no elements the method returns null.
 * @return data element or null
 */
	public T retrieveLastElement() {
		if (head == null) {
			throw new NoSuchElementException("Linked list is empty");

			}
			Node currentNode = head;
			Node previousNode = null;

			while (currentNode != null) {
			if (currentNode.equals(tail)) {
			tail = previousNode;
			break;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
			}
			size--;
			return currentNode.item;
	}
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list
	 * @return arraylist of the items in the list
	 */
	public java.util.ArrayList<T> toArrayList(){
		ArrayList<T> temp = new ArrayList<T>();
		ListIterator<T> iterator1 = new iter();

		while (iterator1.hasNext()) {
		temp.add(iterator1.next());
		}
		return temp;

	}

	public class iter implements ListIterator<T> {
		private Node current;
		private Node last;
		
		public iter() {
		current = head;
		last = null;
		}
		
		public T next()	{
		if(current != null)	{
				T returnData = current.item;
				last = current;
				current = current.next;
				if(current != null) { 
					current.previous = last;
				}
				return returnData;
		}else
		throw new NoSuchElementException();
		}
		
		public boolean hasNext(){
		return current!=null;
		}
		
		public T previous(){
			if(last != null) {
			current = last;
			last= current.previous;
			T returnData = current.item;
			return returnData;
			}else
			throw new NoSuchElementException();
		}
		
		public boolean hasPrevious(){
		return last!=null;
		}
		
		public void set(T data) {
		current.item = data;
		}
		@Override
		public int nextIndex() {
		throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
		throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
		throw new UnsupportedOperationException();
		}

		@Override
		public void add(T data) {
		throw new UnsupportedOperationException();
		}
		}


	public ListIterator<T> iterator() {
		return new iter();
		}

	

}
