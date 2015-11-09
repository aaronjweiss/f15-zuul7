import java.util.Set;
import java.util.HashMap;


/**
 * Write a description of class Player here.
 * 
 * @author Aaron Weiss
 * @version 2015.11.08
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
     * Sets the previous room the player was in.
     * 
     * @param room the Room the player was last in.
     */
    public void setPreviousRoom(Room previousRoom) 
    {
        this.previousRoom = previousRoom;
    }
    
    /**
     * Gets the previous room the player was in.
     * 
     * @return the room the player was last in.
     */
    public Room getPreviousRoom() 
    {
        return previousRoom;
    }

    /**
     * Adds an item into the players inventory.
     * 
     * @param description the shorthand description of the item
     * @param item the item being added.
     */
    public void addItem(String description, Item item) 
    {
        inventory.put(description, item);
    }
    
    /**
     * Returns true if player has the item in question.
     * 
     * @param description the shorthand description of the item
     * @return boolean whether the palyer has the item.
     */
    public boolean hasItem(String description) 
    {
        return inventory.containsKey(description);
    }
    
    /**
     * Removes an item from the players inventory and returns it if exists.
     * 
     * @param description the shorthand description of the item
     * @return the item being removed.
     */
    public Item removeItem(String description) 
    {
        Item temp = inventory.get(description);
        inventory.remove(description);
        return temp;
    }
    
    /**
     * Prints the items within the inventory.
     * 
     * @return String of items in the inventory
     */
    public String getItemList() 
    {
        String returnString = "Inventory:";
        Set<String> keys = inventory.keySet();
        for(String item : keys) {
            returnString += " " + item;
        }
        return returnString;
    }
    
    /**
     * Prints an item's description and weight.
     * 
     * @param item string name of item
     * @return String of description and weight
     */
    public String getItemDetails(String itemName) 
    {        
        Item item = inventory.get(itemName);
        String returnString = "Item: " + itemName + 
        "\nDescription: " + item.getDescription() + "\nWeight: " + item.getWeight();
        return returnString;
    }
}
