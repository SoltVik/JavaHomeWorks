package lesson09;

import java.util.Iterator;

public class RubberList<E> implements Iterable<E>{
    private int size = 0;
    private Node<E> first;
    private Node<E> last;


    //stack methods
    public void push(E value) {
        add(value);
    }

    public E pop() {
        if (size > 0) {
            E lastValue = (last != null ? last.item : first.item);
            remove(size - 1);
            return lastValue;
        }
        return null;
    }

    public E peek() {
        return (last != null ? last.item : first.item);
    }

    //queue methods
    public void offer(E value) {
        if (first == null) {
            first = new Node(null, value, null);
        } else if (last == null) {
            last = first;
            first = new Node(null, value, last);
            last.prev = first;
        } else {
            Node newFirst = new Node(null, value, first);
            first.prev = newFirst;
            first = newFirst;
        }
        size++;
    }

    public E poll() {
        return pop();
    }


    //standards methods
    public void add(E value) {
        if (first == null) {
            first = new Node<E>(null, value, null);
        } else if (last == null) {
            last = new Node<E>(first, value, null);
            first.next = last;
        } else {
            Node newLast = new Node<E>(last, value, null);
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < size) {
            size--;
            if (index == 0) {
                if (first.next == null) {
                    first = null;
                    return true;
                }
                Node newFirst = first.next;
                newFirst.prev = null;
                first = newFirst;
                return true;
            } else if (index == size) {
                Node newLast = last.prev;
                newLast.next = null;
                last = newLast;
                return true;
            } else {
                int counter = 0;
                Node cursor = first;
                while (cursor != null) {
                    if (index == counter) {
                        Node prev = cursor.prev;
                        Node next = cursor.next;
                        prev.next = next;
                        next.prev = prev;
                        cursor.next = null;
                        cursor.prev = null;
                        return true;
                    }
                    cursor = cursor.next;
                    counter++;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node cursor = first;
        while (cursor != null) {
            sb.append(cursor.item);
            if (cursor.next != null) {
                sb.append(", ");
            }
            cursor = cursor.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }


    private class Itr implements Iterator<E> {
        Node<E> cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E value = cursor.item;
            cursor = cursor.next;
            return value;
        }
    }


    private class Node<E> {
        E item;
        Node next;
        Node prev;

        public Node(Node prev, E item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}