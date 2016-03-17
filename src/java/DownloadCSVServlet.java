
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspe
 */
public class DownloadCSVServlet extends HttpServlet{
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dataConnectionObject dco=new dataConnectionObject();
        Connection conn=dco.getConnection();
        try {
            String timeStamp= String.valueOf(System.currentTimeMillis());
            PreparedStatement pst=conn.prepareStatement("select * from gpsData");
            ResultSet rs=pst.executeQuery();
                    if (rs.last()) {
                        int rows = rs.getRow();
                        // Move to beginning
                        rs.beforeFirst();
           
            }
            int colNo=rs.getMetaData().getColumnCount();
            System.out.println("ColumnCout"+colNo);
            File delFile=new File("/tmp/test1445318275428.csv");
            delFile.delete();
            File file=new File("/tmp/test"+timeStamp+".csv");
            FileOutputStream fos=new FileOutputStream(file,false);  
            Writer out = new OutputStreamWriter(new BufferedOutputStream(fos));      

            for (int j=1; j<(colNo-1); j++) {     
            out.append(rs.getMetaData().getColumnName (j));       
            if (j<colNo-2) out.append(","); else out.append("\r\n");      
            
            }   
            int m =1;    
            
            while (rs.next()) {   

            for (int k=1; k<(colNo-1); k++) {   

            out.append(rs.getString(k));    

            if (k<colNo-2) out.append(","); else out.append("\r\n");    
            }   
            //System.out.println("No of rows"+m);   
            m++;
            if(m==194){
                int a=1;
            }
            out.flush();
            fos.flush();
            }  
            
            FileInputStream inStream = new FileInputStream(file);
        ServletContext context = getServletContext();
         String filePath = "/tmp/test"+timeStamp+".csv";
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) file.length());
        
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
        response.setHeader(headerKey, headerValue);
        
         OutputStream outStream = response.getOutputStream();
         
          byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(downloadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(downloadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(downloadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(downloadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    }

