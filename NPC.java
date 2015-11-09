
/**
 * Class NPC - handles non-player characters within the game
 * 
 * Each NPC object has a name and a greeting, and they may also have an item to be
 * given to the player and a special greeting to go with that item.
 * 
 * @author Randy Mitchell
 * @version 2015.11.08
 */
public class NPC
{
    private String name;
    private String greeting;
    private String itemGreeting;
    private Item item;

    /**
     * Constructor for NPCs with only a greeting and a name
     * 
     * @param name  The name of the character
     * @param greeting  The greeting to be delivered to the player upon interaction
     */
    public NPC(String name, String greeting)
    {
        this.name = name;
        this.greeting = greeting;
    }

    /**
     * Constructor for NPCs with a greeting, a name, an item,
     * and a specialized greeting to display when giving an item to the player 
     * 
     * @param name  The name of the character
     * @param greeting  The greeting to be delivered to the player upon interaction
     * @param item  An item that the NPC can give to the player
     * @param itemGreeting  The greeting to be given when the character has an item for the player
     */
    public NPC(String name, String greeting, Item item, String itemGreeting)
    {
        this.name = name;
        this.greeting = greeting;
        this.item = item;
        this.itemGreeting = itemGreeting;
    }
    
    /**
     * Returns the NPC's greeting
     * 
     * @return  The NPC's greeting
     */
    public String getGreeting()
    {
        return greeting;
    }
    
    /**
     * Returns the NPC's name
     * 
     * @return  The NPC's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the NPC's original greeting, assuming the NPC has an item
     * 
     * @return  The NPC's original greeting if he/she has an item
     */
    public String getItemGreeting()
    {
        return itemGreeting;
    }
    
    /**
     * Determines if the NPC currently has an item
     * 
     * @return  True if the NPC has an item, false otherwise
     */
    public boolean hasItem()
    {
        if(item != null)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns the name of the item held by the NPC
     * 
     * @return  The name of the NPC's item
     */
    public String getItemName()
    {
        return item.getName();
    }
    
    /**
     * Returns the item held by the NPC, and also erases the item from the NPC's "inventory"
     * 
     * @return  The item to be returned
     */
    public Item transferItem()
    {
        Item tempItem = item;
        item = null;
        return tempItem;
    }
}
