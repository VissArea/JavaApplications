/***********************
 *
 *   GumMachine - class modeling a gumball machine
 *
 *   Author:   Joshua Visser
 *   Date:     2020-Apr 1
 *
 ***********************/
 public class GumMachine {

 // A gum machine has two constants:
 //       the pieces dispensed per sale: 6
 //       the capacity (number of gumballs) of a machine: 475
 // A gum machine has two properties (both ints):
 //       the number of gumballs in the machine
 //       the number of quarters in the machine
 int BALLS_DISPENSED = 6;
 int MACHINE_CAP = 475;
 int gumBalls, quarters;


 // There are two ways to create a new GumMachine.
 // If the constructor has no parameters, a new gum machine is
 // created that has no quarters and is full to capacity of gumballs.
 // A second constructor can take a number of gumballs as a parameter,
 // and a new machine will be created with no quarters and the given
 // number of gumballs initially in the machine (provided that number
 // is less than the capacity of the machine - otherwise, the machine
 // will start full, at capacity.)
 public void gumMachine(){
   gumBalls = 475;
   quarters = 0;
 }
 public void gumMachine( int gumBalls ){
   quarters = 0;
 }


 // the buyGum method takes no parameters, inserts one quarter into the machine,
 // dispenses gumBalls, and returns the number of gumballs dispensed. If possible,
 // it dispenses "pieces dispensed per sale", or 6. If there are not 6 pieces
 // left in the machine, it dispenses all that are left.

 public int buyGum(){
   if( !(gumBalls >= 6) )
    return gumBalls;
   else
   gumBalls = gumBalls - BALLS_DISPENSED;
   return BALLS_DISPENSED;
 }


 // the serviceMachine method refills the machine to capacity and removes
 // all the money from the machine. The method returns the total amount
 // of money removed from the machine (as a double).



 // the isEmpty method answers if the machine is empty of gumballs
 public boolean isEmpty(){
   if( !(gumBalls = 0) )
   return false;
   else
   return true;
 }

 int moneyMade = (MACHINE_CAP - gumBalls) / 6;
 // the toString method returns a nicely formatted String showing how many gumballs
 // are in the machine and how much money is in the machine.
 public String toString(){
   s,o,System.out.println("There are " + gumBalls + " left in the machine, along " +
    " with " + moneyMade + " quarters in the machine." );
 }



 }
