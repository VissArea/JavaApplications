//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//Staff.java
//Represents the staff members of a
//particular business.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Staff{
  private StaffMember[] staffList;
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Constructor: sets up the list of staff members.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public Staff(){
    staffList = new StaffMember[5];
    staffList[0] = new Executive("Drew Visser", "123 Lake Point Drive",
    "123-456-7890", "111-11-2222", 2940.11);
    staffList[1] = new Employee("James", "1 Blank Drive",
    "333-116-7440", "122-33-2222", 1233.22);
    staffList[2] = new Employee("Quinn", "640 Long Drive Lane",
    "223-226-7221", "554-33-2222", 1433.22);
    staffList[3] = new Hourly("Alleigh", "5 Par Green Circle",
    "555-106-2110", "552-33-2222", 17.22);
    staffList[4] = new Volunteer("Quinn", "Long Drive Lane",
    "223-226-7221");

    ((Executive)staffList[0]).awardBonus(1200.00);
    ((Hourly)staffList[3]).addHours(40);
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Pays all staff members
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void payday(){
    double amount;

    for(int i = 0; i < staffList.length; i++){
      System.out.println(staffList[i]);
      amount = staffList[i].pay();
      if(amount == 0.0){
        System.out.println("Thanks!");
      }
      else
      System.out.println("Paid: " + amount);
      System.out.println("---------------------------------------------------");
    }
  }
}
