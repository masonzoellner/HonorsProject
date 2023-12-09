package dataqueue;
// -------------------------------------------------------------------------
/**
 *  This is the PlayerDataSet, that implements an ArrayQueue that takes in 
 *  a parameter of type Data.
 * 
 *  @author mason
 *  @version Nov 27, 2023
 */
public class PlayerDataSet
{
  //~ Fields ................................................................
    private ArrayQueue<Data> playerQueue;
    private int size; 

    // ----------------------------------------------------------
    /**
     * Create a new PlayerDataSet object.
     * @param queueSize is the size of the 
     * @param gui is the created GUI of the project.
     */
    //~ Constructors ..........................................................
    public PlayerDataSet(int queueSize) {
        playerQueue = new ArrayQueue<Data>(queueSize);
        setSize(queueSize);
    }
    
    // ----------------------------------------------------------
    /**
     * This method sets the size for the PlayerDataSet
     * @param size is the set size.
     */
    public void setSize(int size) {
        this.size = size;
    }
    // ----------------------------------------------------------
    /**
     * This method adds a player 
     * @param player adds a player into the array queue.
     */
    //~Public  Methods ........................................................
    public void addPlayer(Data player) {
        playerQueue.enqueue(player);
    }

    // ----------------------------------------------------------
    /**
     * This gets the player Queue.
     * @return the ArrayQueue for the player data.
     */
    public ArrayQueue<Data> getPlayerQueue() 
    {
        return playerQueue;
    }
}
