//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//SecretTest.java
//Represents a Volunteer staff member
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class SecretTest{
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Creates a Secret object and exercises the Encryption
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Secret whisper = new Secret("I like the smell of flowers...");
    System.out.println(whisper);
    whisper.encrypt();
    System.out.println(whisper);
    whisper.decrypt();
    System.out.println(whisper);
  }
}
