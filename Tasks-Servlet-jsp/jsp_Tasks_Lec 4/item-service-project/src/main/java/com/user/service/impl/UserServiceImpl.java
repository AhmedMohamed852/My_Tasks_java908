package com.user.service.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.sql.DataSource;

import com.user.model.UserAcount;
import com.user.service.UserService;

public class UserServiceImpl implements UserService {

    private DataSource datasource;

    public UserServiceImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    //____________________________________________________________________________
    @Override
    public boolean DeleatAccount(UserAcount user) {
     
    	Connection connection = null;
    	PreparedStatement statement = null;
    	
    	
    	try {
			connection = datasource.getConnection();
			String sql = "DELETE FROM user_acount WHERE username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());			
			  int rows = statement.executeUpdate();
		        return rows > 0;
          
      }
      
      catch (SQLException e)
      { 
          System.out.println("---> " + e.getMessage()); 
      } finally { 
          try { 
              if(connection != null) connection.close(); 
              if(statement != null) statement.close(); 
          } catch (SQLException e) { 
              System.out.println("----> " + e.getMessage()); 
          } 
      } 

      return false; 
    }
    
    
    //____________________________________________________________________________

    
    
    public boolean login(UserAcount user) {
    	if (!(isUserExists(user.getUsername() ,user.getUserpass()) )) {
    		return false; // ❌ المستخدم موجود بالفعل
    	}
    	
    	return true;
    }


    //____________________________________________________________________________
    // 🔎 تشيك هل اليوزر موجود بالـ username


    @Override
    public boolean signup(UserAcount user) {
        if (isUserExists(user.getUsername() , null)) {
            return false; // ❌ المستخدم موجود بالفعل
        }
        //____________________________________________________________________________

        
    	
        Connection connection = null; 
        PreparedStatement statement = null; 
        
        
        try  { 
        	
        		connection = datasource.getConnection(); 
        		String sql = "INSERT INTO user_acount (username, userpass) VALUES (?, ?)";
        		
        		statement = connection.prepareStatement(sql);
        		statement.setString(1, user.getUsername());
        		statement.setString(2, user.getUserpass());
        		

                statement.executeUpdate();
                
                return true;
          
            
        }
        
        catch (SQLException e)
        { 
            System.out.println("---> " + e.getMessage()); 
        } finally { 
            try { 
                if(connection != null) connection.close(); 
                if(statement != null) statement.close(); 
            } catch (SQLException e) { 
                System.out.println("----> " + e.getMessage()); 
            } 
        } 

        return false; 

    }

    
    
    //____________________________________________________________________________

    
    
    private boolean isUserExists(String username, String password) {  
        String sql;
        if (Objects.isNull(password)) {
            sql = "SELECT COUNT(*) FROM user_acount WHERE username = ?";
        } else {
            sql = "SELECT COUNT(*) FROM user_acount WHERE username = ? AND userpass = ?";
        }

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            if (password != null) {
                statement.setString(2, password);
            }

            try (ResultSet resultset = statement.executeQuery()) {
                if (resultset.next()) {
                    int count = resultset.getInt(1);
                    return count > 0; // true إذا موجود، false إذا صفر
                }
            }

        } catch (SQLException e) {
            System.out.println("---> " + e.getMessage());
        }

        return false;  
    }

    
    
}
