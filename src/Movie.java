public class Movie {

    private String title;
    private int id;
    private String posterPath;
    private String releaseYear;
    private String genre;
    private boolean adult;

    public Movie(String title, int id, String posterPath, String releaseYear, String genre, boolean adult)
    {
        this.title = title;
        this.id = id;
        this.posterPath = posterPath;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.adult = adult;
    }

    public String getTitle()
    {
        return title;
    }

    public int getID()
    {
        return id;
    }

    public String getPosterPath()
    {
        return posterPath;
    }

    public String getReleaseYear()
    {
        return releaseYear;
    }

    public String getGenre()
    {
        return genre;
    }

    public boolean isAdult()
    {
        return adult;
    }
}