package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
    private Object[] itemArray;
    private int capacity;
    private int currentSize = 0;
    private int head = 0;
    private int tail = -1;

    public QueueImplementation() throws QueueAllocationException {
        capacity = 10;
        itemArray = new Object[10];
    }

    public QueueImplementation(int capacity) throws QueueAllocationException {
        if (capacity < 2) {
            throw new QueueAllocationException("Capacity is too small!");
        }
        this.capacity = capacity;
        itemArray = new Object[capacity];
    }

    public int capacity() {
        return this.capacity;
    }

    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (currentSize == capacity) {
            Object[] tmp = new Object[this.capacity * 2 + 1];
            int idxOfItemArray = head;
            int idxOfTmp = 0;
            int loopTime = currentSize;
            while (loopTime-- > 0) {
                tmp[idxOfTmp++] = itemArray[idxOfItemArray];
                idxOfItemArray = (idxOfItemArray + 1) % capacity;
            }
            head = 0;
            tail = idxOfTmp - 1;
            itemArray = tmp;
            capacity = capacity * 2 + 1;
        }
        if (element == null) {
            throw new NullPointerException();
        }
        tail = (tail + 1) % capacity;
        itemArray[tail] = element;
        currentSize++;
    }

    public E dequeue() throws QueueIsEmptyException {
        E returnE = element();
        itemArray[head] = null;
        head = (head + 1) % capacity;
        currentSize--;
        return returnE;
    }

    public E element() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        return (E) itemArray[head];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void clear() {
        head = 0;
        tail = -1;
        currentSize = 0;
        itemArray = new Object[capacity];
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int idxOfItemArray = head;
        int loopTime = currentSize;
        while (loopTime-- > 0) {
            builder.append(itemArray[idxOfItemArray].toString());
            idxOfItemArray = (idxOfItemArray + 1) % capacity;
            if (loopTime != 0) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
