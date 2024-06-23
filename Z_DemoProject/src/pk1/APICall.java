package pk1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICall 
{
	public static void main(String[] args) 
	{
		HttpRequest request = HttpRequest
				.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try 
        {
            response = HttpClient
            		.newHttpClient()
            		.send(request, HttpResponse.BodyHandlers.ofString());
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        if (response != null) 
        {
            System.out.println(response.body());
        } 
        else 
        {
            System.out.println("No response received.");
        }
	}
}