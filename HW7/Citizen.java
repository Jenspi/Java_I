public class Citizen extends Enemy{
	private static String[] randomName = {"Billy", "Sara", "Alex", "James", "Samantha", "Logan", "Daniel", "Steve Henson, inventor of ranch dressing"};
	String name;
	Item item;
	String itemDescription;
	boolean stopsPlayer;

	public Citizen()
	{
		this.name = randomName[(int) (Math.random() * 8)];
		this.item = null;
		this.itemDescription = null;
	}

	public void setEnemyItem(Item item, String description, boolean stopsPlayer)
	{
		this.item = item;
		this.itemDescription = description;
		this.stopsPlayer = stopsPlayer;
	}

	public void setEnemyItem(Item item)
	{
		this.item = item;
	}

	public Item getItem(){
		return this.item;
	}

	public String getItemDesc(){
		return this.itemDescription;
	}

	@Override
	public String toString()
	{
		//create random visitor dialogue
		System.out.println("> A stranger approaches you!");
		String[] dialogue = {"%s: I can tell you're up to no good! I've got my eye on you.\n%s%s", "%s: My parents own this place, I better not catch you bein' shady or you're outta here..\n%s%s", "%s: ...", "%s: What you lookin' at?", "%s: Ain't you one of them people on the \"not allowed board\"?"};
		return String.format(dialogue[(int) (Math.random() * 5)], this.name, this.name, getItemDesc());
	}
}