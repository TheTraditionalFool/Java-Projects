/* Guessing game
 * Stephen Swick
 * MCS 141
 * 10/9/16
 */
import java.util.Scanner;
import java.util.Random;
public class GuessingGame
{
  public static void main (String [] args)
  {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int count = 0;
    int guess;
    int random = rand.nextInt(20)+1;
    System.out.printf("Please enter a integer between 1-20 (inclusive):\n");
      guess = scan.nextInt();
      count++;
    if ( guess != random)
    {
      System.out.printf("Sorry that is incorrect, try again!\n");
    }
    int difference = Math.abs(guess - random); // the difference between the random number and guess 
    
    while (guess != random)
    {
      System.out.printf("Please enter a integer between 1-20 (inclusive):\n");
      guess = scan.nextInt();
      count++;
      int difference2 = Math.abs(guess - random);
      
      if ( guess != random)
      {
        System.out.printf("Sorry that is incorrect, try again!\n");
      }
      if (difference2 < difference) // if the difference is getting smaller the guess is getting closer
      {
        System.out.printf("You are getting warmer!\n");
        difference = difference2; //I want the closer guess to replace the previous closest guess
      }
      else if (difference2 > difference)
      {
        System.out.printf("You are getting colder!\n");
      }//if the guess is colder I do not want the new difference to replace the old one
      else //if the differences are equal
      {
        System.out.printf("Your new guess is as far away from the number as the old one\n");
      }
        
    }
    System.out.printf("\nYou got it in " + count + " guesses!");
  }
  
}