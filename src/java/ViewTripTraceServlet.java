/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author itspe
 */
public class ViewTripTraceServlet extends HttpServlet {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String latitude="";
            String longitude="";
            String emailId="";
            String key1="";
            String key2="";
            JSONArray ja=new JSONArray();
            dataConnectionObject dco=new dataConnectionObject();
             Encryptor encryptor=new Encryptor();
            conn=dco.getConnection();
            pst=conn.prepareStatement("select emailId from TripDataTable where tripId=?");
            pst.setInt(1, 30);
            rs=pst.executeQuery();
            rs.next();
            emailId=rs.getString("emailId");
            pst=conn.prepareStatement("select key1,key2 from UserProfileTable where emailId=?");
            pst.setString(1,emailId);
            rs=pst.executeQuery();
            rs.next();
            key1=rs.getString("key1");
            key2=rs.getString("key2");
            pst=conn.prepareStatement("select * from gpsData where tripId=?");
            pst.setInt(1, 30);
            rs=pst.executeQuery();
            while(rs.next()){
               latitude=encryptor.decrypt(key1, key2, rs.getString("latitude"));
               longitude=encryptor.decrypt(key1, key2, rs.getString("longitude"));
               JSONObject jo=new JSONObject();
               jo.put("latitude",latitude);
               jo.put("longitude", longitude);
               ja.add(jo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewTripTraceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conn.close();
                pst.close();
                rs.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
       
    }
}
