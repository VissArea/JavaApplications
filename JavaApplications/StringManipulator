/* ***************************************
 *
 *    StringManipulator - handy String methods we write for ourselves
 *
 *        Author:Joshua Visser
 *        Date: 2 - 18 - 20
 *
 *  =========================================================================
 *  README NOTE README NOTE README NOTE README NOTE README NOTE README NOTE
 *  -------------------------------------------------------------------------
 *  The only String methods that may be used in writing the StringManipulator
 *      class are .charAt() and .length().
 *  =========================================================================
 *
 ****************************************/
import java.util.*;
public class StringManipulator {
    /* ************************************
     *
     * repeat - takes a String and an int and returns the input String
     *          repeated the number of times specified by the int.
     *
     *    repeat("abc ", 4) --> "abc abc abc abc "
     *    repeat("-", 20) --> "--------------------"
     *    repeat("Hello", 0) --> ""
     *    repeat("", 588) --> ""
     *    repeat("Silly", -1) --> ""
     *************************************/
    public String repeat(String str, int times) {
      String repeated = "";
       for ( int i = 0; i < times; i++ ){
        repeated += str;
      }
        return repeated;
    }

    /* ************************************
     *
     * reverse - takes a String and returns the reverse of the String.
     *
     *    reverse("abc123") --> "321cba"
     *    reverse("gag") --> "gag"
     *    reverse(".") --> "."
     *    reverse("") --> ""
     *************************************/
     public String reverse( String str ) {
       String reverse = "";
       int i = str.length() - 1;
       while ( i >= 0 ){
         reverse += str.charAt(i);
         i--;
       }
       return reverse;
     }
    /* ************************************
     *
     * countUppercase - takes a String and returns the count of uppercase
     *                  letters in the input String.
     *
     *    countUppercase("This is typical input.") --> 1
     *    countUppercase("Washington D.C.") --> 3
     *    countUppercase("PLEASE STOP SHOUTING!") --> 17
     *    countUppercase("i enjoy e.e. cummings' poetry.") --> 0
     *    countUppercase(".") --> 0
     *************************************/
     public int countUppercase( String str ){
       int count = 0;
       int i = 0;
       String upperCaseAmount = "";
       while( i < str.length() ){
         if ( str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') count++;
         i++;
       }
       return count;
     }

    /* ************************************
     *
     * moreUpperThanLower - takes a String and returns true if the count of
     *                      uppercase letters in the String is larger than the
     *                      count of lowercase letters in it.
     *
     *      moreUpperThanLower("A") --> true
     *      moreUpperThanLower("Az") --> false
     *      moreUpperThanLower("ABz") --> true
     *      moreUpperThanLower("") --> false
     *************************************/
     public boolean moreUpperThanLower( String str ){
       int upper = 0;
       int lower = 0;
       int i = 0;
       while( i < str.length() ){
         if ( str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') upper++;
         else if( str.charAt(i) >= 'a' && str.charAt(i) <= 'z') lower++;
         i++;
       }
       if( upper > lower )
       return true;
       else
       return false;

     }

    /* ************************************
     *
     * munge - takes a String and returns the equivalent String with each pair
     *         of characters swapped.
     *
     *    munge("ab") --> "ba"
     *    munge("ab1") --> "ba1"
     *    munge("ab12") --> "ba21"
     *    munge("abc12") --> "ba1c2"
     *    munge("This is typical input.") --> "hTsii  sytipac lniup.t"
     *************************************/
     public String munge( String str ){
       String result = "";
       char odd = ' ';
       char even = ' ';
       for( int i = 0, x = 1; i < str.length(); i += 2, x += 2 ){
         even = str.charAt(i);
          if (x < str.length()){
            odd = str.charAt(x);
            result += odd + "" + even;
          }
          else result += "" + even;
        }
       return result;
     }

       // String oddIndex = "";
       // String evenIndex = "";
       // int x = 0;
       // int i = 0;
       // while( i < str.length() ){
       //   if( i % 2 == 1 ) oddIndex += str.charAt(i);
       //   else
       //   evenIndex += str.charAt(i);
       //   result += ( oddIndex.charAt(i) + evenIndex.charAt(i) );
       //   i++;
         // if ( str.charAt(posE) ){
         //    posE += 2;
         //    evenIndex += str.charAt(posE);
         // }
         // else if( str.charAt(posO) ){
         //    posO += 2;
         //    oddIndex += str.charAt(posO);
         // }
         // result += oddIndex.charAt(x) + evenIndex.charAt(x);
         // i++;
         // x++;

    /* ************************************
     *
     * findMatch - takes two Strings: input, and match.  Returns the index of
     *             the first occurrence of the match String in the input String.
     *             If the match String is of zero length or does not occur in
     *             the input String, returns -1.
     *
     *    findMatch("abcd", "d") --> 3
     *    findMatch("abcd", "bb") --> -1
     *    findMatch("aaa bbb ccc ddd", "c") --> 8
     *    findMatch("abcd", "cd") --> 2
     *    findMatch("abcd", "abc") --> 0
     *    findMatch("PLEASE STOP SHOUTING!", "STOP") --> 7
     *    findMatch("PLEASE STOP SHOUTING!", "POUTING") --> -1
     *    findMatch("Any string.", "") --> -1
     *    findMatch("Any string.", "n") --> 1
     *************************************/
     public int findMatch( String input, String match ){
       int i = 0;
       int x = 0;
       int location = -1;
       boolean isMatched = true;
       while ( i < input.length() ){
          if( x < match.length() && input.charAt(i) == match.charAt(x) ){
            while ( x < match.length() ){
             if ( i + x < input.length() ){

             if (input.charAt( i + x ) != match.charAt(x) ){
               isMatched = false;
               location = -1;
              if( input.charAt( i + x ) == match.charAt(x) ){
                isMatched = true;
                location = i;
              }
             }

             // else
             // location = i;
           }
             x++;
            }
            if( isMatched )
            location = i;
          }
           i++;
       }
       return location;
     }

    /* ************************************
     *
     * substituteFirst - takes three Strings: input, match, and sub.  at the
     *              first occurrence of the match String in the input String, it
     *              is removed, and the sub String is put in its place.  If the
     *              match String is of length zero, no substitution takes place.
     *
     *    substituteFirst("abcd", "d", "z") --> "abcz"
     *    substituteFirst("aaa bbb ccc ddd", "c", "Z") --> "aaa bbb Zcc ddd"
     *    substituteFirst("aaa bbb ccc ddd", "c", "ZZZ") --> "aaa bbb ZZZcc ddd"
     *    substituteFirst("aaa bbb ccc ddd", "ccc", "Z") --> "aaa bbb Z ddd"
     *    substituteFirst("Any string.", "", "z") --> "Any string."
     *    substituteFirst("Any string.", "n", "n") --> "Any string."
     *************************************/
     public String substituteFirst( String input, String match, String sub ){
       int i = 0;
       int x = 0;
       String result = "";
       while ( i < input.length() ){
         result += input.charAt(i);
         if ( input.charAt(i) == match.charAt(x) )
         ;
         i++;
       }
       return input;
     }
    /* ************************************
     *
     * BONUS CHALLENGE - BONUS CHALLENGE - BONUS CHALLENGE
     *
     * substituteAll - similar to substitute, but performs the replacement for
     *                 every occurrence of the match String in the input String.
     *
     *    substituteAll("abc abc", "c", "Z") --> "abZ abZ"
     *    substituteAll("aaa bbb ccc ddd", "c", "z") --> "aaa bbb zzz ddd"
     *    substituteAll("Sam I Am", "m", "rto") --> "Sarto I Arto"
     *    substituteAll("How much wood would a woodchuck chuck?", "wo", "WOO")
     *                          --> "How much WOOod WOOuld a WOOodchuck chuck?"
     *************************************/
     // public String substituteAll ( String input, String match, String sub ){
     //
     // }

}
