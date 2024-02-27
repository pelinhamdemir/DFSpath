import java.util.Iterator;
import java.util.LinkedList;

public class Bag<Item> implements Iterable<Item> {
    private LinkedList<Item> items = new LinkedList<Item>();

    // Add an item to the bag
    public void add(Item item) {
        items.add(item);
    }

    // Check if the bag is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Return the number of items in the bag
    public int size() {
        return items.size();
    }

    // Iterator for the bag
    public Iterator<Item> iterator() {
        return items.iterator();
    }}