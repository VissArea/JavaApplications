//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Viss
//StringMutation.java
//Makes use of the String class and
//it's methods.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class StringMutation{
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Prints a string along with
  //different mutations of it.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    String original = "\"We're here to put a dent in the universe. Otherwise " +
    "why else even be here?\" \n\t -Steve Jobs\n";
    String mutation1, mutation2, mutation3, mutation4;

    System.out.println("Original String: " + original);
    System.out.println("Length of the String: " + original.length());

    mutation1 = original.concat(" That's what influenced me.\n");
    mutation2 = original.toUpperCase();
    mutation3 = original.replace('e' , '@');
    mutation4 = original.substring(4,60);
    System.out.println("Mutation 1: " + mutation1 + "\nMutation2: " + mutation2
    + "\nMutation3: " + mutation3 + "\nMutation4: " + mutation4);
  }
}
