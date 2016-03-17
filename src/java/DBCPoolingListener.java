
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DBCPoolingListener implements ServletContextListener{
public void contextInitialized(ServletContextEvent sce){

        try {
// Obtain our environment naming context
Context envCtx = (Context) new InitialContext().lookup("java:comp/env");

// Look up our data source
DataSource  ds = (DataSource) envCtx.lookup("jdbc/cyclingApp");

sce.getServletContext().setAttribute("DBCPool", ds);
 } catch(NamingException e){ e.printStackTrace();
	}
}
public void contextDestroyed(ServletContextEvent sce){
}
}
