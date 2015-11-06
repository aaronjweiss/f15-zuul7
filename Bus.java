/**
 * The bus is a room with a randomized exit
 * 
 * @author Colin P. Goss 
 * @version 0.0.2
 */

import java.util.*;
public class Bus extends Room
{
    private ArrayList<Room> roomList;
    private Room busStop;
    private boolean removed;
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
        if (roomList.contains(this)){
            removed = roomList.remove(this);
        } //removes itself from the list so that it cannot be chosen
        this.removeAllExits();
        this.setExit("nextstop", this);
        Collections.shuffle(roomList);
        if (busStop == roomList.get(0)){
            busStop = roomList.get(1);
        } else {
            busStop = roomList.get(0);
        }
        this.setShortDescription("on the bus. Getting off will leave you " +
            busStop.getShortDescription());
        this.setExit("off", busStop);
        
        if (removed){
            roomList.add(this);
            removed = false;
        }
    }
}

