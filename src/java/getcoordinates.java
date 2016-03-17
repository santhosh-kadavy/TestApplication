
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspe
 */
public class getcoordinates {
    
    public static void main(String[] args) {
         /*Connection conn = null;
     Connection pgConn = null;
     PreparedStatement pst = null;
     ResultSet rs = null;
     ArrayList distArray=new ArrayList();
     int tripId=713;
        String key1= "kadavy@gmail.com";
        String key2="comMale5-11-1985";
        dataConnectionObject dco=new dataConnectionObject();
        EncryptorObject encryptorObject=new EncryptorObject();
        conn=dco.getConnection();
        Float distance=0.0f;
        PostGISConnectionObject postGISConnectionObject= new PostGISConnectionObject();
                        pgConn=postGISConnectionObject.getConnection();
        String gpsCoordinates="";
        ArrayList gpsArray=new ArrayList();
        try {
            pst=conn.prepareStatement("select * from gpsData where tripId=?");
             pst.setInt(1,tripId);
             rs=pst.executeQuery();String gpsPoints="";
             
             while(rs.next()){
                 
                 gpsPoints=encryptorObject.decrypt(key1,key2,rs.getString("latitude"))+" "+encryptorObject.decrypt(key1,key2,rs.getString("longitude"));
                 gpsCoordinates=gpsCoordinates+"|"+gpsPoints;
                 gpsArray.add(gpsPoints);
             }
             ArrayList finalGpsArray=new ArrayList();
             String finalGps="";
             for(int k=0;k<gpsArray.size()-1;k++){
                 String gps1=gpsArray.get(k).toString();
                 String gps2=gpsArray.get(k+1).toString();
                 finalGps=finalGps+gps1+",";
                 finalGpsArray.add(finalGps);
                 //String pgsqlQuery="select st_distance(ST_Transform(ST_GeomFromText('POINT("+gps1+")',4326),2163),ST_Transform(ST_GeomFromText('POINT("+gps2+")',4326),2163))";
                
             }
             finalGps=finalGps.substring(0, finalGps.length()-1);
             String pgsqlQuery="select st_length(ST_GeomFromText('LINESTRING("+finalGps+")',4326))";
                        pst=pgConn.prepareStatement(pgsqlQuery);
                        rs=pst.executeQuery();
                        if(rs.next()){
                            distance=Float.valueOf(rs.getString("st_length"));
                            distArray.add(distance);
                        }
             
             
             System.out.println(distArray);
             System.out.println(gpsCoordinates);
        } catch (SQLException ex) {
            Logger.getLogger(getcoordinates.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(getcoordinates.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        
        
       
        */
        String password="/V5WIHrPHGjEUhwVhWogEQ==";
        String key="admin1@gmail.com";
        EncryptorObject encryptorObject=new EncryptorObject();
        String pwd=encryptorObject.decrypt(key, key, password);
        String a="b";
    }
}
