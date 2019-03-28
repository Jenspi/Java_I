import java.util.Scanner;
public class AdventureGame
{
	public static void main(String[] args)
	{
		int NUMBER_OF_ROOMS = 11;
		int NORTH = 0;
		int SOUTH = 1;
		int EAST = 2;
		int WEST = 3;
		int WALL = -1;
		boolean QUIT = false;
		//Start in room 1; room 0 is a bedroom
		int currentRoom = 1;
		//Room titles + exits:
		String[] room = new String[NUMBER_OF_ROOMS];
		room[0] = "\n[JONAS' ROOM]: exit is north.";
		room[1] = "\n[FRONT HALL]: exits are north and east.";
		room[2] = "\n[PARENTS' ROOM]: exits are north and west.";
		room[3] = "\n[JAMES' ROOM]: exit is north.";
		room[4] = "\n[KITCHEN]: exits are north and south";
		room[5] = "\n[PARENTS' BATHROOM]: exit is south.";
		room[6] = "\n[SECOND HALL]: exits are north, south, east, and west.";
		room[7] = "\n[HALL BATHROOM]: exit is east.";
		room[8] = "\n[DINING ROOM]: exits are south and west.";
		room[9] = "\n[LIVING ROOM]: exits are south and east.";
		room[10] = "\n[JENNY'S ROOM]: exits is south.";
		//Room descriptions:
		String[] roomInfo = new String[NUMBER_OF_ROOMS];
		roomInfo[0] = "This is my younger brother Jonas' room! Jonas likes to keep his lights off and rely on the light from his PC monitor to light up the room. His light went out a couple years ago and he won't let anyone in to change it.";
		roomInfo[1] = "Welcome to the front hall! There are pictures of the family from different periods of time, even James' ex girlfriend. James had two kids with her so we kinda can't take them down at this point.";
		roomInfo[2] = "Here is my mom and dad's room, a.k.a. the place everyone gathers to talk about random crap for hours at a time. There's window AC in here, so it's always negative two degrees.";
		roomInfo[3] = "This is James' room. I lived in this room before him, and way before that it was a garage. It's basically the size of my parents' room if not bigger. The attic door always scared me and the shade on my lamp melted from me sleeping with the light on so I wouldn't be attacked by attic demons.. so I downsized.";
		roomInfo[4] = "Here is the kitchen.. Long story short, the walls are painted yellow and the floor is white and blue. Just throw the whole kitchen away.";
		roomInfo[5] = "This is my parents' bathroom area. It's probably the same amount of square feet as my room alone. Back in the MySpace days, my parents kept our family PC in here. That should give you an idea of how big it is. (The bathroom itself has a door, so it's a little weird but not that weird)";
		roomInfo[6] = "This is the second hallway! This hallway merges with the front hall and has a big clock in in. I don't even know where it came from and my niece opens the door and presses her face against it all the time.";
		roomInfo[7] = "Here is \"the hall bath\". This bathroom has been pale blue, lime green, etc. but is now a boring tan color. You can tell my parents let us pick the colors growing up.";
		roomInfo[8] = "This is the dining room. James' current girlfriend is a mega talented artist, so there's artwork all over the walls. We have a kitchen table that doesn't get used by anyone except me + my niece and nephew.";
		roomInfo[9] = "This is the living room. One time we had a nice entertainment center with glass cabinets, but Jonas was messing with my grandma's motorized wheelchair and drove straight into it.";
		roomInfo[10] = "Here is my room! This was my room a long time ago (I've lived in every room except my parents'), then it was my grandma's, then I moved back in. All of my walls except one are grey, and the last one is purple. My grandma loved purple so I figured I'd keep one to remember her, but not all of them since the carpet and curtains are purple as well and it looked weird.";
		//Since there are 4 directions (NSEW), assign each direction to a room; -1 is a wall.
		int[][] roomExit = {{6,-1,-1,-1},//room 0
							{9,-1,2,-1},//room 1
							{5,-1,-1,1},//room 2
							{4,-1,-1,-1},//room 3
							{8,3,-1,-1},//room 4
							{-1,2,-1,-1},//room 5
							{10,0,1,7},//room 6
							{-1,-1,6,-1},//room 7
							{-1,4,-1,9},//room 8
							{-1,6,8,-1},//room 9
							{-1,6,-1,-1}};//room 10

		//Print out current room title + exit(s), and prompt user for input
		System.out.println(room[currentRoom]);
		System.out.println("Where to next?\nEnter \"n\", \"s\", \"e\", \"w\", \"q\" to quit, or \"i\" for info on the room!");
		//While the user has not quit:
		while(QUIT==false)
		{
			Scanner input = new Scanner(System.in);
			String userChoice = input.next();
			//Convert user input to lowercase so that it's compatible with corresponding String
			userChoice = userChoice.toLowerCase();
			String north = "n", south = "s", east = "e", west = "w", quit = "q", info = "i";
			int prospectiveRoom;

			//If user input is "i"
			if(userChoice.equals(info))
			{
				//Print info for current room
				System.out.println(roomInfo[currentRoom]);
			}
				else if(userChoice.equals(quit))
				{
					System.out.println("Cya!");
					QUIT = true;
				}
				else if(userChoice.equals(north))
				{
					//If user's chosen exit is -1
					if(roomExit[currentRoom][NORTH] == WALL)
					{
						System.out.println("Ouch! There's a wall there!");
					}
					else
					{
						//Assign successful exit value to prospectiveRoom variable
						prospectiveRoom = roomExit[currentRoom][NORTH];
						//Assign prospectiveRoom value to currentRoom variable
						currentRoom = prospectiveRoom;
						System.out.println(room[currentRoom]);
					}
				}
				else if(userChoice.equals(south))
				{
					if(roomExit[currentRoom][SOUTH] == WALL)
					{
						System.out.println("Ouch! There's a wall there!");
					}
					else
					{
						prospectiveRoom = roomExit[currentRoom][SOUTH];
						currentRoom = prospectiveRoom;
						System.out.println(room[currentRoom]);
					}
				}
				else if(userChoice.equals(east))
				{
					if(roomExit[currentRoom][EAST] == WALL)
					{
						System.out.println("Ouch! There's a wall there!");
					}
					else
					{
						prospectiveRoom = roomExit[currentRoom][EAST];
						currentRoom = prospectiveRoom;
						System.out.println(room[currentRoom]);
					}
				}
				else if(userChoice.equals(west))
				{
					if(roomExit[currentRoom][WEST] == WALL)
					{
						System.out.println("Ouch! There's a wall there!");
					}
					else
					{
						prospectiveRoom = roomExit[currentRoom][WEST];
						currentRoom = prospectiveRoom;
						System.out.println(room[currentRoom]);
					}
				}
			//If user input is invalid:
			else
			{
				System.out.println("↝ Enter \"n\", \"s\", \"e\", \"w\", \"q\" to quit, or \"i\" for info on the room!");
			}
		}//end while loop
	}//end main
}//end class