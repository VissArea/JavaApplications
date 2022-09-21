//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//CDCollection.java
//Represents a collection of CDs
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.text.NumberFormat;
public class CDCollection{
  private CD[] collection;
  private int count;
  private double totalCost;
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Constructor: creates an initially empty collection.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public CDCollection(){
    collection = new CD[100];
    count = 0;
    totalCost = 0.0;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Adds a CD to the collection, increases the size of the collection if needed.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void addCD(String title, String artist, double cost, int tracks){
    if(count == collection.length)
    increaseSize();

    collection[count] = new CD(title, artist, cost, tracks);
    totalCost += cost;
    count++;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Returns a report describing the CD collection.
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String toString(){
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
      report += "My CD Collection\n\n";
      report += "Number of CDs: " + count + "\n";
      report += "Total Cost: " + fmt.format(totalCost) + "\n";
      report += "Average Cost: " + fmt.format(totalCost/count);

      report += "\n\nCD List:\n\n";
      for(int cd = 0; cd < count; cd++){
        report += collection[cd].toString() +"\n";
      }
      return report;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Increases the capacity of the collection by creating a larger array and
    //copying the existing collection into it
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void increaseSize(){
      CD[] temp = new CD[collection.length * 2];

      for(int cd = 0; cd < collection.length; cd++){
        temp[cd] = collection[cd];
      }
      collection = temp;
    }
  }
