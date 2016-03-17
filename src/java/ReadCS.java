
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ReadCS {
    public static void main(String[] args) {
        
    String csvFile = "/home/itspe/tripData.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";

           dataConnectionObject dco=new dataConnectionObject();
           Connection conn=dco.getConnection();
           PreparedStatement pst=null;
           ResultSet rs=null;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                // use comma as separator
                String[] coordinates = line.split(cvsSplitBy);
                pst=conn.prepareStatement("insert into CSVData (latitude,longitude) values (?,?)");
                pst.setString(1,coordinates[0]);
                pst.setString(2,coordinates[1]);
                pst.executeUpdate();
                System.out.println("coordinates [latitude= " + coordinates[0]
                        + " , name=" + coordinates[1] + "]");
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCS.class.getName()).log(Level.SEVERE, null, ex);
        
	}catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
            Logger.getLogger(ReadCS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
}
