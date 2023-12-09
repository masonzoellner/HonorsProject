package dataqueue;
// -------------------------------------------------------------------------
/**
 *  This is the base Data class, that holds the name of the player and 
 *  the value of their height in meters.
 * 
 *  @author mason
 *  @version Nov 20, 2023
 */
public class Data
{
    //~ Fields ................................................................
    private String name;
    private double value;
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Data object.
     * @param nam is the name of the player
     * @param val if the height of the player in meters
     */
    public Data(String nam, double val)
    {
        name = nam;
        value = val;
    }
    // ----------------------------------------------------------
    /**
     * This is the getter method for the height of the player.
     * @return the height of the player in meters.
     */
    //~Public  Methods ........................................................
    public double getValue()
    {
        return value; 
    }
    
    // ----------------------------------------------------------
    /**
     * This is the getter method for the name of the player.
     * @return the name of the player.
     */
    public String getName()
    {
        return name;
    }
    public String toString() 
    {
        return "Data{name='" + name + "', value=" + value + '}';
    }
}
