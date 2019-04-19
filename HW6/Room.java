import java.util.ArrayList;

public class Room{

	//declare variables for Room objects
	private String description;
	private String name;
	private Room north;
	private Room south;
	private Room east;
	private Room west;

	public Room(String name, String description)
	{
		//instantiate variables (sets exits to null by default)
		this.name = name;
		this.description = description;
	}

	public void setExits(Room n, Room s, Room e, Room w){
		this.north = n;
		this.south = s;
		this.east = e;
		this.west = w;
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

	public String getDescription(){
		return this.description;
	}//end getDescription

	public String getName(){
		return this.name;
	}//end getName

	public String getExits(){
		//create an arraylist to store exits
		ArrayList<String> exits = new ArrayList<String>();
		//if north exit is not null/courtyard, add exit to list; we dont want courtyard to show on the list since the only possible north exit into courtyard is via window (same with south and east)
		if(getNorth() != null && getNorth().getName() != "Courtyard")
		{
			exits.add("\n	North → "+getNorth().getName());
		}
		//no south exits into courtyard via window
		if(getSouth() != null)
		{
			exits.add("\n	South → "+getSouth().getName());
		}
		if(getEast() != null && getEast().getName() != "Courtyard")
		{
			exits.add("\n	East → "+getEast().getName());
		}
		if(getWest() != null && getWest().getName() != "Courtyard")
		{
			exits.add("\n	West → "+getWest().getName());
		}
		//display exits
		return String.format("	»»————- EXITS ————-««%s\n", exits).replace("[","").replace("]", "").replace(",","");
	}//end getExits

	public String toString(){
		//return the room's description and exits
		return String.format("\n%s\n%s", this.description, getExits());
	}//end toString method
}