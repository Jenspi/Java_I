import java.util.ArrayList;

public class Room{

	//declare variables for Room objects
	private String description;
	private String name;
	private Room north;
	private Room south;
	private Room east;
	private Room west;
	private Room window;
	private Item item;
	private static int itemCount;
	private Enemy enemy;

	public Room(String name, String description, Item item, Enemy enemy)
	{
		//instantiate variables (sets exits to null by default)
		this.name = name;
		this.description = description;
		this.item = item;
		this.enemy = enemy;
	}

	public boolean hasItem()
	{
		//if the room has an item, return true
		if(getItem() != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//remove item from room
	public void removeItem()
	{
		this.item = null;
	}

	public Enemy getEnemy()
	{
		return this.enemy;
	}

	public void ridEnemy()
	{
		this.enemy = null;
	}

	public void defeatEnemy()
	{
		this.enemy = null;
		System.out.println("Enemy defeated!");
	}

	public boolean hasEnemy()
	{
		if(getEnemy() != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setExits(Room north, Room south, Room east, Room west, Room window){
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.window = window;
	}//end setExits

	public Room getNorth(){
		return this.north;
	}//end getNorth

	public Room getSouth(){
		return this.south;
	}//end getSouth

	public Room getEast(){
		return this.east;
	}//end getEast

	public Room getWest(){
		return this.west;
	}//end getWest

	public Room getWindow(){
		return this.window;
	}

	public String getDescription(){
		return this.description;
	}//end getDescription

	public Item getItem(){
		return this.item;
	}

	public Item getItem(Item item){
		return this.item;
	}

	public String getName(){
		return this.name;
	}//end getName

	public String getExits(){
		//create an arraylist to store exits
		ArrayList<String> exits = new ArrayList<String>();
		//check for exits
		if(getNorth() != null)
		{
			exits.add("\n	North → "+getNorth().getName());
		}
		if(getSouth() != null)
		{
			exits.add("\n	South → "+getSouth().getName());
		}
		if(getEast() != null)
		{
			exits.add("\n	East → "+getEast().getName());
		}
		if(getWest() != null)
		{
			exits.add("\n	West → "+getWest().getName());
		}
		if(getWindow() != null)
		{
			exits.add("\n	Window → "+getWindow().getName());
		}
		//display exits
		return String.format("\n	»»———— EXITS ————««%s\n", exits).replace("[","").replace("]", "").replace(",","");
	}//end getExits

	public String getInventory()
	{
		ArrayList<String> inventoryList = new ArrayList<String>();
		inventoryList = ArtMuseum.inventoryList;
		if(inventoryList.size() > 0)
		{
			return String.format("\n	»»———— INVENTORY ————««%s\n", inventoryList).replace("[","").replace("]", "").replace(",","");
		}
		else
		{
			return "";
		}
	}

	public String getItems()
	{
		if(hasItem()==true)
		{
			return String.format("\n	»»———— ITEM ————««\n	add → %s\n", item.getName());
		}
		else
		{
			return "";
		}
	}

	public String toString(){
		//return the room's description and exits
		return String.format("\n%s%s%s%s", this.description, getExits(), getItems(), getInventory());
	}//end toString method
}