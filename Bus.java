/**
 * The bus is a room with a randomized exit
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class Bus extends Room
{
    private ArrayList<Room> roomList;
    private Room nextStop;
    /**
     * Constructor for the Bus
     */
    public Bus(String description, ArrayList<Room> listOfRooms) 
    {
        super(description);
        roomList = listOfRooms;
    }
    
    /**
     * Randomizes the exit the bus will let you off at
     */
    public void refreshExit()
    {
        this.removeAllExits();
        this.setExit("nextstop", this);
        Collections.shuffle(roomList);
        nextStop = roomList.get(0);
        if (nextStop == this){
            nextStop = roomList.get(1);
        }
        this.setShortDescription("on the bus. Getting off will leave you " +
            nextStop.getShortDescription());
        this.setExit("off", nextStop);
    }
}

