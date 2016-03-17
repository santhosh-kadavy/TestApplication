
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Clock;
import jdk.nashorn.internal.objects.Global;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspe
 */
public class GeoLocation {
    public static void main(String args[]){
	try {

	    URL myURL = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng=17.451425,%2078.380957&key=AIzaSyDe_RBKl4DBGy6YCWRPXi9eQzYACt05Tr8");
	    URLConnection myURLConnection = myURL.openConnection();
	    myURLConnection.connect();
	    BufferedReader in = new BufferedReader(new InputStreamReader(
	    		myURLConnection.getInputStream()));
            
            StringBuilder sb = new StringBuilder();

            String line = null;

            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
            } 
           
           JsonElement json = new JsonParser().parse(sb.toString());
           JsonObject j=json.getAsJsonObject();
           JsonElement je=j.get("results");
           JsonArray ja=je.getAsJsonArray();
           JsonElement je1=ja.get(1);
           JsonObject j1=je1.getAsJsonObject();
           JsonElement je2=j1.get("formatted_address");
            System.out.println(je2.getAsString());
                }
                catch (MalformedURLException e) { 
                    // new URL() failed
                    // ...
                } 
                catch (IOException e) {   
                    // openConnection() failed
                    // ...
                }

        }
}
