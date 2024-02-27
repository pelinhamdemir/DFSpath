import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> first;  // Front of the queue
    private Node<T> last;   // Rear of the queue
    private int size;       // Number of elements in the queue

    public Iterator<T> iterator() {
        return null;
    }

    // Private inner Node class
    private static class Node<T> {
        T item;
        Node<T> next;
    }

    // Initialize an empty queue
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

    // Enqueue an item (add it to the end of the queue)
    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    // Dequeue an item (remove and return the item from the front of the queue)
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    // Return (but do not remove) the item from the front of the queue
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return first.item;
    }}