/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.09
 */

import java.util.*;
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Timer timer;
    private Scanner keyboard;
    private boolean matrix;
    /**
     * Create the game and initialise its internal map.
     */
    
    public Game(boolean matrix) 
    {
        this.matrix = matrix;
        createRooms();
        parser = new Parser();
        player = new Player();
        timer = new Timer(1);
        keyboard = new Scanner(System.in);
        
        play();
    }
    
    public static void main(String[] args) {
        new Game(false);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        ArrayList<Room> roomList = new ArrayList<Room>();
        
        Room cityCenter, northSecond, southSecond, eastMain, westMain, apartmentBuilding, playerApartment, friendApartment,
        bar, groceryStore, groceryCheckoutLine, groceryStockRoom, carDealer, collegeCampus, collegeLibrary, collegeClassroom,
        collegeComputer, inTheMatrix, beltway, postOffice, cityHall, policeStation, jailCell, park, airport,
        bank, bankRestroom, bankVault, restaurant, petStore, bus;

        Item key, newspaper, wallet, someItem;
        
        key = new Item("A key. Wonder what it unlocks?",1);
        newspaper = new Item("A newspaper.",1);
        wallet = new Item("A wallet.",2);
        someItem = new Item("asdf",1);

        
        // create the rooms
        cityCenter = new Room("in the city center, at the intersection of Main and Second");
        cityCenter.addItem("key",key);
        cityCenter.addItem("newspaper",newspaper);
        northSecond = new Room("on North Second Avenue");
        southSecond = new Room("on South Second Avenue");
        eastMain = new Room ("on East Main Street");
        westMain = new Room("on West Main Street");
        apartmentBuilding = new Room ("in your apartment building");
        playerApartment = new Room ("in your apartment");
        friendApartment = new Room("in your friend's apartment");
        bar = new Room("at Cody's Bar and Grille");
        groceryStore = new Room ("at Melvin's Grocery");
        groceryCheckoutLine = new Room ("at the checkout line in Melvin's grocery");
        groceryStockRoom = new Room ("in the stock room at Melvin's grocery");
        carDealer = new Room ("at Crazy Chaz's Used Autos");
        collegeCampus = new Room ("at Zuul State University");
        collegeLibrary = new Room("at Zuul State University's Library");
        collegeClassroom = new Room("in a classroom at Zuul State U");
        collegeComputer = new Room("sitting at a Computer");
        inTheMatrix = new Room("in a room surrounded by screens, all of which show you");
        beltway = new Room("On the I-990 Beltway");
        postOffice = new Room("at the Zuul County Post Office");
        cityHall = new Room("at Zuul-7 City Hall");
        policeStation = new Room("at the Zuul-7 Police Station");
        jailCell = new Room("in a jail cell. Good thing you could post bail!");
        park = new Room("at the park");
        airport = new Room("at the Zuul-7 International Airport");
        bank = new Room("at the bank");
        bankRestroom = new Room("in the bank restroom");
        bankVault = new Room("in the bank vault. Sirens blare outside - you must have tripped an alarm!");
        restaurant = new Room("at Charles Edgar Cheddar Fine Dining");
        petStore = new Room("at the pet store");
        bus = new Bus("on the bus", roomList);
        
        //add rooms to roomList
        roomList.add(cityCenter);   
        roomList.add(northSecond);
        roomList.add(southSecond);
        roomList.add(eastMain);
        roomList.add(westMain);
        roomList.add(apartmentBuilding);
        //roomList.add(playerApartment);
        //roomList.add(friendApartment);
        roomList.add(bar);
        roomList.add(groceryStore);
        //roomList.add(groceryCheckoutLine);
        //roomList.add(groceryStockRoom);
        roomList.add(carDealer);
        roomList.add(collegeCampus);
        //roomList.add(collegeLibrary);
        //roomList.add(collegeClassroom);
        //roomList.add(inTheMatrix);
        //roomList.add(beltway);
        roomList.add(postOffice);
        roomList.add(cityHall);
        roomList.add(policeStation);
        //roomList.add(jailCell);
        roomList.add(park);
        roomList.add(airport);
        roomList.add(bank);
        //roomList.add(bankRestroom);
        //roomList.add(bankVault);
        roomList.add(restaurant);
        roomList.add(petStore);
        roomList.add(bus);
        //set exits - note that jailCell and inTheMatrix are not hooked up yet, as the only way to get into them will be event-driven
        //city center exits
        cityCenter.setExit("north", northSecond);
        cityCenter.setExit("south", southSecond);
        cityCenter.setExit("east", eastMain);
        cityCenter.setExit("west", westMain);
        cityCenter.setExit("grocery", groceryStore);
        cityCenter.setExit("bank", bank);
        //west main exits
        westMain.setExit("apartments", apartmentBuilding);
        westMain.setExit("east", cityCenter);
        westMain.setExit("bar", bar);
        westMain.setExit("grocery", groceryStore);
        westMain.setExit("beltway", beltway);
        //south second exits
        southSecond.setExit("carlot", carDealer);
        southSecond.setExit("north", cityCenter);
        southSecond.setExit("college", collegeCampus);
        southSecond.setExit("bus", bus);
        southSecond.setExit("beltway", beltway);
        //east main exits
        eastMain.setExit("west", cityCenter);
        eastMain.setExit("postoffice", postOffice);
        eastMain.setExit("cityhall", cityHall);
        eastMain.setExit("policestation", policeStation);
        eastMain.setExit("bank", bank);
        eastMain.setExit("beltway", beltway);
        //north second exits
        northSecond.setExit("bank", bank);
        northSecond.setExit("south", cityCenter);
        northSecond.setExit("petstore", petStore);
        northSecond.setExit("restaurant", restaurant);
        northSecond.setExit("beltway", beltway);
        //beltway exits
        beltway.setExit("westmain", westMain);
        beltway.setExit("northsecond", northSecond);
        beltway.setExit("eastmain", eastMain);
        beltway.setExit("southsecond", southSecond);
        beltway.setExit("airport", airport);
        beltway.setExit("park", park);
        //apartment building exits
        apartmentBuilding.setExit("street", westMain);
        apartmentBuilding.setExit("yourapartment", playerApartment);
        apartmentBuilding.setExit("friend'sapartment", friendApartment);
        //your apartment exit
        playerApartment.setExit("lobby", apartmentBuilding);
        //friend's apartment exit
        friendApartment.setExit("lobby", apartmentBuilding);
        //bar exit
        bar.setExit("street", westMain);
        //grocery exit
        groceryStore.setExit("north", westMain);
        groceryStore.setExit("east", southSecond);
        groceryStore.setExit("checkoutline", groceryCheckoutLine);
        groceryStore.setExit("stockroom", groceryStockRoom);
        groceryStore.setExit("citycenter", cityCenter);
        //checkout line exit
        groceryCheckoutLine.setExit("citycenter", cityCenter);
        groceryCheckoutLine.setExit("north", westMain);
        groceryCheckoutLine.setExit("east", southSecond);
        groceryCheckoutLine.setExit("salesfloor", groceryStore);
        //stock room exit
        groceryStockRoom.setExit("salesfloor", groceryStore);
        //car dealer exits
        carDealer.setExit("street", southSecond);
        //college exits
        collegeCampus.setExit("street", southSecond);
        collegeCampus.setExit("library", collegeLibrary);
        collegeCampus.setExit("classroom", collegeClassroom);
        //college library exits
        collegeLibrary.setExit("campus", collegeCampus);
        //college classroom exits
        collegeClassroom.setExit("campus", collegeCampus);
        if(matrix == false)
            collegeClassroom.setExit("computer", collegeComputer);
        else {
            collegeClassroom.setExit("matrix", inTheMatrix);
            inTheMatrix.setExit("classroom", collegeClassroom);
        }
        //college computer exit
        collegeComputer.setExit("classroom", collegeClassroom);
        //post office exits
        postOffice.setExit("street", eastMain);
        //city hall exits
        cityHall.setExit("street", eastMain);
        //police station exits
        policeStation.setExit("street", eastMain);
        //park exits
        park.setExit("bus", beltway);
        //airport exits
        airport.setExit("beltway", beltway);
        //bank exits
        bank.setExit("citycenter", cityCenter);
        bank.setExit("west", northSecond);
        bank.setExit("south", eastMain);
        bank.setExit("restroom", bankRestroom);
        bank.setExit("vault", bankVault);
        //bank restroom exit
        bankRestroom.setExit("lobby", bank);
        //bank vault exit
        bankVault.setExit("jail", jailCell);
        //pet store exits
        petStore.setExit("street", northSecond);
        //restaurant exits
        restaurant.setExit("street", northSecond);
        //jail cell exits
        jailCell.setExit("station", policeStation);
        bus.setExit("ride", bus);
        
        bankVault.lockRoom();  // locks the bank vault
        
        currentRoom = cityCenter;  // start game at city center
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to The World of Zuul-7!");
        System.out.println("The World of Zuul-7 is a new, not terribly interesting adventure game.");
        System.out.println("Type 'help' if you need help.");
        if(matrix)
            System.out.println("This all seems familiar...");
        System.out.println();
        
        printInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Try another command.");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
                
            case BACK:
                goBack();
                break;
                
            case USE:
                useItem(command);
                break;
                
            case TAKE:
                takeItem(command);
                break;
                
            case EXAMINE:
                examineItem(command);
                break;
                
            case DROP:
                dropItem(command);
                break;
                
            case LOOK:
                look();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Welcome to Zuul-7! The best dimension of Zuul around.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    /**
     * Print where the player is and what items he has.
     */
    private void printInfo() 
    {
        System.out.println();
        if(matrix)
            System.out.println("You are currently playing a game on Zuul-7's classroom's computer. It reads: ");
        System.out.println("You are " + currentRoom.getShortDescription());
        System.out.println(player.getItemList());
    }
    
    /** 
     * Try to go back a room if possible.
     */
    private void goBack() 
    {
        // Try to leave current room.
        Room nextRoom = player.getPreviousRoom();

        if (nextRoom == null || currentRoom.getShortDescription().equals("in a jail cell")) { //semi-crude way of checking in jail, needs refactoring
            System.out.println("There is nothing to go back to.");
        }
        else {
            player.setPreviousRoom(currentRoom);
            currentRoom = nextRoom;
            //advance timer
            timer.advanceTime();
            printInfo();
        }
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        //Making the back command more robust, can use either 'back' or 'go back'
        if(direction.equalsIgnoreCase("back")) {
            goBack();
            return;
        }
        
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("That is not a direction you can go.");
        }
        else if(nextRoom.isLocked()) {
            System.out.println("That room is locked. Maybe you need to find a key?");
        }
        else {
            player.setPreviousRoom(currentRoom);
            currentRoom = nextRoom;
            timer.advanceTime();
            
            //hooks up the bus
            currentRoom.refreshExit();
            //recursion anyone?
            if(currentRoom.getShortDescription().equals("sitting at a Computer") && (matrix == false)) {
                System.out.println("You sit down at the computer. Do you want to play a game? (Y/N)");
                String answer = keyboard.nextLine();
                if(answer.equalsIgnoreCase("Y"))
                    new Game(true);
            }
  
            printInfo();
                 
        }
    }
    
    /** 
     * Try to take an item. If there is an item, add item to players inventory. 
     * Otherwise print an error.
     */
    private void takeItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item to take...
            System.out.println("Take what?");
            return;
        }

        String itemToTake = command.getSecondWord();

        if(currentRoom.hasItem(itemToTake)) {
            
            //add to inventory 
            player.addItem(itemToTake, currentRoom.removeItem(itemToTake));
            
            System.out.println("You take the " + itemToTake + " and place it in your inventory.");
            //System.out.println(currentRoom.getLongDescription());
            printInfo();
        }
        else {
            System.out.println("There is no such item to take.");
        }
    }
    
    /** 
     * Try to drop an item into the room if the player has it.
     * Otherwise print an error.
     */
    private void dropItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item to take...
            System.out.println("Drop what?");
            return;
        }

        String itemToDrop = command.getSecondWord();

        if(player.hasItem(itemToDrop)) {      
            //add to room
            currentRoom.addItem(itemToDrop, player.removeItem(itemToDrop));
            System.out.println("You drop the " + itemToDrop + ".");  
            
            //System.out.println(currentRoom.getLongDescription());
            printInfo();
        }
        else {
            System.out.println("There is no such item to drop.");
        }
        
    }
    
    /** 
     * Try to use an item. Returns errors if no/invalid item used. 
     */
    private void useItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item to take...
            System.out.println("Use what?");
            return;
        }

        String itemToUse = command.getSecondWord();

        if(player.hasItem(itemToUse)) {      
            System.out.println("You use the " + itemToUse + "...");
            
            if(itemToUse.equalsIgnoreCase("Key") && currentRoom.getShortDescription().equals("at the bank")) {
                if(currentRoom.getExit("vault").isLocked()) {
                    System.out.println("You unlocked the vault. This seems risky...");
                    currentRoom.getExit("vault").unlockRoom();
                    player.removeItem(itemToUse);
                }
                else {
                    System.out.println("You already unlocked the vault");
                }
            }
            else if(itemToUse.equalsIgnoreCase("Beamer")) { //Add else-ifs for any new item. Kinda ugly?
                
            }
            else
                System.out.println("...nothing interesting happens.");
            
            printInfo();
        }
        else {
            System.out.println("There is no such item to use.");
        }  
    }
    
    /** 
     * Try to examine an item. Returns errors if no/invalid item used. 
     */
    private void examineItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item to take...
            System.out.println("Examine what?");
            return;
        }

        String itemToExamine = command.getSecondWord();

        if(player.hasItem(itemToExamine)) {      
            System.out.println("You examine the " + itemToExamine + ".");
            String examine = player.getItemDetails(itemToExamine);
            System.out.println(examine);
            printInfo();
        }
        else {
            System.out.println("There is no such item to examine.");
        }  
    }

    /**
     * Prints the long description of a room, including exits, items, and NPCs.
     * Also prints the player's inventory.
     */
    private void look()
    {
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println(player.getItemList());
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
