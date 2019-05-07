public abstract class Enemy extends Character{

	private Item item;

	public Enemy()
	{

	}

	public Item getItem()
	{
		return this.item;
	}

	public abstract String toString();
}