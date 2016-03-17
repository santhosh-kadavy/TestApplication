
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class EncryptData {
     
    public static void main(String[] args) {
       String tempKey1 = "santhoshkadavy@gmail.com"; // 128 bit key
       String key1=""; 
         if(tempKey1.length()<16){
           int lengthDiff=16-tempKey1.length();
           key1=tempKey1.concat(tempKey1.substring(0, lengthDiff));
        }else{
         key1=tempKey1.substring(tempKey1.length()-16);
        }
        String tempKey2 = "santhoshmale28-05-1985";
        String key2="";
        if(tempKey2.length()<16){
           int lengthDiff=16-tempKey2.length();
           key2=tempKey2.concat(tempKey2.substring(0, lengthDiff));
        }else{
         key2=tempKey2.substring(tempKey2.length()-16);
        }
        key2=key2.substring(key2.length()-16);
        Encryptor encryptor=new Encryptor();
        String name=encryptor.encrypt(key1,key2,"santhosh");
        String email=encryptor.encrypt(key1,key2,"santhoshkadavy@gmail.com");
        String country=encryptor.encrypt(key1,key2,"India");
        dataConnectionObject dco=new dataConnectionObject();
        try{
        Connection conn=dco.getConnection();
        PreparedStatement pst=conn.prepareStatement("insert into encryptData (name,email,country) values (?,?,?)");
        pst.setString(1,name);
        pst.setString(2,email);
        pst.setString(3,country);
        pst.executeUpdate();
        //String decryptedVal=encryptor.decrypt(key1, key2, encryptedVal);
        pst=conn.prepareStatement("insert into decryptData (name,email,country) values (?,?,?)");
        pst.setString(1,encryptor.decrypt(key1,key2,name));
        pst.setString(2,encryptor.decrypt(key1,key2,email));
        pst.setString(3,encryptor.decrypt(key1,key2,country));
        pst.executeUpdate();
        
       //System.out.println(encryptedVal);
       //System.out.println(decryptedVal);
    }   catch (SQLException ex) {
            Logger.getLogger(EncryptData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
}
