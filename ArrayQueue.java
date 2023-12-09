package dataqueue;
import bin.queue.EmptyQueueException;

import java.util.Arrays;
import queue.QueueInterface;
// -------------------------------------------------------------------------
/**
 *  This is the ArrayQueue method that implements a queue interface.
 *  @param <T>
 * 
 *  @author mason
 *  @version Nov 20, 2023
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    //~ Fields ................................................................
    private T[] elements;
    private int frontIndex;
    private int backIndex;
    private int size;
    //private static final int DEFAULT_CAPACITY = 100;
    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * @param initialcap is the capacity of the ArrayQueue
     */
    //~ Constructors ..........................................................
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialcap)  
    {
        this.elements = (T[])new Data[initialcap];
        size = 0;
        frontIndex = 0;
        backIndex = elements.length - 1;
    }
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * This enqueue method adds a new entry to the back index of the queue.
     * @param data is the added entry.
     */
    public void enqueue(T data) {
        ensureCapacity();
        backIndex = (backIndex + 1) % elements.length;
        elements[backIndex] = data;
        size++;
        
    }

    // ----------------------------------------------------------
    /**
     * This dequeue method takes away the entry in the front index position.
     * @return the Object removed.
     */
    public T dequeue() {
        T front = getFront();
        elements[frontIndex] = null;
        frontIndex = (frontIndex + 1) % elements.length;
        size--;
        return front;
        
    }
    
    // ----------------------------------------------------------
    /**
     * This getFront method gets the value in the frontIndex
     * @return
     */
    public T getFront()
    {
        if ( isEmpty())
        {
            throw new EmptyQueueException();
        }
        return elements[frontIndex];
    }

    // ----------------------------------------------------------
    /**
     * This is the contains method that evaluates whether or not the parameter
     * is contained in the array
     * @param data is the entry determined.
     * @return a boolean depending if the array contains the data or not.
     */
    public boolean contains(T data) 
    {
        for (int i = 0; i < elements.length; i++) 
        {
            if (data.equals(elements[i])) 
            {
                return true;
            }
        }
        return false;
    }

    // ----------------------------------------------------------
    /**
     * This is the getFrequencyOf method that gives the frequency of a 
     * data point
     * @param data is the data point evaluated
     * @return the frequency of the data.
     */
    public int getFrequencyOf(T data) {
        int count = 0;
        for (int i = 0; i < elements.length; i++) 
        {
            if (data.equals(elements[i])) 
            {
                count++;
            }
        }
        return count;
    }
    @SuppressWarnings("unchecked")
    private void ensureCapacity() 
    {
        if ((backIndex + 2) % elements.length == frontIndex)
        {
            Object[] oldContents = elements;
            int oldSize = oldContents.length;
            int newSize = 2 * oldSize;
            elements = (T[])new Data[newSize];
            int j = frontIndex;
            for ( int i = 0; i < oldSize - 1; i++)
            {
                elements[i] = (T)oldContents[j];
                j = (j+1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
            
        }
    }

    // ----------------------------------------------------------
    /**
     * This method evaluates if the method is empty or not.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() 
    {
        return size == 0; 
    }
    // ----------------------------------------------------------
    /**
     * This returns the size of the array queue.
     * @return the size of the array
     */
    public int getSize() {
        return size;
    }
    @Override
    public void clear()
    {
        // TODO Auto-generated method stub
        
    }
    // ----------------------------------------------------------
    /**
     * Prints the contents of an ArrayQueue
     */
    public String toString() 
    {
        if ( isEmpty())
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int in = backIndex;
        for ( int i = 0; i < size - 1; i++)
        {
            sb.append(elements[in] + ", ");
            in = incrementIndex(in);
        }
        sb.append(elements[in] + "]");
        return sb.toString();
    }
    private int incrementIndex(int index)
    {
        return (index + 1) % elements.length;
    }
}
