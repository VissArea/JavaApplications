public class Playlist {

    // A playlist has two pieces of data: the title of the
    // playlist, such as "Music from the 50s", and*
    // an array of Song*
    private String title;
    private Song[] kindOfSong;


    // The constructor takes both the title and*
    // array of songs as parameters.*
    public Playlist(String title, Song[] k ){
      this.title = title;
      this.kindOfSong = k;
    }

    // A helper method to add up all the minutes*
    // and all of the seconds of all the songs*
    // in the list and return the total time in*
    // the format minutes:seconds would make the*
    // toString method easier to deal with.
    public String helper( )
      {
        int totalMins = 0;
        int totalSecs = 0;
            for( int i = 0; i < kindOfSong.length; i++ )
            {
              totalSecs = totalSecs + ( kindOfSong[i].getSeconds( ) );
              totalMins = totalMins + (kindOfSong[i].getMinutes( ) );
            }
            int totalMinsVal = ( (totalSecs / 60 ) + totalMins );
            int totalSecsVal= ( totalSecs % 60 );
            String totalTime =  totalMinsVal +  ":" + totalSecsVal ;
            return totalTime;
      }



    // toString - returns a String of the playlist including:
    //     the title of the playlist, followed by*
    //     the toString for every song in the list,*
    //     and at the end, the total number of songs in the list
    //     and the total time of all songs in the list
      public String toString( ){
        String result = " ";
            for( int i = 0; i < kindOfSong.length; i++ )
              {
                result  += kindOfSong[i].toString( ) + "\n";
              }
      result += "\n\n\t" + kindOfSong.length + " Total Songs ---- Total Time:  " + helper( ) + "\n";
      return result;
      }

}
