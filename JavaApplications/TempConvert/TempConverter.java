//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Viss
//TempConverter.java
//Demonstrates the use of primitive
//data types and expressions to
//convert temperatures.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.*;
public class TempConverter{
  //Computes farenheit temperatures given a celsius temperature
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int BASE = 32;
    final double CONVERSTION_FORMULA = 9.0 / 5.0;


    double fahrenheitTemp;
    System.out.print("\n\nCelcius temperature to convert: ");
    int celsiusTemp = sc.nextInt();

    fahrenheitTemp = (celsiusTemp * CONVERSTION_FORMULA) + BASE;
    System.out.println("fahrenheit Equivalent: " + fahrenheitTemp + " degrees\n");

  }
}
