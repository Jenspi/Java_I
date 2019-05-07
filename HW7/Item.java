public class Item{

	private String name;
	private String action;
	private String itemDescription;
	private boolean stopsPlayer;
	private String choice;
	private String use;

	public Item(String name, String action, String description, boolean stopsPlayer)
	{
		this.name = name;
		this.action = action;
		this.itemDescription = description;
		this.stopsPlayer = stopsPlayer;
	}

	public Item(String itemDescription, boolean stopsPlayer)
	{
		this.itemDescription = itemDescription;
		this.stopsPlayer = stopsPlayer;
	}

	public void setUse(String use)
	{
		this.use = use;
	}

	public String getUse()
	{
		return this.use;
	}

	public String getUse(Item item)
	{
		return this.use;
	}

	public String getDesc(Item item)
	{
		return this.itemDescription;
	}

	public String getChoice()
	{
		return this.choice;
	}

	public String getName()
	{
		return this.name;
	}

	public String getAction()
	{
		return this.action;
	}

	public boolean stop()
	{
		return this.stopsPlayer;
	}

	public String toString()
	{
		//return item's description
		return String.format("%s", this.itemDescription);
	}
}