package edu.fullerton.csu.cpsc.mystack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<Item> implements Iterable<Item> {

    public static final int max = 3;
    private int count;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    public MyStack() {
        first = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        count++;
    }

    public Item pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        count--;
        return item;                   // return the saved item
    }
    public Item peek() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return first.item;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
