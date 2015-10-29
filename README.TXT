Project: zuul-with-enums-v1
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Fifth edition
   David J. Barnes and Michael Kölling
   Pearson Education, 2012
   
This project is a simple framework for an adventure game. In this version,
it has a few rooms and the ability for a player to walk between these rooms.
That's all.

To start this application, create an instance of class "Game" and call its
"play" method.

This project was written to illustrate the use of enums to support
language independence of the game logic.

Read chapter 7 of the book to get a detailed description of the project.


TO DO: 
Add 30 rooms (done)
Add 13 features
add the look command to your game (p 216)
add another command, ie eat with a simple text response (p 216)
6.20/6.21 (p 221) - add items to your game. Each room can have one item in it. Items have description and weight. When printing room info, Item should be included
6.22 (p 221)- make it multiple items
6.23, 6.26 (p 222) - implement the back command (either back one or back many
6.28-6.33  (p 226) -add a Player that can carry one or more objects according to the options presented
Add time Limit
Implement trapdoor
Add a beamer - a beamer is a device that can be charged and fired. When uoi fire the beamer, it transports you immediately back to the room it was charged in.
Add locked doors to your game. The player needs to find (or otherwise obtain) a key to open a door.
Add a transporter room. Whenever the player enters this room, he/she is randomly transported into one of the other rooms.
In the processComand method in Game, there is a switch statement (or a sequence of if statements) to dispatch commands when a command word is recognized. This is not a very nice design, because every time we add a command, we have to add a case here. Can you improve this design? Design the classes so the handling of commands is more modular and new commands can be added more easily. Implement it. Test it.
Add characters to the game. Characters are similar to items, but they can talk. They speak some text when you first meet them, and they may give you some help if you give them the right item.
Add moving characters. These are like other characters, but every time the player types a command, these characters can move into an adjoining room.
