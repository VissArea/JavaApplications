public class Song implements Comparable <Song>{
    private String title;
    private String artist;
    private String album;
    private int track;
    private int year;
    private String genre;
    private int minutes;
    private int seconds;

public Song(String initTitle, String initArtist, String initAlbum, int initTrack, int initYear, String initGenre, int initMin, int initSec) {
    this.title = initTitle;
    this.artist = initArtist;
    this.album = initAlbum;
    this.track = initTrack;
    this.year = initYear;
    this.genre = initGenre;
    this.minutes = initMin;
    this.seconds = initSec;
}
public Song(String initTitle, String initArtist, int initYear, String initGenre, int initMin, int initSec) {
    this(initTitle, initArtist, "", 0, initYear, initGenre, initMin, initSec);
}
public String getTitle() {
    return title;
}
public String getArtist() {
    return artist;
}
public String getAlbum() {
    return album;
}
public int getTrack(){
    return track;
}
public int getYear() {
    return year;
}
public String getGenre() {
    return genre;
}
public int getMinutes() {
    return minutes;
}
public int getSeconds() {
    return seconds;
}
public void setGenre(String newGenre) {
    this.genre = newGenre;
}

// Write a compareTo method for Song
// When comparing songs, first compare genre.
// If genre is the same, then compare artist.
  public int compareTo( Song randomSong )
  {
        int num = 0;

        if( this.genre.compareTo( randomSong.genre ) == 0 ){
          num = this.artist.compareTo( randomSong.artist );
        }
        else {
          num = this.genre.compareTo( randomSong.genre);
        }
        // if( num > 1) {
        //   num = 1;
        // }
        // else if( num < 1 ){
        //   num = -1;
        // }
        // else{
        //   num = 0;
        // }
        return num;
    }



public boolean releasedIn(int yr) {
    return (this.year == yr);
}
public boolean releasedBetween(int yr1, int yr2) {
    int lo = yr1;
    int hi = yr2;
    if (yr1 > yr2) {
        hi = yr1;
        lo = yr2;
    }
    return (this.year >= lo && this.year <= hi);
}
public boolean genreIs(String genre) {
    return (this.genre.equalsIgnoreCase(genre));
}
public boolean artistIs(String artist) {
    return (this.artist.equalsIgnoreCase(artist));
}
private String rightPad(String str, int width, char ch) {
    for (int i = str.length(); i<width; i++) {
        str += ch;
    }
    return str;
}
// Notice this new toString that formats Song in a nice way, without
// double colons. Notice the helper method rightPad. What does it do?
public String toString() {
    return rightPad(this.title + " ",26,'-') + " by " + rightPad(this.artist + " ",20,'-') + " Genre: " + this.genre
    + "\nalbum: " + this.album + ", track : " + this.track
    + "\treleased in: " + this.year + "  time: " + this.minutes + ":"
    + (this.seconds<10?"0":"") + this.seconds  + "\n";
}
}
