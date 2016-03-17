/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.sql.DataSource;

/**
 *
 * @author itspe
 */
public class CheckConnectionPoolServlet extends HttpServlet {

    private DataSource datasource = null;
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            datasource=(DataSource) getServletContext().getAttribute("DBCPool");
            conn=datasource.getConnection();
            pst = conn.prepareStatement("select * from UserProfileTable where emailId=?");
            pst.setString(1, "sdsdlkf");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnectionPoolServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
