import java.io.*;
import java.util.*;
public class TestMusic {
    public static void main(String[] args) throws IOException {

        // make a MusicCollection using the file music.dat
        // print it out to see if it is working.
        // You will comment out this println later.

        MusicCollection collection = new MusicCollection( "music.dat");
        // System.out.println( collection );



        // make a playlist for the artist AJR

         Playlist artistAJR = collection.makePlaylistByArtist( "AJR" );
        // System.out.println( artistAJR );

        // make a playlist for the artist Yes
         Playlist artistYes = collection.makePlaylistByArtist( "Yes" );
        // System.out.println( artistYes );

        // make a playlist for the genre Electronic
         Playlist genreElectronic = collection.makePlaylistByGenre( "Electronic" );
        // System.out.println( genreElectronic );

        // make a playlist for the genre Hip-Hop/Rap
         Playlist genreHipHopRap = collection.makePlaylistByGenre( "Hip-Hop/Rap" );
        // System.out.println( genreHipHopRap );

        // make a playlist for the year 2015
        Playlist releasedIn2015 = collection.makePlaylistByYear( 2015 );
        //System.out.println( releasedIn2015 );
        // make a playlist for the year 2016
         Playlist releasedIn2016 = collection.makePlaylistByYear( 2016 );
        // System.out.println( releasedIn2016 );
        // make a playlist for the year 2017
        Playlist releasedIn2017 = collection.makePlaylistByYear( 2017 );
        // System.out.println( releasedIn2017 );
        // make a playlist for the year 2018
         Playlist releasedIn2018 = collection.makePlaylistByYear( 2018 );
        // System.out.println( releasedIn2018 );
        // make a playlist for the sixties, between 1960 and 1969, inclusive
         Playlist releasedBetween1960And1969 = collection.makePlaylistByYear("title" , 1960, 1969);
        // System.out.println( releasedBetween1960And1969 );
        // make a playlist for the seventies, between 1970 and 1979, inclusive
         Playlist releasedBetween1970And1979 = collection.makePlaylistByYear("title" , 1970, 1979);
        // System.out.println( releasedBetween1970And1979 );
        // call your sort method and print out this collection
        collection.sort( );
        System.out.println( collection );
    } //main
}
