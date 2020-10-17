package assignment3;

import java.util.Comparator;

/**
 * 
 * @author Nurbala Kaldybayeva
 *
 * @param <T> - data element type
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	protected Comparator<T> comparator;
/**
 * Creates an empty list that is associated with the specified comparator.
 * @param comparator2- Comparator to compare data elements
 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		head =null;
		tail =null;
		size =0;
		comparator=comparator2;
		
	}
/**
 * Inserts the specified element at the correct position in the sorted list.
 * @param data - the data to be added to the list
 * @return a reference to the current object
 */
	
	public SortedDoubleLinkedList<T> add(T data){
		if (data == null) {
			return this;
			}

			Node newnode = new Node(data, null, null);
			if (head == null) {
				head = tail = new Node(data, null, null);
			} else {
			if (comparator.compare(data, head.item) <= 0) {
			newnode.next = head;
			head = newnode;
			} else if (comparator.compare(data, tail.item) >= 0) {
			tail.next = newnode;
			tail = newnode;
			} else {
			Node next = head.next;
			Node prev = head;
			while (comparator.compare(data, next.item) > 0) {
			prev = next;
			next = next.next;
			}
			prev.next = newnode;
			newnode.next = next;
			}
			}
			size++;
			return this;
	}

	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data)  throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

/**
 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	@param 	data - the data for the Node within the linked list
	@return reference to the current object
	@throws java.lang.UnsupportedOperationException - if method is called
 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data)
	                                    throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
		
	}
	
/**
 * Implements the iterator by calling the super class iterator method.
 * @return an iterator positioned at the head of the list
 */
	@Override
	public java.util.ListIterator<T> iterator(){
		return super.iterator();
	}
	
/**
 * 	Implements the remove operation by calling the super class remove method.
 * @param data - the data element to be removed
 * @param comparator - the comparator to determine equality of data elements
 * @return data element or null;
 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data,
            java.util.Comparator<T> comparator){
		return (SortedDoubleLinkedList<T> ) super.remove(data, comparator);
	}
}
