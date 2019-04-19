public class Museum
{
	private Room lobby, cafeteria, shop, paint, courtyard, mosaic, empty, statue, pottery, current;

	public Museum(){
		//instantiate rooms
		Room lobby = new Room("Lobby", "↝ You're in the lobby. There are shelves holding brochures for local attractions and restaurants. You've already paid for your ticket to be here, there's no need to hangout in this room any longer.");
		Room cafeteria = new Room("Cafeteria", "↝ You come across the cafeteria. Luckily, the creator of the museum is vegetarian and has plenty of options for those like herself, a.k.a. Chipotle and Taco Bell.");
		Room shop = new Room("Gift Shop", "↝ You enter the gift shop! Everything is overpriced here and the only fools that give into buying things are tourists and parents.");
		Room paint = new Room("Van Gogh Hall", "↝ Named after famous painter Vincent Van Gogh, this room is dedicated to various different paintings by multiple different artists. An open window shows a glimpse into the courtyard.");
		Room courtyard = new Room("Courtyard", "↝ You enter the courtyard! A giant tree is centered in the middle, giving shade to about 80% of the yard. There are chess boards, a bird fountain, as well as tables and benches to eat at or socialize.");
		Room mosaic = new Room("Isidora Paz López Hall", "↝ Isidora Paz López is a small mosaic artist. This room is only full of mosaics made by Isidora, which are usually mosaics of wildlife or nature. An open window shows a glimpse into the courtyard");
		Room empty = new Room("Empty Room", "↝ This room is empty! There's a door in the corner of the room that says \'Personnel Only\", let's not go that way.");
		Room statue = new Room("Landowski Hall", "↝ Landowski hall is named after some french guy who sculpted a 98ft tall statue of Jesus Christ or something. I don't know, I didn't know the guy.\nThis room contains a few statues. There's another window that lets you view the courtyard.");
		Room pottery = new Room("Lee Hall", "↝ This is a pottery room named after Yun Hee Lee, a talented ceramic artist. This room is full of ceramics of all types and time periods.");
		Room basement = new Room("Personnel-Only","↝ Agh, this only lead to a dark and flooded basement!");

		//set room exits
		lobby.setExits(null, paint, cafeteria, null);
		cafeteria.setExits(null, courtyard, shop, lobby);
		shop.setExits(null, mosaic, null, cafeteria);
		paint.setExits(lobby, empty, courtyard, null);
		//set south, east, and west exits to null to create one-way exits through windows
		courtyard.setExits(cafeteria, null, null, null);
		mosaic.setExits(shop, pottery, null, courtyard);
		empty.setExits(paint, basement, statue, null);
		statue.setExits(courtyard, null, pottery, empty);
		pottery.setExits(mosaic, null, null, statue);
		basement.setExits(empty, null, null, null);

		//set starting room
		this.current = lobby;
	}//end constructor

	public Room getRoom0(){
		return this.current;
	}//end getter
}//end class