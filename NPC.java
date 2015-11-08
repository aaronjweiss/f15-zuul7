
/**
 * Class NPC - handles non-player characters within the game
 * 
 * Each NPC object has a name and a greeting, and they may also have an item to be
 * given to the player.
 * 
 * @author Randy Mitchell
 * @version 1.0.0
 */
public class NPC
{
    private String name;
    private String greeting;
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
     * Constructor for NPCs with a greeting, a name, and an item
     * 
     * @param name  The name of the character
     * @param greeting  The greeting to be delivered to the player upon interaction
     * @param item  An item that the NPC can give to the player
     */
    public NPC(String name, String greeting, Item item)
    {
        this.name = name;
        this.greeting = greeting;
        this.item = item;
    }
    
    /**
     * Returns the NPC's greeting
     * 
     * @return The NPC's greeting
     */
    public String getGreeting()
    {
        return greeting;
    }
    
    /**
     * Returns the NPC's name
     * 
     * @return The NPC's name
     */
    public String getName()
    {
        return name;
    }
}
