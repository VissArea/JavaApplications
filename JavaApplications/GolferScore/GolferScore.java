/* *********************
 *
 *   GolferScore - represents one player's score on an 18 hole golf course.
 *
 *   Author:   Joshua Visser
 *   Date:     2020-April-4
 *
 ***********************/

/* *********************

This assignment makes use of some concepts of golf.

In golf, the golfers are trying to hit a ball into a hole.  The hole is far
away, so it nearly always takes multiple hits to get the ball in.

A course of golf is generally a set of eighteen different holes, each starting
from a different place.

Par is the number of hits that an experienced, skilled golfer is expected to take
to get the ball in the hole.  In golf, a lower score is better than a higher
score.

If a golfer gets the ball in the hole in the "par" number of shots, they
are doing well.  One less than par (if par is 4, then 3 shots) is called a birdie,
and that's even better.  One more than par (in this case 5) is called a bogey, and
it is not as good for the golfer.

************************/
public class GolferScore {

//  Declare the instance data:
//  a constant, NUM_HOLES is 18*
//  an integer array of pars for each hole*
//  in integer array of scores for each hole*
//  a String for the name of the golfer*
//  a String for the name of the course*
final int NUM_HOLES = 18;
private int[] holesPar = new int[NUM_HOLES];
private int[] score = new int[NUM_HOLES];
private String golfer;
private String course;

//  a constructor which takes a golfer's name, a course name, and an array
//  containing the par for each hole (integers).
//  (You may assume the array of pars is the correct number of holes, 18,
//  and that each par is valid.  A valid par is 3, 4, 5, or 6.)
public GolferScore ( String golfer, String course, int[] holesPar ){
  this.golfer = golfer;
  this.course = course;
  this.holesPar = holesPar;
}

//  write getters for all instance data*
public int[] getHolesPar( ){

  return holesPar;
}
public int[] getScore(){
  return score;
}
public String getGolfer(){
  return golfer;
}
public String getCourse(){
  return course;
}


//  setScore - takes a holeNumber and a golfer's score for that hole,
//             and sets it in the score array.
//             This method only sets the score for valid holes.
public void setScore( int holeNumber, int golferScore ){
  if( holeNumber >= 1 && holeNumber <= 18 )
   score[holeNumber - 1] = golferScore;
}

//  totalCoursePar - returns the total par for the course
public int totalCoursePar( ){
  int i = 0;
  int count = 0;
  while( i < holesPar.length ){
    count += holesPar[i];
    i++;
  }
  return count;
}


//  totalCourseScore - returns the total score for the course
public int totalCourseScore( ){
  int i = 0;
  int count = 0;
  while( i < score.length ){
    count += score[i];
    i++;
  }
  return count;
}

//  parSumOfHolesPlayed - returns the total of par for holes that have been played
public int parSumOfHolesPlayed( ){
  int i = 0;
  int count = 0;
  while( i < NUM_HOLES ){
    if( score[i] > 0 )
    count += holesPar[i];
    i++;
  }
  return count;
}

//  isOverPar - answers if the total score of holes played so far is over par
public boolean isOverPar( ){
  boolean isOverPar = false;
  int i = 0;
  int x = 0;// total score
  int count = 0;
  while( i < score.length ){
    if( score[i] > 0 )
    count += holesPar[i];
    x += score[i];
    i++;
  }
  if( x > count )
    isOverPar = true;
  return isOverPar;
}


//  isUnderPar - answers if the total score of holes played so far is under par
public boolean isUnderPar( ){
  boolean isUnderPar = false;
  int i = 0;
  int x = 0;// total score
  int count = 0;
  while( i < NUM_HOLES ){
    if( score[i] > 0 )
    count += holesPar[i];
    x += score[i];
    i++;
  }
  if( x < count )
    isUnderPar = true;
  return isUnderPar;
}


//  isPar - answers if the total score of holes played so far is the same as par
public boolean isPar( ){
  boolean isPar = false;
  int i = 0;
  int x = 0;// total score
  int count = 0;
  while( i < NUM_HOLES ){
    if( score[i] > 0 )
    count += holesPar[i];
    x += score[i];
    i++;
  }
  if( x == count )
    isPar = true;
  return isPar;
}


//  isOverPar - answers if the score for the given hole number is over par
//  NOTE: this is an overloaded method.  it takes a parameter, unlike the
//        previous isOverPar method. Also, this method checks to see if the
//        given hole number is valid, otherwise, the method returns false.
//        This note applies to the next two methods as well.
public boolean isOverPar( int hole ){
  boolean isOverPar = false;
  int i = 0;
  int x = 0;// total score
  int count = 0;
  if( score[hole]!= 0 && score[hole - 1] > holesPar[hole - 1] )
    isOverPar = true;
  return isOverPar;
}




//  isUnderPar - answers if the score for the given hole number is under par
//  NOTE: if a score is zero, it means the hole has not been played yet.
//        In that case, this method should return false.
public boolean isUnderPar( int hole ){
  boolean isUnderPar = false;
  int i = 0;
  int x = 0;// total score
  int count = 0;
  if( score[hole]!= 0 && score[hole - 1] < holesPar[hole - 1] )
    isUnderPar = true;
  return isUnderPar;

}

//  isPar - answers if the score for the given hole number is par
public boolean isPar( int hole ){
  boolean isPar = false;
  int i = 0;
  int x = 0;// total score
  int count = 0;
  if( score[hole]!= 0 && score[hole + 1] == holesPar[hole + 1] )
    isPar = true;
  return isPar;
}


//  numHolesUnderPar - returns the number of holes played that are under par
//  NOTE: if a score is zero, that means the hole has not yet been played
//        and should not be counted as under par.
public int numHolesUnderPar( ){
  int i = 0;
  int x = 0;// total score
  int count = 0;
  while( i != score[x] ){
      if( score[x] < holesPar[x] )
        count++;
      x++;
    }
  return count;
}



//  numHolesOverPar - returns the number of holes played that are over par
public int numHolesOverPar( ){
  int i = 0;
  int x = 0;// total score
  int count = 0;
  while( i != score[x] ){
      if( score[x] > holesPar[x] )
        count++;
      x++;
    }
  return count;
}


//  numHolesPar - returns the number of holes played that are par
public int numHolesPar( ){
  int i = 0;
  int x = 0;// total score
  int count = 0;
  while( i != score[x] ){
      if( score[x] == holesPar[x] )
        count++;
      x++;
    }
  return count;
}


//  numBirdies - returns the number of holes played that are birdies
//  NOTE: a birdie is one under par.
public int numBirdies( ){
  int i = 0;
  int x = 0;// total score
  int count = 0;
  while( i != score[x] ){
      if( score[x] == holesPar[x] - 1 )
        count++;
      x++;
    }
  return count;
}


//  numBogeys - returns the number of holes played that are bogeys
//  NOTE: a bogey is one over par.
  public int numBogeys( ){
    int i = 0;
    int x = 0;// total score
    int count = 0;
    while( i != score[x] ){
        if( score[x] == holesPar[x] + 1 )
          count++;
        x++;
      }
    return count;
  }

  public String holesTable(){
    String str = "";

    for(int i = 1; i <= NUM_HOLES; i++ ){
      if( i < 10 )
      str += i + " | ";
      else if( i >= 10 )
      str += i + "| ";
    }
    return str;
  }
  public String parsTable(){
    String str = "";
    for( int i = 0; i < holesPar.length; i++ ){
      str += holesPar[i] + " | ";
    }
    return str;
  }

  public String scoreTable(){
    String str = "";
    for( int i = 0; i < score.length; i++ ){
      str += score[i] + " | ";
    }
    return str;
  }
  public String rating(){
    int count;
    String str = "";
    if( isOverPar() ){
      count = totalCourseScore() - parSumOfHolesPlayed();
      str = " is " + count + " over Par \n\n";
    }
    else if( isUnderPar() ){
      count = parSumOfHolesPlayed() - totalCourseScore();
      str = " is " + count + " under Par \n\n";
     }
    else{
      str = " Score is Par \n\n";
    }
    return str;
  }
//  toString - returns a String representation of a Golf scorecard,
//             including the golfer's name, the course name, and a
//             table of hole number, par for each hole, score for each hole,
//             and totals for the whole course. A message, appropriate to
//             the total course score, says "Par", "x over Par", or
//             "x under Par", where x is the correct number.
public String toString(){
  String golferInfo = "\nGolfer's Name: " + golfer + "\n\nGolf Course: " + course +
  "\n\nHoles: |" + holesTable() + " |Total: " + "\nPar:   |" + parsTable() + " | " + parSumOfHolesPlayed() +
  "\nScore: |" + scoreTable() + " | " + totalCourseScore() + rating();


  return golferInfo;
  }
}
