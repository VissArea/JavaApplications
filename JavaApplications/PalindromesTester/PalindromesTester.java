//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//PalindromesTester.java
//Demonstrates the use of nested while
//loops
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.Scanner;
public class PalindromesTester{
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Tests Strings to see if they are palindromes
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    String str, another = "y";
    int left, right;
    Scanner sc = new Scanner(System.in);

    while( another.equalsIgnoreCase("y")){ //allows y or Y
      System.out.println("Enter potential palindrome: ");
      str = sc.nextLine();

      left = 0;
      right = str.length() - 1;

      while(str.charAt(left) == str.charAt(right) && left < right){
        left++;
        right--;
      }
      System.out.println();
      if(left < right)
        System.out.println("The string is not a palindrome.");
      else
        System.out.println("The string is a palindrome.");
        System.out.println();
        System.out.println("Test another palindrome (Y / N)? ");
        another = sc.nextLine();
    }
  }
}
