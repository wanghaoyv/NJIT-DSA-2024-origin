package oy.tol.tra;
import java.util.ArrayList;

public class QueueImplementation<T> implements QueueInterface<T> {

    private ArrayList<T> queue;
    private int capacity;
    private int top1;
    private int top2;
    private int size;
   

    public QueueImplementation(int capacity) {
        this.queue = new ArrayList<>(capacity);
        this.capacity = capacity;
        top1=0;
        top2=-1;
        size=0;
      
    }

    
    public int capacity() {
        return capacity;
    }

    
    public void enqueue(T one) throws QueueAllocationException, NullPointerException {
        if (one == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (size == capacity) {
            int newCapacity = capacity*2;
            ArrayList<T>newArrayList = new ArrayList<>(newCapacity);
            for(int i = 0 ;i < size ;i++){
                int index = (top1 +i) % capacity;
                newArrayList.add(queue.get(index));
            }
            queue = newArrayList;
            capacity = newCapacity;
            top1=0;
            top2=size-1;
        }
        top2 = (top2 + 1)%capacity;
        if(top2==queue.size()){
          queue.add(one);
         
          
        }
        else{
            queue.set(top2, one);
        }
        size++;
    }

    
    public T dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        T one = queue.get(top1);
        top1 = (top1 + 1)%capacity;
        size--;

        if(size == 0){
            top1 = 0;
            top2 = -1;
        }
        return one;
    }

    
    public T element() throws QueueIsEmptyException {
        if (top2 == -1) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        return queue.get(top1);
    }

  
    public int size() {
        return size;
    }

    
    public boolean isEmpty() {
        return (size == 0);
    }

   
    public void clear() {
        top1 = 0;
        top2 = -1;
        size = 0;
        
    }


    
    public String toString() {
       StringBuilder builder = new StringBuilder("[");
       for (int i = 0;i<size ; i++) {
        int index = (i + top1) % capacity;
          builder.append(queue.get(index));
          if (i < size - 1) {
             builder.append(", ");
          }
       }
       builder.append("]");
       return builder.toString();
    }
}

