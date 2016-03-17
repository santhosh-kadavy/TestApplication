
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import jdk.nashorn.internal.parser.JSONParser;
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
public class JsonConversion {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
	obj.put("name", "mkyong.com");
	obj.put("age", new Integer(100));

	JSONArray list = new JSONArray();
        JSONObject obj1=new JSONObject();
        obj1.put("1","msg 1");
        list.add(obj1);
        
        JSONObject obj2=new JSONObject();
        obj2.put("2","msg 2");
         list.add(obj2);
         
	JSONObject obj3=new JSONObject();
        obj3.put("3","msg 3");
	 list.add(obj3);

	obj.put("messages", list);
        String jsonStr1=obj.toJSONString();
        String jsonStr="{\"endLong\"=\"78.3769397\", \"endTime\"=\"16:48:28\", \"endLat\"=\"17.4466785\", \"tripData\"=\"[{Longitude:78.3769388,Latitude:17.4466736},{Longitude:78.3769388,Latitude:17.4466736}]\", \"endLoc\"=\"Deloitte Dr,Hyderabad,India500081\",\"emailId\"=\"user15@gmail.com\", \"tripId\"=\"30\"}";
        /*try {
        
        FileWriter file = new FileWriter("c:\\test.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
        
        } catch (IOException e) {
        e.printStackTrace();
        }*/
	System.out.print(obj);
    JsonParser parser = new JsonParser();
    int firstIndex=jsonStr.indexOf("[");
    int lastIndex=jsonStr.indexOf("]");
    StringBuilder sb = new StringBuilder(jsonStr);
    sb.deleteCharAt(firstIndex-1);
    sb.deleteCharAt(lastIndex);
    String str1=sb.toString();
    Object objFinal = parser.parse(str1);
    JsonObject jsonObject = (JsonObject) objFinal;
    String name = String.valueOf(jsonObject.get("endLong"));
    System.out.println(name);
    
    Map msg = (Map) jsonObject.get("tripData");
    
    }
    }

