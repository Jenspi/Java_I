public abstract class Character{

	private String name;

	//##############// getters & setters //##############//
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public abstract String toString();
}