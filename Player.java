import java.util.Set;
import java.util.HashMap;


/**
 * Write a description of class Player here.
 * 
 * @author Aaron Weiss
 * @version 1.0.0
 */
public class Player
{
    // instance variables - replace the example below with your own
    private HashMap<String, Item> inventory;
    private Room previousRoom;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        inventory = new HashMap<String, Item>();
    }

    /**
     * Adds an item into the room.
     * 
     * @param description the shorthand description of the item
     * @param item the item being added.
     */
    public void addItem(String description, Item item) 
    {
        inventory.put(description, item);
    }
    
    /**
     * Adds an item into the room.
     * 
     * @param description the shorthand description of the item
     * @return Non-null value if the item exists
     */
    public boolean hasItem(String description) 
    {
        return inventory.containsKey(description);
    }
    
    /**
     * Removes an item from the room.
     * 
     * @param description the shorthand description of the item
     */
    public Item removeItem(String description) 
    {
        Item temp = inventory.get(description);
        inventory.remove(description);
        return temp;
    }
    
    /**
     * Prints the items within the room.
     * 
     * @return String of items in the room
     */
    public String getItemList() 
    {
        String returnString = "Items:";
        Set<String> keys = inventory.keySet();
        for(String item : keys) {
            returnString += " " + item;
        }
        return returnString;
    }
}
