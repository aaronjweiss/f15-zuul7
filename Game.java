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

public class Game 
{
    private Parser parser;
    private Room currentRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room cityCenter, northSecond, southSecond, eastMain, westMain, apartmentBuilding, playerApartment, friendApartment,
        bar, groceryStore, groceryCheckoutLine, groceryStockRoom, carDealer, collegeCampus, collegeLibrary, collegeClassroom,
        inTheMatrix, beltway, postOffice, cityHall, policeStation, jailCell, park, airport,
        bank, bankRestroom, bankVault, restaurant, petStore;
        

        Item key, newspaper, wallet, someItem;
        
        key = new Item("A key. Wonder what it unlocks?",1);
        newspaper = new Item("A newspaper.",1);
        wallet = new Item("A wallet.",2);
        someItem = new Item("asdf",1);

        
        // create the rooms
        cityCenter = new Room("in the city center, at the intersecetion of Main and Second");
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
        collegeCampus = new Room ("at Bland State University");
        collegeLibrary = new Room("at Bland State University's Library");
        collegeClassroom = new Room("in a classroom at Bland State U");
        inTheMatrix = new Room("in a room surrounded by screens, all of which show you.");
        beltway = new Room("On the I-990 Beltway");
        postOffice = new Room("at the Post Office");
        cityHall = new Room("at City Hall");
        policeStation = new Room("at the Police Station");
        jailCell = new Room("in a jail cell");
        park = new Room("at the park");
        airport = new Room("at the airport");
        bank = new Room("at the bank");
        bankRestroom = new Room("in the bank restroom");
        bankVault = new Room("in the bank vault");
        restaurant = new Room("at Charles Edgar Cheddar Fine Dining");
        petStore = new Room("at the pet store");
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
        //south second exits
        southSecond.setExit("carlot", carDealer);
        southSecond.setExit("north", cityCenter);
        southSecond.setExit("college", collegeCampus);
        //east main exits
        eastMain.setExit("west", cityCenter);
        eastMain.setExit("postoffice", postOffice);
        eastMain.setExit("cityhall", cityHall);
        eastMain.setExit("policestation", policeStation);
        eastMain.setExit("bank", bank);
        //north second exits
        northSecond.setExit("bank", bank);
        northSecond.setExit("south", cityCenter);
        northSecond.setExit("petstore", petStore);
        northSecond.setExit("restaurant", restaurant);
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
        //post office exits
        postOffice.setExit("street", eastMain);
        //city hall exits
        cityHall.setExit("street", eastMain);
        //police station exits
        policeStation.setExit("street", eastMain);
        //park exits
        park.setExit("beltway", beltway);
        //airport exits
        airport.setExit("beltway", beltway);
        //bank exits
        bank.setExit("city center", cityCenter);
        bank.setExit("west", northSecond);
        bank.setExit("south", eastMain);
        bank.setExit("restroom", bankRestroom);
        bank.setExit("vault", bankVault);
        //bank restroom exit
        bankRestroom.setExit("lobby", bank);
        //bank vault exit
        bankVault.setExit("lobby",bank);
        //pet store exits
        petStore.setExit("street", northSecond);
        //restaurant exits
        restaurant.setExit("street", northSecond);
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
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
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
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
                
            case TAKE:
                takeItem(command);
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
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
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

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
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

        // Try to leave current room.
        

        if(currentRoom.hasItem(itemToTake)) {
            currentRoom.removeItem(itemToTake);
            //add to inventory 
            
            
            System.out.println("You remove the " + itemToTake + " and place it in your inventory.");
            System.out.println(currentRoom.getLongDescription());
        }
        else {
            System.out.println("There is no item!");
        }
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
