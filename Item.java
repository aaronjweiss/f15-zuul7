
/**
 * Item class handles ingame items.
 * 
 * @author Aaron Weiss
 * @version 1.0.0
 */
public class Item
{
    // instance variables - replace the example below with your own
    private int weight;
    private String description;

    /**
     * Constructor for objects of class Item
     */
    public Item(String description, int weight)
    {
        // initialise instance variables
        this.description = description;
        this.weight = weight;
    }

    /**
     * Returns the weight of the Item
     * 
     * @return     the weight
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Returns a string description of the item
     * 
     * @return     the description
     */
    public String getDescription()
    {
        return description;
    }
}
