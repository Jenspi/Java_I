import java.util.Scanner;
public class ArtMuseum{

	private static Museum artMuseum = new Museum();
	private static Room currentRoom = artMuseum.getRoom0();
	private static Room prospectiveRoom;
	public static final String tip = "\n[Tip] \"n\" goes North, \"s\" goes South, \"e\" goes East, \"w\" goes West, \"q\" quits.\n";
	private static final String invalid = "\nWe can't go that way!"+tip;
	private static boolean quit = false;
	private static final String mosaicWindow = "Isidora Paz López Hall";
	private static final String statueWindow = "Landowski Hall";
	private static final String paintingWindow = "Van Gogh Hall";

	public static void main(String[] args)
	{
		//Welcome the user, print out current room and exits, and print what letters to use to move
		//used \n a lot to make the message the only thing visible when ran in a small terminal window
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n.｡*ﾟ+.*.｡　Welcome!　ﾟ+..｡*ﾟ+\n..to a totally different art museum than the rest of the existing ones! (Not guaranteed, no money back)\n"+currentRoom.toString()+tip);
		
		while(quit!=true)
		{
			Scanner userInput = new Scanner(System.in);
			String input = userInput.next();
			input = input.toLowerCase();
			//tell executeDirection method where to go
			executeDirection(currentRoom, input);

			//If user is in Van Gogh Hall, Landowski Hall, Isidora Paz López Hall
			if(currentRoom.getName() == mosaicWindow || currentRoom.getName() == paintingWindow || currentRoom.getName() == statueWindow)
			{
				//ask the user if they want to jump out of the window into the courtyard
				System.out.println("Jump through the window? Yes/No\n");
				input = userInput.next();
				input = input.toLowerCase();

				//if user decides to quit
				if(input.equals("q"))
				{
					System.out.println("\nThanks for playing! :)");
					quit = true;
				}

				//if Isidora Paz López Hall and the user chooses to jump through the window
				if(currentRoom.getName() == mosaicWindow && input.equals("yes") || currentRoom.getName() == mosaicWindow && input.equals("w"))
				{
					System.out.println("\nThat was embarrassing...");
					executeDirection(currentRoom, "w");
				}
				//if Van Gogh Hall and the user chooses to jump through the window
				else if(currentRoom.getName() == paintingWindow && input.equals("yes") || currentRoom.getName() == paintingWindow && input.equals("e"))
				{
					System.out.println("\nThat was embarrassing...");
					executeDirection(currentRoom, "e");
				}
				//if Landowski Hall and the user chooses to jump through the window
				else if(currentRoom.getName() == statueWindow && input.equals("yes") || currentRoom.getName() == statueWindow && input.equals("n"))
				{
					System.out.println("\nThat was embarrassing...");
					executeDirection(currentRoom, "n");
				}
				else if(input.equals("no")){
					System.out.println("\nGreat! Where to then?");
				}
				else if(input.equals("n") || input.equals("s") || input.equals("e") || input.equals("w"))
				{
					//if the user chooses to ignore the question or doesn't see it, go to the next room as normal
					executeDirection(currentRoom, input);
				}
				else
				{
					System.out.println(invalid);
				}
			}
		}
	}//end main

	public static void executeDirection(Room current, String choice)
	{
		if(choice.equals("n"))
		{
			//if north exit is a room
			if(current.getNorth() != null)
			{
				//set current room to north exit
				currentRoom = current.getNorth();
				System.out.println(currentRoom.toString());
			}
			else
			{
				//tell the user that their input was invalid
				System.out.println(invalid);
			}
		}
		if(choice.equals("s"))
		{
			if(current.getSouth() != null)
			{
				currentRoom = current.getSouth();
				System.out.println(currentRoom.toString());
			}
			else
			{
				System.out.println(invalid);
			}
		}
		if(choice.equals("e"))
		{
			if(current.getEast() != null)
			{
				currentRoom = current.getEast();
				System.out.println(currentRoom.toString());
			}
			else
			{
				System.out.println(invalid);
			}
		}
		if(choice.equals("w"))
		{
			if(current.getWest() != null)
			{
				currentRoom = current.getWest();
				System.out.println(currentRoom.toString());
			}
			else
			{
				System.out.println(invalid);
			}
		}
		if(choice.equals("q"))
		{
			System.out.println("\nThanks for playing! :)");
			quit = true;
		}
	}//end executeDirection method
}//end class