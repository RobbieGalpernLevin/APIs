import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class WebAPI
{

    public static void main(String[] args)
    {
        String APIkey = "72162d393bde753b59705f60976df59d";
        String urlNowPlaying = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + APIkey;
        String response = makeAPICall(urlNowPlaying);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        if (response != null)
        {
            parseJSON(response, movies);
        }

        for (Movie movie : movies)
        {
            System.out.println(movie.getID() + " " + movie.getTitle() + " " + movie.getPosterPath());
        }
    }

    public static String makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void parseJSON(String json, ArrayList<Movie> movies)
    {
        JSONObject jsonObj = new JSONObject(json);
        JSONArray movieList = jsonObj.getJSONArray("results");

        for (int i = 0; i < movieList.length(); i++)
        {
            JSONObject movieObj = movieList.getJSONObject(i);
            String movieTitle = movieObj.getString("title");
            int movieID = movieObj.getInt("id");
            String posterPath = movieObj.getString("poster_path");
            String fullPosterPath = "https://image.tmdb.org/t/p/w500" + posterPath;
            String releaseYear = movieObj.getString("release_date");
            String genre = movieObj.getString("genre");
            boolean adult = movieObj.getBoolean("adult");


            Movie movie = new Movie(movieTitle, movieID, fullPosterPath, releaseYear, genre, adult);
            movies.add(movie);
        }
    }
}