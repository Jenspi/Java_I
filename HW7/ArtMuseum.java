import java.util.Scanner;
import java.util.ArrayList;
public class ArtMuseum{

	private static Museum artMuseum = new Museum();
	protected static Room currentRoom = artMuseum.getRoom0();
	private static final String tip = "\n[Tip] n/s/e/w to change rooms, \"Win\" to use window, 1/2/3/4 etc. for using items in inventory, and \"q\" to quit.\n";
	private static final String invalid = "\nWe can't go that way!"+tip;
	private static boolean quit = false;
	private static String input;
	private static final String YES = "yes";
	private static final String NO = "no";
	protected static ArrayList<String> inventoryList = new ArrayList<String>();
	protected static int inventoryCount;
	protected static Inventory inventory = new Inventory();
	public static final String SLOW = "\u001B[5m";
	public static final String NON_FORMATTED = "\033[0m";

	public static void main(String[] args)
	{
		//Welcome the user, print out current room and exits, and print what letters to use to move
		//used \n a lot to make the message the only thing visible when ran in a small terminal window
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n.｡*ﾟ+.*.｡　Welcome!　ﾟ+..｡*ﾟ+\n" +currentRoom.toString());
		
		while(quit!=true)
		{
			Scanner userInput = new Scanner(System.in);
			if(currentRoom.hasItem() && currentRoom.getItem() != null)
			{
				System.out.println(currentRoom.getItem().toString());
			}

			input = userInput.next();
			input = input.toLowerCase();
			executeDirection(currentRoom, input);

			//if the room has an enemy, print their dialogue and determine whether or not they stop the player
			if(currentRoom.hasEnemy() == true)
			{
				System.out.println(currentRoom.getEnemy().toString());
				if(currentRoom.getEnemy().getItem().stop() != false)
				{
					quit = true;
				}
				//take enemy out of room to prevent user crossing paths with them in the same room again
				currentRoom.ridEnemy();
			}
		}
	}//end main

	public static void pickupItem()
	{
		//if the room has no item:
		if(currentRoom.hasItem() != true || currentRoom.getItem() == null)
		{
			System.out.println("No item to pick up!");
		}
		else
		{
			//add to inevtory
			inventory.addToInventory();
			//add to inventory list displayed to user
			String item = currentRoom.getItem().getName();
			inventoryCount++;
			inventoryList.add("\n	"+item);

			System.out.println(ArtMuseum.currentRoom.getExits()+ArtMuseum.currentRoom.getInventory());
			System.out.println(SLOW + "✔ " + NON_FORMATTED + ArtMuseum.currentRoom.getItem().getName()+" added to inventory!");

			//remove item from room
			currentRoom.removeItem();
		}
	}

	//method that I ran out of time to make into a simpler method:
	public static void useItem(String choice)
	{
		if(inventory.getSize() > 0)
		{
		switch(choice)
		{
			case "1":
			//if more than 1 element
			if(inventory.getSize() > 0)
			{
				//one = 1st element
				Item one = inventory.getIndex(0);
				System.out.println("\n"+one.getUse());
				//if item stops player
				if(one.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					//remove item from inventory and print room info
					inventoryList.remove("\n	"+one.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "2":
			if(inventory.getSize() > 1)
			{
				Item two = inventory.getIndex(1);
				System.out.println("\n"+two.getUse());
				if(two.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+two.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "3": 		
			if(inventory.getSize() > 2)
			{	
				Item three = inventory.getIndex(2);
				System.out.println("\n"+three.getUse());
				if(three.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+three.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "4": 			
			if(inventory.getSize() > 3)
			{
				Item four = inventory.getIndex(3);
				System.out.println("\n"+four.getUse());
				if(four.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+four.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "5": 			
			if(inventory.getSize() > 4)
			{
				Item five = inventory.getIndex(4);
				System.out.println("\n"+five.getUse());
				if(five.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+five.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "6": 			
			if(inventory.getSize() > 5)
			{
				Item six = inventory.getIndex(5);
				System.out.println("\n"+six.getUse());
				if(six.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+six.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "7": 			
			if(inventory.getSize() > 6)
			{
				Item seven = inventory.getIndex(6);
				System.out.println("\n"+seven.getUse());
				if(seven.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+seven.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "8": 			
			if(inventory.getSize() > 7)
			{
				Item eight = inventory.getIndex(7);
				System.out.println("\n"+eight.getUse());
				if(eight.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+eight.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "9":
			if(inventory.getSize() > 8)
			{
				Item nine = inventory.getIndex(8);
				System.out.println("\n"+nine.getUse());
				if(nine.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+nine.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			case "10":
			if(inventory.getSize() > 9)
			{
				Item ten = inventory.getIndex(9);
				System.out.println("\n"+ten.getUse());
				if(ten.stop() == true)
				{
					quit = true;
					System.out.println("You've been caught!");
				}
				else
				{
					inventoryList.remove("\n	"+ten.getName());
					inventory.removeIndex(0);
					System.out.println(currentRoom.toString());
				}
			}
			else
			{
				System.out.println("No items to use!"+tip);
			}
			break;
			default: System.out.println("No items to use!");
			break;
		}
		}
		else
		{
			System.out.println("No items to use!");
		}

	}

	public static void executeDirection(Room current, String choice)
	{
		//choices for moving:
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
		if(choice.equals("win"))
		{
			if(currentRoom.getWindow() != null)
			{
				currentRoom = current.getWindow();
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
		//if user wants to add to inv
		if(choice.equals("add"))
		{
			if(currentRoom.hasItem())
			{
				pickupItem();
			}
			else
			{
				System.out.println("No items to add!");
			}
		}
		//choices for inventory:
		if(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8") || choice.equals("9") || choice.equals("10"))
		{
			useItem(choice);
		}
		//if no valid choices made:
		if(!( choice.equals("n") || choice.equals("s") || choice.equals("e") || choice.equals("w") || choice.equals("win") || choice.equals("q") || choice.equals("add") || choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8") || choice.equals("9") || choice.equals("10") ) )
		{
			System.out.println(invalid);
		}
	}//end executeDirection method
}//end class