package dataqueue;
// -------------------------------------------------------------------------
/**
 *  This method gets the measurement for the time
 * 
 *  @author mason
 *  @version Dec 3, 2023
 */
public class TimeMeasurement
{
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param playerDataSet
     * @return
     */
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * This takes in a playerdataset and measures the enqueue time for it.
     * @param playerDataSet 
     * @return a double with the time.
     */
    public double measureEnqueueTime(PlayerDataSet playerDataSet) 
    {
        //ArrayQueue<Data> playerQueue = new ArrayQueue<Data>(playerQueue.getSize());
        ArrayQueue<Data> playerQueue = playerDataSet.getPlayerQueue();
        playerQueue = new ArrayQueue<Data>(playerQueue.getSize());
        long totalElapsedTime = 0;
            long startTime = System.nanoTime();
            Data player = new Data("SamplePlayer", 0);
            playerQueue.enqueue(player);
            long endTime = System.nanoTime(); 
            totalElapsedTime += (endTime - startTime);
        double averageTime = totalElapsedTime / 1e6;
        System.out.println(averageTime);
        return averageTime;
    }
    // ----------------------------------------------------------
    /**
     * This takes in a playerdataset and measures the dequeue time for it.
     * @param playerDataSet
     * @return the double containing the time.
     */
    public double measureDequeueTime(PlayerDataSet playerDataSet) 
    {
        ArrayQueue<Data> playerQueue = playerDataSet.getPlayerQueue();
        playerQueue = new ArrayQueue<Data>(playerQueue.getSize());
        playerQueue.enqueue(new Data("SamplePlayer", 1));
        long startTime = System.nanoTime();
        playerQueue.dequeue();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // ----------------------------------------------------------
    /**
     * This takes in a playerdataset and measures the getFront time for it
     * @param playerDataSet
     * @return the double containing the time.
     */
    public double measureFrontTime(PlayerDataSet playerDataSet) 
    {
        ArrayQueue<Data> playerQueue = playerDataSet.getPlayerQueue();
        playerQueue = new ArrayQueue<Data>(playerQueue.getSize());
        Data player = new Data("SamplePlayer", 1);
        playerQueue.enqueue(player);
        long startTime = System.nanoTime();
        playerQueue.getFront();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // ----------------------------------------------------------
    /**
     * This takes in a playerdataset and measures the isEmpty time for 
     * it.
     * @param playerDataSet
     * @return the double containing the time.
     */
    public double measureEmptyTime(PlayerDataSet playerDataSet) 
    {
        //System.out.println(playerDataSet.getPlayerQueue().printQueue());
        ArrayQueue<Data> playerQueue = playerDataSet.getPlayerQueue();
        playerQueue = new ArrayQueue<Data>(playerQueue.getSize());
        Data player = new Data("SamplePlayer", 1);
        playerQueue.enqueue(player);
        long startTime = System.nanoTime();
        playerQueue.isEmpty();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }
}
