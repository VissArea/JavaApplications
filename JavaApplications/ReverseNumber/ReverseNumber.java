//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Viss
//ReverseNumber.java
//Demonstrates the use of a Do loop
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

import java.util.Scanner;
public class ReverseNumber{
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Reverses the digits of an integer
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    int num, lastDigit, reverse = 0;

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter in a positive integer: ");
    num = sc.nextInt();

    do{
      lastDigit = num % 10;
      reverse = lastDigit + (reverse * 10);
      num = num / 10;
    }
    while( num > 0 );

    System.out.println("The number you entered reversed is: " + reverse);
  }
}
