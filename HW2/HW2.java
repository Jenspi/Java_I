import java.util.Scanner;
  public class HW2
  {
    public static void main(String args[])
    {
      //Initialize int variable to represent lowest possible number
      int lower = 0;
      //Initialize int variable to represent highest possible number
      int upper = 100;
      boolean correctGuess = false;
      int tries = 0;
      int guess;
      int userInput;
      Scanner input = new Scanner(System.in);
      int correct = 1; //Initialize variables for each possible user input
      int goHigher = 2;
      int goLower = 3;

      System.out.println("Choose a number 1-100");

      guess = 50;
      tries++;

      //Print first guess
      System.out.println("My guess is: "+guess);
      System.out.println("Enter 1 if this was a correct guess, 2 if your number is higher, and 3 if your number is lower:\n");

      while(correctGuess==false)
       {
          userInput = input.nextInt();
          if(userInput==goHigher)//Use variables here so that an int == another int
          {
            //Find the midway point between lowest possible number and highest possible number and store it in new guess:
            lower += (upper-lower)/2;
            guess = lower+(upper-lower)/2;
            System.out.println(guess);
            System.out.println("Enter 1 if this was a correct guess, 2 if your number is higher, and 3 if your number is lower:\n");
          }
          else if(userInput==goLower)
          {
            upper -= (upper-lower)/2;  
            guess = lower+(upper-lower)/2;
            System.out.println(guess);
            System.out.println("Enter 1 if this was a correct guess, 2 if your number is higher, and 3 if your number is lower:\n");
          }
          else if(userInput == correct)
          {
            correctGuess = true;
            System.out.println("I got it in "+tries+" try/tries.");
          }
            tries++;
        }
    }
  }