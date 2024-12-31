import java.util.Scanner;
// Also using ANSI class in same directory :)

public class HW2_improved{

  //Initialize int variables to represent lowest and highest possible numbers (bounds)
  public static int lower = 0, upper = 100;
  public static int correct = 1, goHigher = 2, goLower = 3;

  public static void main(String args[]){
    boolean guessedCorrectly = false;
    int tries = 1;
    int cpu_guess = 50;//initial cpu guess
    int userInput;
    Scanner input = new Scanner(System.in);
    String winning_try = " tries";

    System.out.println(ANSI.ANSI_CLEAR);
    wrapper(cpu_guess);

    while(guessedCorrectly==false){
        userInput = input.nextInt();
        if(userInput < 1 || userInput > 3){
          System.out.println("Sorry, here are your only options:\n1 = Correct, 2 = higher, 3 = lower. Try again.");
        }
        else{
          if(userInput == correct)
          {
            guessedCorrectly = true;
            if(tries==1){
              winning_try = " try";
            }
            System.out.println("Sweet, I got it in " + tries + winning_try + "!");
          }
          else{
            cpu_guess = midpoint(userInput, cpu_guess);
            wrapper(cpu_guess);
          }
            tries++;
        }
      }
  }//end main

  private static int midpoint(int userInt, int cpu_guess){
    int goHigher = 2, goLower = 3;

    if(userInt==goHigher)//Use variables here so that an int == another int
    {
      if(cpu_guess>=100){
        System.out.println("Can't go higher than 100! Try again...");
        return cpu_guess;
      }
      //Find the midway point between lowest possible number and highest possible number and store it in new cpu_guess:
      lower += (upper-lower)/2;
      cpu_guess = lower+(upper-lower)/2;
    }
    else if(userInt==goLower){
      if(cpu_guess<=1){
        System.out.println("Can't go lower than 1! Try again...");
        return cpu_guess;
      }
      upper -= (upper-lower)/2; 
      cpu_guess = lower+(upper-lower)/2;
    }

    return cpu_guess;
  }//end midpoint()

  private static void wrapper(int cpu_guess){
    int spaces = 24 - (int) (Math.log10(cpu_guess) + 1);
    System.out.println(ANSI.ANSI_CLEAR);
    System.out.println("                        ________________________________________________       ");
    System.out.println("                       /                                                \\       ");
    System.out.println("                      |    _________________________________________     |        ");
    System.out.println("                      |   |                                         |    |         ");
    System.out.println("                      |   |  Pick a number in your head.            |    |              ");
    System.out.println("                      |   |  I will guess it,                       |    |              ");
    System.out.println("                      |   |  and you give me a number:              |    |                ");
    System.out.println("                      |   |                                         |    |             ");
    System.out.println("                      |   |  1 = CORRECT                            |    |                ");
    System.out.println("                      |   |  2 = GO HIGHER                          |    |                  ");
    System.out.println("                      |   |  3 = GO LOWER                           |    |                 ");
    System.out.println("                      |   |                                         |    |             ");
    System.out.printf("                      |   |  My guess is... %d%s|    |                   \n", cpu_guess, " ".repeat(spaces));
    System.out.println("                      |   |                                         |    |                 ");
    System.out.println("                      |   |  C:\\> _                                 |    |              ");
    System.out.println("                      |   |                                         |    |                   ");
    System.out.println("                      |   |                                         |    |                  ");
    System.out.println("                      |   |                                         |    |                   ");
    System.out.println("                      |   |_________________________________________|    |                   ");
    System.out.println("                      |                                                  |                   ");
    System.out.println("                      \\_________________________________________________/             ");
    System.out.println("                              \\___________________________________/                 ");
    System.out.println("                           ___________________________________________                  ");
    System.out.println("                        _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_                  ");
    System.out.println("                     _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_              ");
    System.out.println("                  _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_               ");
    System.out.println("               _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_                ");
    System.out.println("            _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_              ");
    System.out.println("           :-------------------------------------------------------------------------:             ");
    System.out.println("           `---._.-------------------------------------------------------------._.---'           ");   
    System.out.println("                                 ASCII Credit: Roland Hangg              ");
    System.out.print("C:\\> _ ");
  }//end wrapper()

  // private static void smallPC(){
  //  System.out.println("                         ______                         ");
  //  System.out.println(" _________        .---\"\"\"      \"\"\"---.            ");
  //  System.out.println(":______.-':      :  .--------------.  :                 ");
  //  System.out.println("| ______  |      | :                : |                 ");
  //  System.out.println("|:______B:|      | |  Little Error: | |                 ");
  //  System.out.println("|:______B:|      | |                | |                 ");
  //  System.out.println("|:______B:|      | |  Power not     | |                 ");
  //  System.out.println("|         |      | |  found.        | |                 ");
  //  System.out.println("|:_____:  |      | |                | |                 ");
  //  System.out.println("|    ==   |      | :                : |                 ");
  //  System.out.println("|       O |      :  '--------------'  :                 ");
  //  System.out.println("|       o |      :'---...______...---'                  ");
  //  System.out.println("|       o |-._.-i___/'             \\._                 ");
  //  System.out.println("|'-.____o_|   '-.   '-...______...-'  `-._              ");
  //  System.out.println(":_________:      `.____________________   `-.___.-.     ");
  //  System.out.println("                 .'.eeeeeeeeeeeeeeeeee.'.      :___:    ");
  //  System.out.println("    fsc        .'.eeeeeeeeeeeeeeeeeeeeee.'.             ");
  //  System.out.println("              :____________________________:            ");
  // }
}//end class