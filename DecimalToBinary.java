/*Decimal To Binary
 * Stephen Swick
 * 10.24.16
 * MCS 141
 */
import java.util.Scanner;
import java.lang.Math;

public class DecimalToBinary
{
  public static void main (String [] args)
  {
    
    Scanner scan = new Scanner(System.in);
    int runtime = 1;
    int decision = 2;
    String prompt;
    long dec;
    String binary;
    System.out.println("Hello would you like to convert from Binary to Decimal?");
    System.out.println("Or would you like to convert from Decimal to Binary?");
    System.out.println("Type '0' for Binary to Decimal or type '1' for Decimal to Binary");
    while ( decision != 0 && decision != 1)
    {
      while ( !scan.hasNextInt() )
      {
        String garbage = scan.nextLine();
        System.out.println("Not a valid choice");
      }
      decision = scan.nextInt();
      if ( decision != 0 && decision != 1)
      {
        System.out.println("1Not a valid choice");
      }
      String garbage = scan.nextLine();
    }
    if (decision == 0)
    {
      while (runtime == 1)
      {
        prompt = "Please enter a valid binary string (1's and 0's only)";
        binary = getBinary(prompt);
        dec = binaryToDecimal(binary);
        System.out.println("Your binary value is " + dec + " in decimal.");
        System.out.println("Would you like to convert another binary?");
        System.out.println("Type '1' to convert another binary or '0' to exit");
        runtime = 2;
        while ( runtime != 0 && runtime != 1)
        {
          while ( !scan.hasNextInt() )
          {
            String garbage = scan.nextLine();
            System.out.println("Not a valid choice");
          }
          runtime = scan.nextInt();
          
        }
      }
    }
    else
    {
      while (runtime == 1)
      {
        
        dec = -1;
        prompt = "Please enter a positive integer.";
        while (dec < 0)
        {
          dec = getLong(prompt);
        }
        
        binary = decimalToBinary(dec);
        System.out.println("Your decimal value is " + binary + " in binary.");
        System.out.println("Would you like to convert another decimal?");
        System.out.println("Type '1' to convert another decimal or '0' to exit");
        runtime = 2;
        while ( runtime != 0 && runtime != 1)
        {
          while ( !scan.hasNextInt() )
          {
            String garbage = scan.nextLine();
            System.out.println("Not a valid choice");
          }
          runtime = scan.nextInt();
          
        }
        
      }
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
      System.out.println( garbage + " is not a positive integer.");
      System.out.println( prompt );
    }
    input = scan.nextLong();
    return input;
    
  }
  public static String getBinary( String prompt)
  {
    Scanner scan = new Scanner(System.in);
    String input;
    boolean valid = true;
    System.out.println( prompt );
    input = scan.nextLine();
    for (int i = 0; i<input.length(); i++)
    {
      if (input.charAt(i) !='0' && input.charAt(i) != '1')
      {
        valid = false;
      }
    }
    while(!valid)
    {
      valid = true;
      System.out.println("That was not a valid binary number");
      System.out.println( prompt );
      input = scan.nextLine();
      for (int i = 0; i<input.length(); i++)
      {
        if (input.charAt(i) !='0' && input.charAt(i) != '1')
        {
          valid = false;
        }
      }
    }
    return input;
    
    
  }
  public static String decimalToBinary(long dec)
  {
    String binary = "";
    if ( dec == 0)
    {
      binary = "0";
    }
    else
    {
      while ( dec > 0)
      {
        binary = dec%2 + binary;
        dec = dec/2;
      }
    }
    return binary;
  }
  public static long binaryToDecimal(String binary)
  {
    long value = 0;
    for (int i=0; i<binary.length(); i++)
    {
      if (binary.charAt(binary.length()-1-i) == '1')
      {
        value = value + (int)Math.pow(2,i);
      }
    }
    return value;
  }
  
  
}