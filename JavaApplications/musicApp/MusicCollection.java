import java.io.*;     // this is needed for File IO stuff
import java.util.*;   // this is needed for Scanner as well as the Arrays class
import java.util.Arrays;
public class MusicCollection {

    // Music collection has one piece of instance data: an array of Song

    Song[] kindOfSong;

    // Constructor - takes a filename and reads in all songs in the file
    // first line of the file contains a number that says how many lines are
    // in the file (one song per line). Each song has data delimited by "::"*
    //   title::artist::album::track::year::genre::minutes::seconds*
    //   String String  String int    int   String int      int

    public MusicCollection (String songs ) throws IOException
    {
          File musicData = new File( songs );
          Scanner fileScan = new Scanner( musicData );
          int filePos = fileScan.nextInt( );
          fileScan.nextLine( );
          kindOfSong = new Song[filePos];
          int i = 0;
            while (fileScan.hasNextLine( ) )
            {
                String line = fileScan.nextLine( );
                Scanner lineScanner = new Scanner( line );
                    lineScanner.useDelimiter("::");
                          String tit = lineScanner.next( );
                          String art = lineScanner.next( );
                          String alb = lineScanner.next( );
                          int trac = lineScanner.nextInt( );
                          int yr = lineScanner.nextInt( );
                          String gen = lineScanner.next( );
                          int mins = lineScanner.nextInt( );
                          int secs = lineScanner.nextInt( );

                                kindOfSong[i] = new Song( tit, art, alb, trac, yr, gen, mins, secs );
                                i++;
               }

    }

    // makePlaylistByArtist - creates a playlist of all songs in the
    // collection by the given artist. It takes the artist (a String)*
    // as a parameter. The method must first count how many songs in
    // the collection are by that artist so that it can make an array*
    // of song to put those songs in. It then copies all songs by
    // that artist into the newly created array. It then creates a*
    // new playlist with the title "Songs by the given artist" and*
    // the newly created song array. The reference to this newly
    // created playlist is returned.*
    // Note: make use of the Song method artistIs

        public Playlist makePlaylistByArtist( String artist )
        {
          int list = 0;
            for( int i = 0; i  < kindOfSong.length; i++ )
            {
              if( kindOfSong[i].getArtist( ).equals( artist ) )
                {
                  list ++;
                }
            }
            Song[] similarSongs = new Song[ list ];
            int songsInPlaylist = 0;
              for( int i = 0; i < kindOfSong.length; i++ )
                {
                  if( kindOfSong[i].getArtist( ).equals( artist ) )
                    {
                      similarSongs[ songsInPlaylist ] = kindOfSong[i];
                      songsInPlaylist++;
                    }
                }
          Playlist p1 = new Playlist( "Songs by The " + artist, similarSongs);
          return p1;
        }


    // makePlaylistByGenre - creates a playlist of all songs in the
    // collection of the given genre. It takes genre (as a String)
    // as a parameter. The method must first count all songs in the
    // collection of the given genre, make an array of Song to hold
    // them, then go through the collection again and copy all songs
    // of the given genre into the array. Then, it creates a Playlist
    // with a title of "given genre Songs" and the array, and
    // returns that playlist.
    // Note: make use of the Song method genreIs

         public Playlist makePlaylistByGenre( String genre )
         {
              int list = 0;
                for( int i = 0; i  < kindOfSong.length; i++ )
                {
                  if( kindOfSong[i].getGenre( ).equals( genre ) )
                    {
                      list ++;
                    }
                }
                Song[] similarSongs = new Song[ list ];
                int songsInPlaylist = 0;
                  for( int i = 0; i < kindOfSong.length; i++ )
                    {
                      if( kindOfSong[i].getGenre( ).equals( genre ) )
                        {
                          similarSongs[ songsInPlaylist ] = kindOfSong[i];
                          songsInPlaylist++;
                        }
                    }
              Playlist p1 = new Playlist( "Songs in the Genre: " + genre, similarSongs);
              return p1;
         }



    // makePlaylistByYear - takes a title, year1, and year2
    // creates an array of Song to send to the Playlist
    // constructor. The method must first count how many
    // songs in the collection were released between year1 and year2,
    // make an array of Song that size, then copy references to all
    // songs in the collection that are between the two years into
    // the array. A Playlist is created with that array and returned.
    // Note: make use of the Song method releasedBetween

      public Playlist makePlaylistByYear( String title, int year1, int year2 )
        {
             int list = 0;
               for( int i = 0; i  < kindOfSong.length; i++ )
               {
                 if( kindOfSong[i].releasedBetween( year1, year2 ) )
                   {
                     list ++;
                   }
               }
               Song[] similarSongs = new Song[ list ];
               int songsInPlaylist = 0;
                 for( int i = 0; i < kindOfSong.length; i++ )
                   {
                     if( kindOfSong[i].releasedBetween( year1, year2 ) )
                       {
                         similarSongs[ songsInPlaylist ] = kindOfSong[i];
                         songsInPlaylist++;
                       }
                   }
             Playlist p1 = new Playlist( "Songs Made Between Years: " + year1 + " and " + year2, similarSongs);
             return p1;
        }



    // makePlaylistByYear - takes only a year and creates an array
    // of songs released in that year  to send to the Playlist
    // constructor. The method must first count how many
    // songs in the collection were released that year,
    // make an array of Song that size, then copy references to all
    // songs in the collection released that year into the array.
    // A playlist is created with a title "Songs released in " the
    // given year, and the array of songs, and the playlist is returned.

       public Playlist makePlaylistByYear( int year )
      {
           int list = 0;
             for( int i = 0; i  < kindOfSong.length; i++ )
             {
               if( kindOfSong[i].releasedIn( year ) )
                 {
                   list ++;
                 }
             }
             Song[] similarSongs = new Song[ list ];
             int songsInPlaylist = 0;
               for( int i = 0; i < kindOfSong.length; i++ )
                 {
                   if( kindOfSong[i].releasedIn( year ) )
                     {
                       similarSongs[ songsInPlaylist ] = kindOfSong[i];
                       songsInPlaylist++;
                     }
                 }
           Playlist p1 = new Playlist( "Songs Released In  " + year, similarSongs);
           return p1;
      }



    // sort- calls Arrays.sort to sort the allSongs in
    // whatever order is dictated by the compareTo method in the
    // Song class (which you will write). You must:
    // import java.util.Arrays at the top of this file
    public void sort( ){
      Arrays.sort( kindOfSong );
    }

    // toString - builds a String with "Entire Music Collection"
    // followed by the toString for all songs in the collection.

    public String toString( )
    {
      String allSongs = " Entire Music Collection \n\t";
      for( int i = 0; i < kindOfSong.length; i++ )
      {
        allSongs += kindOfSong[i] + "\n";
      }
      return allSongs;
    }

}
