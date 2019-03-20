import java.util.Scanner;
import java.util.Random;
public class VirtualPet
{
	public static int hunger, thirst, play;
	public static int hungerRate, thirstRate, playRate;
	//Initialize constant variables that represent thresholds.
	public static final int LOW_STAT = 100, MED_STAT = 75, HIGH_STAT = 25, RUNAWAY_STAT = 10;
	public static int age;
	public static String petName;
	//Set ranaway to false, only true when pet has ranaway. (basically: ranaway? No/false, so continue.)
	public static boolean ranaway = false;
	public static String border = "⋆ ˚｡⋆୨୧˚　˚୨୧⋆｡˚ ⋆⋆ ˚｡⋆୨୧˚　˚୨୧⋆｡˚ ⋆";
	public static String border2 = "◇─◇──◇────◇────◇────◇────◇────◇─────◇──◇──◇──◇──◇────◇────◇────◇────◇────◇───◇─◇";
	//Create a variable to store the amount of times played, used mainly for stats in Method 11.
	public static int plays = 0;
	//Create arrays to store pet names and ages for Method 11; set length to 100 since amount of times user will play is unknown and definitely won't play more than 100.
	public static String[] pets = new String[100];
	public static int[] ages = new int[100];

	//Main Method
	public static void main(String[] args)
	{
		game();
	}

	//Method 1
	private static void cat()
	{
		age = 0;
		Scanner input = new Scanner(System.in);
		System.out.println(border2);
		System.out.println("A stray kitten crosses your path and you decide to take it home with you!\nWhat do you want to name it?");
		//Allow user to have name with spaces (e.g. "Juney Poo")
		petName = input.nextLine();
		//Set levels to full(100) and initialize starting rates
		hunger = 100;
		thirst = 100;
		play = 100;
		//Assign rates random number between 10 and 20
		Random rng = new Random();
		hungerRate = 10 + rng.nextInt(20);
		thirstRate = 10 + rng.nextInt(20);
		playRate = 10 + rng.nextInt(20);
	}

	//Method 2
	private static void petAge()
	{
		//Set to first day
		age++;
		System.out.println("\nDay "+age+": Today marks a new day with "+petName+"!");

			//Every second (other) day, the pet gets hungry faster
			if(age%2 == 0)
			{
				hungerRate+=10;
				System.out.println(petName+" gets hungry more often.");
			}

			if(age%3 == 0)
			{
				thirstRate+=10;
				System.out.println(petName+" gets dehydrated faster.");
			}

			if(age%5 == 0)
			{
				playRate+=10;
				System.out.println(petName+" wants attention!!");
			}
	}

	//Method 3
	private static void response()
	{
		Scanner input = new Scanner(System.in);
		//Ask user for input based on desired activity
		System.out.println(border+"\n1.) Feed\n2.) Give water\n3.) Play\n"+border);
		System.out.println("What do you want to do?");
		int interaction = input.nextInt();
		int feed = 1, drink = 2, activity = 3, exit = 404;

		//While input is not 1, 2, 3, or 404, prompt user to input an allowed number.
		while(interaction != 404 && (interaction<1 || interaction>3))
		{
			System.out.println("Enter 1, 2, or 3 (Please)\nor you can enter 404 to terminate the program.");
			interaction = input.nextInt();
		}

		//If user input is 1, feed the pet.
		if(interaction == feed)
		{
			//Use Method 3, submethod 1 to feed pet
			feed();
		}

			else if(interaction == drink)
			{
				hydrate();
			}

			else if(interaction == activity)
			{
				interact();
			}

			else if(interaction == 404)
			{
				System.exit(0);
			}
	}

		//Method 3, submethod 1
		private static void feed()
		{
			//Feed the pet, but make the pet thirsty.
			hunger += hungerRate;
			thirst -= thirstRate;
			System.out.println("↝ You give "+petName+" food. Now they are thirsty!");
		}

		//Method 3, submethod 2
		private static void hydrate()
		{
			thirst += thirstRate;
			play -= playRate;
			System.out.println("↝ You quench "+petName+"'s thirst. Now they are energized and ready to play!");
		}

		//Method 3, submethod 3
		private static void interact()
		{
			play += playRate;
			hunger -= hungerRate;
			System.out.println("↝ You play with "+petName+". Now they are hungry!");
		}

	//Method 4
	private static void feedback()
	{
		//Let the user know how the pet is doing using levels.
		System.out.println(" -------------------------------");
		String hungerDescription = "| Hunger Level: ";
		//Give Method 4, Submethod 1 the current hunger level
		description(hunger);
		//then print out String above + output from Method 4, Submethod 1.
		System.out.println(hungerDescription+description(hunger));

		String thirstDescription = "| Thirst Level: ";
		description(thirst);
		System.out.println(thirstDescription+description(thirst));

		String playDescription = "| Play Level: ";
		description(play);
		System.out.println(playDescription+description(play));
		System.out.println(" -------------------------------");
	}

	//Method 4, submethod 1
	private static String description(int actionLevel)
	{
		String message;
		//If the level is greater than or equal to LOW_STAT (100), the pet has a low chance of running away.
		if(actionLevel>=LOW_STAT)
		{
			message = "Marvelous!";
		}

			else if(actionLevel>=MED_STAT)
			{
				message = "Getting by!";
			}

			else if(actionLevel>=HIGH_STAT)
			{
				message = "Dangerously low!";
			}

		//Otherwise, if level is lower than all stats, the pet is close to escaping.
		else
		{
			message = "Either already DEAD or mega close to it.";
		}
		//return message so that it is usable/accessible in Method 4
		return message;
	}

	//Method 5
	private static void runaway()
	{
		//Check to see if any levels are less than RUNAWAY_STAT (10); The pet is not happy and runs away IF true.
		if(hunger<RUNAWAY_STAT)
		{
			System.out.println("\nYou didn't feed "+petName+" enough! It has escaped to scavenge the streets for food!! :(");
			ranaway = true;

			//Put petName and age into separate arrays at different indexes (first time around, plays = 0 and petname is stored in 0th index)
			pets[plays]= petName;
			ages[plays]=age;
			//Increment plays by 1, so that petName and age are stored in the next index if the user decides to play again.
			plays++;
		}

			else if(thirst<RUNAWAY_STAT)
			{
				System.out.println("\nYou didn't give "+petName+" enough to drink! It is off to find puddles to drink from!! :(");
				ranaway = true;

				pets[plays]= petName;
				ages[plays]=age;
				plays++;
			}

			else if(play<RUNAWAY_STAT)
			{
				System.out.println("\nYou didn't play with "+petName+" enough! It has left to find someone who will give it all of their attention!! :(");
				ranaway = true;

				pets[plays]= petName;
				ages[plays]=age;
				plays++;
			}

		else
		{
			ranaway = false;
		}
	}

	//Method 6
	private static void results()
	{
		//Print out results after game has ended based on how long the user successfully took care of the pet
		if(age<=7)
		{
			System.out.println("You took care of "+petName+" for "+age+" days. Taking care of a pet isn't for everyone. Farewell, "+petName+".");
		}

		if(age>=8 && age<=10)
		{
			System.out.println("You took care of "+petName+" for "+age+" days! That's not totally great, but it would've been worse off had you not found it.");
		}

		if(age>=12 && age<=14)
		{
			System.out.println("Congratulations on lasting "+age+" days with "+petName+"! You are pretty responsible if I do say so myself.");
		}

		if(age>=15)
		{
			System.out.println(age+" days! I'm so proud of you! You would be a fantastic owner in the real world!");
		}

		System.out.println(border2);
	}

	//Method 7
	private static void drawPet()
	{
		//Call methods that draw each part of the pet.
		drawTop();
		//Call method, passing it hunger, thirst, and play values for an appropriate face to be returned
		drawEyes(hunger, thirst, play);
		drawNose();
		drawBottom(hunger, thirst, play);
		return;
	}
		//Method 7, submethod 1
		private static void drawTop()
		{
			//Top (ears) always stays the same, since it is a cat.
			System.out.println();
			System.out.println("     ^^                              ^^");
			System.out.println("    ^  ^                            ^  ^");
			System.out.println("   ^    ^                          ^    ^");
			System.out.println("  ^      ^                        ^      ^");
			System.out.println(" ^        ^                      ^        ^");
			System.out.println("^          ^                    ^          ^");
		}

		//Method 7, submethod 2
		private static void drawEyes(int thirstLevel, int hungerLevel, int playLevel)
		{
			//If any levels are less than 10 (dead)
			if((thirstLevel<=RUNAWAY_STAT || hungerLevel<=RUNAWAY_STAT) || playLevel<=RUNAWAY_STAT)
			{
				System.out.println();
				System.out.println();
				System.out.println("   XX   XX                         XX   XX");
				System.out.println("    XX XX                           XX XX");
				System.out.println("      X                               X");
				System.out.println("    XX XX                           XX XX ");
				System.out.println("   XX   XX                         XX   XX");
			}

				//Else if two of the three levels are bad
				else if(((thirstLevel<LOW_STAT && hungerLevel<LOW_STAT) || (hungerLevel<LOW_STAT && playLevel<LOW_STAT)) || (playLevel<LOW_STAT && thirstLevel<LOW_STAT))//
				{
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println("    ++++++                       ++++++");
					System.out.println("  ++++++++++                   ++++++++++");
					System.out.println();
					System.out.println();
					System.out.println();
				}

				//If levels are less than 25 (sad)
				else if((thirstLevel<=HIGH_STAT || hungerLevel<=HIGH_STAT) || playLevel<=HIGH_STAT)
				{
					System.out.println();
					System.out.println();
					System.out.println("++++      ++++               ++++      ++++");
					System.out.println("  ++++++++++                   ++++++++++");
					System.out.println("     ++++                         ++++");
					System.out.println();
					System.out.println();
				}	

				//If any level is greater than or equal to 100 (happy)
				else if((thirstLevel>=LOW_STAT || hungerLevel>=LOW_STAT) || playLevel>=LOW_STAT)
				{
					System.out.println("                                                         /^  /^");
					System.out.println("                                                        /  ^/  ^");
					System.out.println("                                                       /        ^");
					System.out.println("     ++++                           ++++               ^        /");
					System.out.println("  ++++++++++                     ++++++++++             ^      /");
					System.out.println("++++      ++++                 ++++      ++++            ^    /");
					System.out.println("                                                          ^  /");
					System.out.println("                                                           ^/");
				}
		}

		//Method 7, submethod 3
		private static void drawNose()
		{
			//Nose always stays the same
			System.out.println();
			System.out.println();
			System.out.println("      .  ・ ゜ ゜ ・ _____ ・ ゜ ゜ ・  ．");
			System.out.println("   .  ・  ゜ ゜   ・ YXXX/  ・   ゜ ゜  ・  ．");
			System.out.println("      .  ・  ゜ ゜ ・ YY/  ・ ゜ ゜  ・  ．");
			System.out.println("                       Y");
			System.out.println("                       |");
		}

		//Method 7, submethod 4
		private static void drawBottom(int thirstLevel, int hungerLevel, int playLevel)
		{
			//If any levels are less than 10 (dead)
			if((thirstLevel<=RUNAWAY_STAT || hungerLevel<=RUNAWAY_STAT) || playLevel<=RUNAWAY_STAT)
			{
				System.out.println("                       |");
				System.out.println("         +++++++++++++++++++++++++++");
				System.out.println("                          UUUUUUUUUU");
				System.out.println("                            UUUUUU");
				System.out.println("                              UU");
			}

				//Else if two of the three levels are bad
				else if(((thirstLevel<LOW_STAT && hungerLevel<LOW_STAT) || (hungerLevel<LOW_STAT && playLevel<LOW_STAT)) || (playLevel<LOW_STAT && thirstLevel<LOW_STAT))
				{
					System.out.println("                       |");
					System.out.println("                       |");
					System.out.println("             +++++++++++++++++++++");
					System.out.println("                  +++++++++++");
				}

				//If levels are less than 25 (sad)
				else if((thirstLevel<=HIGH_STAT || hungerLevel<=HIGH_STAT) || playLevel<=HIGH_STAT)//if levels less than 25
				{
					System.out.println("                       |");
					System.out.println("                  +++++++++++");
					System.out.println("             +++++++       +++++++");
					System.out.println("          ++++++               ++++++");
				}

				//If any level is greater than or equal to 100 (happy)
				else if((thirstLevel>=LOW_STAT || hungerLevel>=LOW_STAT) || playLevel>=LOW_STAT)
				{
					System.out.println("                       |");
					System.out.println("          ++++++       |       ++++++");
					System.out.println("             +++++++       +++++++");
					System.out.println("                  +++++++++++");
				}
		}

	//Method 9
	private static void game()
	{
		//Call the pet
		cat();
		//While the game has not ended
		while(ranaway==false)
		{
			petAge();
			response();
			feedback();
			drawPet();
			runaway();
		}
		results();
		replay();
	}

	//Method 10
	private static void replay()
	{
		System.out.println("Would you like to replay? Yes or no:");
		Scanner input = new Scanner(System.in);
		String replay = "yes";
		String exit = "no";
		String smartass = "or";
		
		String answer = input.next();
		answer = answer.toLowerCase();
		if(answer.equals(replay))
		{
			//Set ranaway to false to allow new game to start
			ranaway=false;
			game();
		}

			else if(answer.equals(exit))
			{
				stats();
			}

			//If user tries typing "or"
			else if(answer.equals(smartass))
			{
				System.out.println("How dare you.");
			}
	}

	//Method 11
	private static void stats()
	{
		System.out.println("\n↝ HOW'D YOU DO?");
		System.out.println(" -------------------------------");
		
		//For each play, print out that game's pet name and how many days the pet was kept alive.
		for(int i=0; i<plays; i++)
		{
			System.out.println("| " + pets[i]+ " ♥ " + ages[i] + " days");
		}

		System.out.println(" -------------------------------");
	}
}//end of class