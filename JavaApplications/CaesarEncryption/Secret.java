//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//Secret.java
//Represents a secret message that can be
//encrypted and decrypted.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.Random;
public class Secret implements Encryptable{
  private String message;
  private boolean encrypted;
  private int shift;
  private Random gen;

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Constructor: Stores the original message and establishes a value for the
  //encryption shift.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public Secret(String msg){
    message = msg;
    encrypted = false;
    gen = new Random();
    shift = gen.nextInt(10)+5;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Encrypts this secret using a Caesar cypher, if message is already encrypted
  //no effect.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void encrypt(){
    if(!encrypted){
      String masked = "";
      for(int i = 0; i < message.length(); i++){
        masked = masked + (char) (message.charAt(i)+shift);
      }
      message = masked;
      encrypted = true;
    }
  }
  public String decrypt(){
    if(encrypted){
      String unmasked = "";
      for(int i = 0; i < message.length(); i++){
        unmasked = unmasked + (char) (message.charAt(i)-shift);
      }
      message = unmasked;
      encrypted = false;
    }
    return message;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Returns true if secret is currently encrypted.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public boolean isEncrypted(){
    return encrypted;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Returns Secret message.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public String toString(){
    return message;
  }
}
