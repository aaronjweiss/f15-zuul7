
/**
 * Item class handles ingame items.
 * 
 * @author Aaron Weiss
 * @author Randy Mitchell
 * @version 1.0.1
 */
public class Item
{
    // instance variables - replace the example below with your own
    private int weight;
    private String description;
    private String name;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight)
    {
        // initialise instance variables
        this.name = name;
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
    
    /**
     * Returns the name (basic description) of an item
     * 
     * @return  The name of the item
     */
    public String getName()
    {
        return name;
    }
}
