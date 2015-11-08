import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.09
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> items;        //stores items of this room
    private HashMap<String, NPC> NPCs;          // stores characters of this room
    private boolean locked;
    private Random random;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>();
        NPCs = new HashMap<String, NPC>();
        random = new Random();
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    public void removeAllExits()
    {
        exits.clear();
    }
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /**
     * Sets the short description of the room
     * @param The new description of the room
     */
    public void setShortDescription(String newDescription)
    {
        this.description = newDescription;
    }
    
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + "\n" + getItemList() + "\n" + getNPCList();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
   
    /**
     * Adds an item into the room.
     * 
     * @param description the shorthand description of the item
     * @param item the item being added.
     */
    public void addItem(String description, Item item) 
    {
        items.put(description, item);
    }
    
    /**
     * Adds an item into the room.
     * 
     * @param description the shorthand description of the item
     * @return Non-null value if the item exists
     */
    public boolean hasItem(String description) 
    {
        return items.containsKey(description);
    }
    
    /**
     * Removes an item from the room.
     * 
     * @param description the shorthand description of the item
     * @return the item being removed.
     */
    public Item removeItem(String description) 
    {
        Item temp = items.get(description);
        items.remove(description);
        return temp;
    }
    
    /**
     * Adds an NPC to the room
     * 
     * @param name  The name of the character to be added
     * @param character  The character being added
     */
    public void addNPC(String name, NPC character)
    {
        NPCs.put(name, character);
    }
    
    /**
     * Checks to see if the named NPC is in the current room
     * 
     * @param name  The name of the character to be searched for
     * @return True if the room contains the desired NPC, false otherwise
     */
    public boolean hasNPC(String name)
    {
        return NPCs.containsKey(name);
    }
    
    /**
     * Removes an NPC from the room
     * 
     * @param name  The name of the character to be removed
     */
    public void removeNPC(String name)
    {
        NPCs.remove(name);
    }
   
    /**
     * Does nothing unless this is a bus
     */
    public void refreshExit()
    {
        //Do nothing
    }
    
    /**
     * Prints the items within the room.
     * 
     * @return String of items in the room
     */
    public String getItemList() 
    {
        String returnString = "Nearby items:";
        Set<String> keys = items.keySet();
        for(String item : keys) {
            returnString += " " + item;
        }
        return returnString;
    }
    
    /**
     * Lists any NPCs that are in the room
     * 
     * @return String of any characters in the room
     */
    public String getNPCList()
    {
        String returnString = "Characters:";
        Set<String> keys = NPCs.keySet();
        for(String character : keys) {
            if(returnString.equals("Characters:")) {
                returnString += " " + character;
            }
            else {
                returnString += ", " + character;
            }
        }
        return returnString;
    }
    
    /**
     * Returns the NPC object associated with the given name
     * 
     * @param name  The name of the character
     * @return The NPC object associated with the name
     */
    public NPC getNPC(String name)
    {
        return NPCs.get(name);
    }
    
    public void moveNPCs()
    {
        String[] adjoiningRooms = exits.keySet().toArray(new String[exits.size()]);
        Set<String> keys = NPCs.keySet();
        for(String character : keys) {
            getExit(adjoiningRooms[random.nextInt(adjoiningRooms.length)]).addNPC(character, NPCs.get(character));
        }
        NPCs.clear();
    }
    
    /**
     * Determines if the room is locked
     * 
     * @return boolean  Returns true if the room is locked, false otherwise
     */
    public boolean isLocked()
    {
        return locked;
    }
    
    /**
     * Unlocks a locked room
     */
    public void unlockRoom()
    {
        locked = false;
    }
    
    /**
     * Locks a room
     */
    public void lockRoom()
    {
        locked = true;
    }
}

