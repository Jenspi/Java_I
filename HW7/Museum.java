public class Museum
{
	private Room lobby, cafeteria, shop, paint, courtyard, mosaic, textile, statue, pottery, current;

	public Museum(){
		Citizen enemy = new Citizen();
		Citizen kid = new Citizen();
		Citizen elder = new Citizen();
		Citizen teen = new Citizen();
		Citizen mother = new Citizen();
		Citizen father = new Citizen();
		Citizen son = new Citizen();
		Citizen daughter = new Citizen();
		Citizen nephew = new Citizen();


		Item meanWords = new Item("goes on to make mean comments at you.. Someone's in a bad mood!", false);
		Item banana = new Item("throws a banana peel at your feet!", true);
		Item foot = new Item("trips you! You get back up!", false);
		Item spit = new Item("spits on you! How gross..", false);
		Item taser = new Item("tases you! This person is crazy!", true);
		Item cane = new Item("hits you in the back with their cane. You walk away.", false);
		Item bag = new Item("tries hitting you in the head with their bag, but misses.", false);
		Item fists = new Item("tries to throw hands! A small, stupid child is no match for you.", false);
		Item art = new Item("smashes a pot over your head.. I think we could've taken steps before that.", true);

		enemy.setEnemyItem(banana, " throws a banana peel at your feet!", true);
		kid.setEnemyItem(fists, " tries to throw hands! A small, stupid child is no match for you.", false);
		elder.setEnemyItem(cane, " hits you in the back with their cane. You walk away.", false);
		teen.setEnemyItem(art, " smashes a pot over your head.. I think we could've taken steps before that.", true);
		mother.setEnemyItem(bag, " tries hitting you in the head with their bag, but misses.", false);
		father.setEnemyItem(taser, " tases you! This person is crazy!", true);
		son.setEnemyItem(spit, " spits on you! How gross..", false);
		daughter.setEnemyItem(meanWords, " goes on to make mean comments at you.. Someone's in a bad mood!", false);
		nephew.setEnemyItem(foot, " trips you! You get back up!", false);


		//ROOM ITEMS:
		Item broom = new Item("Broom","take broom","A broom sits in the corner of the room.", false);
		Item pamphlet = new Item("Pamphlet","take coupon","You see a pamphlet with a free $5 coupon for Chipotle printed on it.", true);
		Item chipotle = new Item("Burrito Bowl","buy chipotle","You buy a veggie burrito bowl from Chipotle with your $5 coupon.", false);
		Item candy = new Item("Taffy","steal Taffy","Salt Water Taffy:\n1/2 lb ($5.89)\n1 lb ($10.69)", false);
		Item marker = new Item("Marker","Draw on painting","A marker falls to the floor out of a lady's purse", false);
		Item chessboard = new Item("Chess pieces","play chess","Chess pieces sit on a chess table.", false);
		Item fabric = new Item("Expensive Fabric","steal textiles","these textiles are worth a fortune!", false);
		Item statues = new Item("Statue","knock over statues","statues are lined up like dominos..", false);
		Item pots = new Item("Pot","throw pots","Link smashes his pots on the ground", false);

		//set use
		broom.setUse("You use a broom to smash the stained glass!");
		pamphlet.setUse("You find a coupon inside for Chipotle!");
		chipotle.setUse("You use your coupon that you found in the lobby's pamphlet on a burrito bowl!");
		candy.setUse("You put the taffy straight into your pocket and walk to the front of the store!");
		marker.setUse("You vandalize the art!");
		chessboard.setUse("You throw the chess pieces into the air!");
		fabric.setUse("You steal the unguarded textiles!");
		statues.setUse("You knock over the statues like dominos!");
		pots.setUse("You smash the pots Link style!");

		//instantiate rooms
		Room lobby = new Room("Lobby", "↝ You're in the lobby. There are shelves holding brochures for local attractions and restaurants.", pamphlet, kid);
		Room cafeteria = new Room("Cafeteria", "↝ You come across the cafeteria. Luckily, the creator of the museum is vegetarian and has plenty of options for those like herself, a.k.a. Chipotle and Taco Bell.", chipotle, daughter);
		Room shop = new Room("Gift Shop", "↝ You enter the gift shop! Everything is overpriced here and the only fools that give into buying things are tourists and parents.", marker, father);
		Room paint = new Room("Van Gogh Hall", "↝ Named after famous painter Vincent Van Gogh, this room is dedicated to various different paintings by multiple different artists. An open window shows a glimpse into the courtyard.", candy, mother);
		Room courtyard = new Room("Courtyard", "↝ You enter the courtyard! A giant tree is centered in the middle, giving shade to about 80% of the yard. There are chess boards, a bird fountain, as well as tables and benches to eat at or socialize.", chessboard, enemy);
		Room mosaic = new Room("Isidora Paz López Hall", "↝ Isidora Paz López is a small mosaic artist. This room is only full of mosaics made by Isidora, which are usually mosaics of wildlife or nature. An open window shows a glimpse into the courtyard", broom, son);
		Room textile = new Room("Mary White Hall", "↝ This textile-themed room is named after Mary White, known for her iconic, nature-inspired textile prints. Rumor has it this used to be an empty room with stairway to a creepy basement. I bet they hid someone's body in there.", fabric, nephew);
		Room statue = new Room("Landowski Hall", "↝ Landowski hall is named after some french guy who sculpted a 98ft tall statue of Jesus Christ or something. I don't know, I didn't know the guy.\nThis room contains a few statues. There's another window that lets you view the courtyard.", statues, elder);
		Room pottery = new Room("Lee Hall", "↝ This is a pottery room named after Yun Hee Lee, a talented ceramic artist. This room is full of ceramics of all types and time periods. Don't knock over the pots.", pots, teen);

		//set room exits: (north, south, east, west, window)
		lobby.setExits(null, paint, cafeteria, null, null);
		cafeteria.setExits(null, courtyard, shop, lobby, null);
		shop.setExits(null, mosaic, null, cafeteria, null);
		paint.setExits(lobby, textile, null, null, courtyard);
		courtyard.setExits(cafeteria, null, null, null, null);
		mosaic.setExits(shop, pottery, null, null, courtyard);
		textile.setExits(paint, null, statue, null, null);
		statue.setExits(null, null, pottery, textile, courtyard);
		pottery.setExits(mosaic, null, null, statue, null);

		//set starting room
		this.current = lobby;
	}//end constructor

	public Room getRoom0(){
		return this.current;
	}//end getter
}//end class