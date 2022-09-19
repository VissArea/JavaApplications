//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//IceCream.java
//Demonstrates the use of enumerated
//types
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class IceCream{
  enum Flavor {vanilla, chocolate, strawberry, coffee, rockyRoad,
  mintChocolateChip, cookieDough}
  public static void main(String[] args) {
    Flavor cone1, cone2, cone3;

    cone1 = Flavor.rockyRoad;
    cone2 = Flavor.mintChocolateChip;
    cone3 = cone1;

    System.out.println("cone1 value: " + cone1);
    System.out.println("cone1 ordinal: " + cone1.ordinal());
    System.out.println("cone1 name: " + cone1.name());

    System.out.println("cone2 value: " + cone2);
    System.out.println("cone2 ordinal: " + cone2.ordinal());
    System.out.println("cone2 name: " + cone2.name());

    System.out.println("cone3 value: " + cone3);
    System.out.println("cone3 ordinal: " + cone3.ordinal());
    System.out.println("cone3 name: " + cone3.name());
  }
}
