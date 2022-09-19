//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Viss
//Die.java
//Represents 1 singular die with 6
//faces showing values between 1 to
//6.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Die{
    private final int MAX = 6; //6 values of face of die
    private int faceValue; //current value

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Constructor: Sets the initial face of the die
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Die(){
      faceValue = 1;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Compute a new face value for this die and returns result
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int roll(){
      faceValue = (int)(Math.random() * MAX) + 1;
      return faceValue;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //FaceValue mutator. The Face Value is not modified if the value is invalid.
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setFaceValue(int value){
      if(value < 0 && value <= MAX)
      faceValue = value;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Face value accessor.
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int getFaceValue(){
      return faceValue;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Returns a string that Represents this die
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String toString(){
      String result = Integer.toString(faceValue);
      return result;
    }
}
