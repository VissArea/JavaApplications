//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Viss
//GradeReport.java
//Demonstrates the use of a Switch
//Statement.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

import java.util.Scanner;
public class GradeReport{
  public static void main(String[] args) {
    int grade, category;
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter your numeric grade (0-100): ");
    grade = sc.nextInt();

    category = grade / 10;
    System.out.print("That grade is ");

    switch(category){
      case 10:
      System.out.println("a perfect score. Well done!");
      break;
      case 9:
      System.out.println("well above average. Excellent.");
      break;
      case 8:
      System.out.println("above average. Good job.");
      break;
      case 7:
      System.out.println("average.");
      break;
      case 6:
      System.out.println("below average, please see the instructor.");
      break;
      default:
      System.out.println("not passing.");
    }
  }
}
