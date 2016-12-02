/* Squaring program
 * 10/18/16
 * Stephen Swick
 * MCS 141
 */
import java.util.Scanner;
import java.lang.Math;
public class Squaring
{
  public static void main ( String [] args )
  {
    int count = 0;
    long num = getLong("Please enter a number greater than 1:");
    while ( num <= 1 )
    {
      System.out.println("Your number is not greater than 1!!!");
      num = getLong("Please Enter a number greater than 1:");
    }
    if (num > 1000000)
    {
      System.out.println("Your number already exceeds a million!");
    }
    else
    {
      double prediction = Math.log10(Math.log10((double)1000000)/Math.log10((double)num))/Math.log10((double)2);
      /* Basically what i did to solve for the prediction was form an equation and set it equal to a million
       * i realized the equation would be num^2^x = 1000000
       * solve for x using logs so youre going to need to log twice basically to get x out of the exponent spot
       * and then i used the floor method cause I want a whole number
       * and i need the whole number that will exceed a million so 
       * because i solved the equation with it equaling a million i need the next whole number
       * so for example if i plugged in 2 for num the prediction value will be around 4.3 or something like that
       * so the floor method takes it to 4 and I add 1 to it because I need to square it 5 times to exceed a million
       */
      prediction = Math.floor(prediction)+1;
      System.out.printf("Prediction will be that it will take %.0f squares.\n",prediction);
      while ( num <= 1000000)
      {
        num = num*num;
        count++;
        System.out.println(num);
      }
      System.out.println("It took " + count + " square(s) to exceed 1 million.");
    }
  }
  public static long getLong( String prompt )
  {
    Scanner scan = new Scanner(System.in);
    long input;
    System.out.println( prompt );
    while ( !scan.hasNextLong() )
    {
      String garbage = scan.nextLine();
      System.out.println( garbage + " is not a number.");
      System.out.println( prompt );
    }
    input = scan.nextLong();
    return input;
    
  }
}