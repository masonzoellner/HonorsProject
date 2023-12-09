package dataqueue;
import queue.EmptyQueueException;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  This is the ArrayQueueTest that tests all of the methods
 *  in the ArrayQueue.
 * 
 *  @author mason
 *  @version Oct 30, 2023
 */
public class ArrayQueueTest extends TestCase 
{
    //~ Fields ................................................................
    /**
     * This is the aq field
     */
    private ArrayQueue<Data> aq = new ArrayQueue<>(5);
    /**
     * This is the aq2 field.
     */
    private ArrayQueue<Data> aq2 = new ArrayQueue<>(5);
    /**
     * This is the aq3 field.
     */
    private ArrayQueue<Data> aq3 = new ArrayQueue<>(5);
    /**
     * This is the aq4 field.
     */
    private ArrayQueue<Data> aq4 = new ArrayQueue<>(5);
    /**
     * This is the aq5 field.
     */
    private ArrayQueue<Data> aq5 = new ArrayQueue<>(5);
    /**
     * This is the aq6 field.
     */
    private ArrayQueue<Data> aq6 = new ArrayQueue<>(2);


    //~ Constructors ..........................................................
    /**
     * This is the setUp method that runs before each test.
     */
    public void setUp()
    {
        aq.enqueue(new Data("mason", 1.5));
        aq.enqueue(new Data("mason", 1.5));
        aq.enqueue(new Data("mason", 1.5));
        aq2.enqueue(new Data("mason", 1.5));
        aq4.enqueue(new Data("mason", 1.5));
        aq4.enqueue(new Data("mason", 1.5));
        aq4.enqueue(new Data("mason", 1.5));
        aq5.enqueue(new Data("mason", 1.5));
        aq5.enqueue(new Data("mason", 1.5));
        aq5.enqueue(new Data("mason", 1.5));
        aq6.enqueue(new Data("mason", 1.5));
        aq6.enqueue(new Data("mason", 1.5));
        aq6.enqueue(new Data("mason", 1.5));
    }
    // ----------------------------------------------------------
    /**
     * This is the test for clear.
     */
    //~Public  Methods ........................................................
    public void testClear()
    {
        aq.clear();
        assertEquals(aq.getSize(), 0);
    }
    
    // ----------------------------------------------------------
    /**
     * This makes sure toString runs correctly.
     */
    public void testToString()
    {
        assertEquals(aq3.toString(), "[]");
        assertEquals(aq.toString(), "[Data{name='mason', value=1.5}, null, null]");
    }
    
    /**
     * This makes sure dequeue runs correctly.
     */
    public void testDequeue()
    {
        Exception exception = null;
        try
        {
            aq3.dequeue();
        }
        catch (EmptyQueueException e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
        aq.dequeue();
        assertEquals(aq.getSize(), 2);
    }
    
    
}
