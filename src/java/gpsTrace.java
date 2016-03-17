
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspe
 */
public class gpsTrace {
    public static void main(String[] args) {
        
        JSONArray job=new JSONArray();
        for (int i=1;i<=3;i++){
          JSONObject json=new JSONObject();
          json.put("lat", "123");
          json.put("long", "456");
          json.put("heading","25");
          json.put("speed","12");
          job.add(json);
        }
        JSONObject tripJson=new JSONObject();
        tripJson.put("trip", job);
        System.out.print(tripJson);
        //retrieving code
        
        JSONArray getTripJson=(JSONArray)tripJson.get("trip");
        for (int i=0;i<=getTripJson.size();i++){
            JSONObject trip=(JSONObject)getTripJson.get(i);
            String lat=trip.get("lat").toString();
            String lon=trip.get("long").toString();
            String heading=trip.get("heading").toString();
            Float speed=Float.parseFloat(trip.get("speed").toString());
            
        }
        
        
    }
    
    
}
