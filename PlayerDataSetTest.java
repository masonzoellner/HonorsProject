package dataqueue;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author mason
 *  @version Dec 3, 2023
 */
public class PlayerDataSetTest extends TestCase
{
    //~ Fields ................................................................
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public void testCreate()
    {
        PlayerDataSet playerDataSet25 = new PlayerDataSet(25);
        playerDataSet25.addPlayer(new Data("mason", 2.5));
    }
}
