import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class API
{
        public static void main(String[] args)
        {
            String urlNowPlaying = "https://us.api.blizzard.com/hearthstone/cards";
            makeAPICall(urlNowPlaying);

            System.out.print("Which Cards (enter ID)? ");
            Scanner s = new Scanner(System.in);
            int movieID = s.nextInt();

            String heroURL = urlNowPlaying + "/" + movieID;
            makeAPICall(heroURL);
        }

        public static void makeAPICall(String url)
        {
            try {
                URI myUri = URI.create(url); // creates a URI object from the url string
                HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();

                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // UNCOMMENT TO PRINT OTHER PARTS OF THE RESPONSE
//                System.out.println(response.statusCode());
//                System.out.println(response.headers());
                System.out.println(response.body());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
