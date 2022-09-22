//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//Employee.java
//Represents a Volunteer staff member
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Employee extends StaffMember{
  protected String socialSecurityNum;
  protected double payRate;
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Constructor sets up an employee member
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public Employee(String xName, String xAddress, String xPhone, String ssn,
  double rate){
    super(xName, xAddress, xPhone);
    socialSecurityNum = ssn;
    payRate = rate;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //Returns employee information
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public String toString(){
    String result = super.toString();
    result += "\nSocial Security Number: " + socialSecurityNum;
    return result;
  }
  public double pay(){
    return payRate;
  }
}
