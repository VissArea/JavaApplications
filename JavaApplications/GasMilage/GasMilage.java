//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//GasMilage.java
//Uses the Scanner class to read
//numerical input data.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.Scanner;
public class GasMilage{
  //Let's calculate fuel efficiency based on data that the user inputs
  public static void main(String[] args) {
    int miles;
    double gallons, mpg;
    Scanner sc = new Scanner(System.in);

    System.out.print("\nEnter number of miles: ");
    miles = sc.nextInt();
    System.out.print("\nEnter gallons of fuel used: ");
    gallons = sc.nextDouble();
    mpg = miles / gallons;
    System.out.println("Miles per Gallon: " + mpg);
  }
}
