//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//Tunes.java
//Uses an array of objects
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Tunes{
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Creates a CDCollection object and adds some CDs to it. Prints status of the
  //collection.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    CDCollection music = new CDCollection();

    music.addCD("Legends", "Juice Wrld", 14.95, 10);
    music.addCD("VALENTINO", "24kGoldin", 17.95, 13);
    music.addCD("Unbothered", "Ski Mask The Slump God", 14.95, 17);
    music.addCD("223s", "YNW Melly", 14.95, 8);
    music.addCD("molly", "ian dior", 14.95, 3);
    music.addCD("Goin Baby", "DaBaby", 14.95, 22);
    music.addCD("Neighbors", "J. Cole", 14.95, 7);
    music.addCD("Beamer Boy", "Lil Peep", 14.95, 12);

    System.out.println(music);

  }
}
