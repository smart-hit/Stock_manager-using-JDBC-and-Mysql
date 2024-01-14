package dao;
import java.sql.*;
import connectionManager.ConnectionManager;
import modal.admindetails;
public class LoginDAO {
    public boolean loginValidation(admindetails l) throws ClassNotFoundException, SQLException {
    	String username=l.getUsername();
    	String password=l.getPass();
    	ConnectionManager conm=new ConnectionManager();
    	Connection con=conm.establishConnection();
    	Statement st=con.createStatement();
    	
    	ResultSet rs=st.executeQuery("Select * from admindetails");
    	while(rs.next()) {
    		if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password"))) {
    			conm.closeConnection();
    			return true;
    		}
    	}
    	conm.closeConnection();
    	return false;
    }
}
