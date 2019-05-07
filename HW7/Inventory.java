import java.util.ArrayList;

public class Inventory{
	
	private int slots;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	private static int inventoryCount;

	public Inventory()
	{
		this.inventoryCount = 0;
	}

	public void addToInventory()
	{
		inventory.add(ArtMuseum.currentRoom.getItem());
		this.inventoryCount++;
	}

	public void removeFromInventory(Item item)
	{
		inventory.remove(item);
		this.inventoryCount--;
		System.out.println(item.getName()+" removed from inventory!");
	}

	public Item getIndex(int index)
	{
		return inventory.get(index);
	}

	public int getSize()
	{
		return inventory.size();
	}

	public void removeIndex(int index)
	{
		inventory.remove(index);
	}
}//end class