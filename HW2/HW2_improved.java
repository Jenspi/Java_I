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
    System.out.print(ANSI.ANSI_RESET);
    wrapper(cpu_guess);

    while(guessedCorrectly==false){
        userInput = input.nextInt();
        if(userInput < 1 || userInput > 3){
          System.out.printf("%s", ANSI.ANSI_RESET);
          System.out.println("Sorry, here are your only options:\n1 = Correct, 2 = higher, 3 = lower. Try again.");
        }
        else{
          if(userInput == correct)
          {
            guessedCorrectly = true;
            if(tries==1){
              winning_try = " try";
            }
            System.out.printf("%s", ANSI.ANSI_RESET);
            System.out.printf("Sweet, I got it in %d%s!", tries, winning_try,ANSI.ANSI_RESET);
          }
          else{
            cpu_guess = midpoint(userInput, cpu_guess);
            System.out.print(ANSI.ANSI_RESET);
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
      if(cpu_guess==100){
        System.out.printf("%s", ANSI.ANSI_RESET);
        System.out.println("Can't go higher than 100! Try again...");
        return cpu_guess;
      }
      //Find the midway point between lowest possible number and highest possible number and store it in new cpu_guess:
      lower += (upper-lower)/2;
      cpu_guess = lower+(upper-lower)/2;
    }
    else if(userInt==goLower){
      if(cpu_guess==1){
        System.out.printf("%s", ANSI.ANSI_RESET);
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
    System.out.print(ANSI.ANSI_RESET);
    System.out.println(ANSI.ANSI_CLEAR);
    System.out.printf("                        %s________________________________________________%s       \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_RESET);
    System.out.printf("                       %s%s/                                                \\%s       \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|    %s_________________________________________%s     |%s        \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_WHITE, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s                                         %s|    |%s         \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  Pick a number in your head.            %s%s|    |%s              \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  I will guess it,                       %s%s|    |%s              \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  and you give me a number:              %s%s|    |%s                \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s                                         %s%s|    |%s             \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  1 = CORRECT                            %s%s|    |%s                \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  2 = GO HIGHER                          %s%s|    |%s                  \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  3 = GO LOWER                           %s%s|    |%s                 \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s                                         %s%s|    |%s             \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  My guess is... %s%d%s%s%s|    |%s                   \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_MAGENTA, cpu_guess, " ".repeat(spaces), ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s                                         %s%s|    |%s                 \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s  C:\\> %s%s_%s%s                                 %s%s|    |%s              \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_GREEN, ANSI.ANSI_BG_BLACK, ANSI.ANSI_BOLD, ANSI.ANSI_BLINK, ANSI.ANSI_NOT_BOLD, ANSI.ANSI_NOT_BLINK, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s                                         %s%s|    |%s                   \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s                                         %s%s|    |%s                  \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s                                         %s%s|    |%s                   \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_GREEN, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|   |%s%s_________________________________________%s%s|    |%s                   \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_BG_BLACK, ANSI.ANSI_WHITE, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s|                                                  |%s                   \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                      %s%s\\_________________________________________________/%s             \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                              %s%s\\___________________________________/%s                 \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                           %s___________________________________________%s                  \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_RESET);
    System.out.printf("                        %s%s_-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_%s                  \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                     %s%s_-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_%s              \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("                  %s%s_-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_%s               \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("               %s%s_-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_%s                \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("            %s%s_-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_%s              \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("           %s%s:-------------------------------------------------------------------------:%s             \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);
    System.out.printf("           %s%s`---._.-------------------------------------------------------------._.---'%s           \n", ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_BG_WHITE, ANSI.ANSI_RESET);   
    System.out.printf("                                 %s%sASCII Credit: Roland Hangg%s              \n", ANSI.ANSI_ITALIC, ANSI.ANSI_BRIGHT_GREY, ANSI.ANSI_RESET);
    System.out.printf("%s%s%sC:\\> ", ANSI.ANSI_BOLD, ANSI.ANSI_GREEN, ANSI.ANSI_BG_BLACK);
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