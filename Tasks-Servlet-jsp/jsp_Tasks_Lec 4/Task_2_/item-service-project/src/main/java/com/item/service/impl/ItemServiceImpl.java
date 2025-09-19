package com.item.service.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;

public class ItemServiceImpl implements ItemService{
	//____________________________________________________________________________
	
	private DataSource datasource ;
	public ItemServiceImpl(DataSource datasource) {
		this.datasource = datasource;
		
	}
	//____________________________________________________________________________

	@Override
	public boolean addItem(Item item) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
				connection = datasource.getConnection();
				statement = connection.createStatement();
				
				String sql = "INSERT INTO item (NAME , PRICE ,TOTAL_NUMBER) VALUES ('"
				+ item.getName() +"' , "
				+ item.getPrice() + ","
				+ item.getTotalNumber() + ")";
				 statement.executeQuery(sql);
								
				return true;
	
			} 
		
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("---> " + e.getMessage());
			}
finally {
			
			
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("----> " + e.getMessage());
			}

	}
		
		return false;
	}
	
	//____________________________________________________________________________

	@Override
	public boolean removeItem(long id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		try {
				connection = datasource.getConnection();
				
				String sqlDetals = "DELETE FROM item_details WHERE id_item = ?";
				statement = connection.prepareStatement(sqlDetals);
				statement.setLong(1, id);
				statement.executeUpdate();		
				
				String sql = "DELETE FROM item WHERE id = ?" ;
				statement = connection.prepareStatement(sql);
				statement.setLong(1, id);
				
				  int rows = statement.executeUpdate();
			        return rows > 0;
					
		} 
		
catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("---> " + e.getMessage());
		}
	
finally {
		
		
				try {
					if(connection != null) connection.close();
					if(statement != null) statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("----> " + e.getMessage());
				}

		}
	
		return false;
		
	
	}
	
	//____________________________________________________________________________

	@Override
	public boolean editItem(Item item) {
		
		Connection connection = null;
		Statement statement = null;
		
		
		try {
				connection = datasource.getConnection();
				statement = connection.createStatement();
				String sql = "UPDATE item SET NAME = '" + item.getName() + "' , "
				+ "PRICE = " + item.getPrice() +" , "
				+ "TOTAL_NUMBER = " + item.getTotalNumber() + 
				"WHERE ID = " + item.getId();
				
				statement.executeQuery(sql);
				
				return true;
					
		} 
		
catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("---> " + e.getMessage());
		}
	
finally {
		
		
				try {
					if(connection != null) connection.close();
					if(statement != null) statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("----> " + e.getMessage());
				}

		}
	
		return false;
		
	}
	
	//____________________________________________________________________________

	@Override
	public Item loadItem(long id) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
				connection = datasource.getConnection();
				statement = connection.createStatement();
				String sql = "SELECT * FROM item WHERE id = " + id;
				ResultSet resultset = statement.executeQuery(sql);
				
				Item item =null;
				
				if(resultset.next())
				{
					item = new Item();
					item.setId(resultset.getLong("id"));
					item.setName(resultset.getString("name"));
					item.setPrice(resultset.getDouble("price"));
					item.setTotalNumber(resultset.getInt("total_number"));
				}
				
				return item;
				
			} 
		
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("---> " + e.getMessage());
			}
		
finally {
			
			
				try {
					if(connection != null) connection.close();
					if(statement != null) statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("----> " + e.getMessage());
				}
			
			
		
		}
		
		System.out.println("Item Not Found");
		return null;

	}
	
	//____________________________________________________________________________

	@Override
	public List<Item> loadItems() {
		
		Connection connection = null;
		Statement statement = null;
		
		
		try {
			connection = datasource.getConnection();
			statement = connection.createStatement();
			
			 String sql = "SELECT i.id, i.name, i.price, i.total_number, " +
                     "       CASE WHEN d.id_item IS NOT NULL THEN 1 ELSE 0 END AS hasDetails " +
                     "FROM item i " +
                     "LEFT JOIN item_details d ON i.id = d.id_item " +
                     
                     "ORDER BY i.id";		
			 
			 ResultSet resultset = statement.executeQuery(sql);
			
			List<Item> items = new ArrayList<>();
			
			
			while(resultset.next())
			{
				
				Item item = new Item();
				
				item.setId(resultset.getLong("ID"));
				item.setName(resultset.getString("NAME"));
				item.setPrice(resultset.getDouble("PRICE"));
				item.setTotalNumber(resultset.getInt("TOTAL_NUMBER"));
	            item.setHasDetails(resultset.getInt("hasDetails") == 1); // boolean

				
				items.add(item);
			
			}
			
			return items;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("----> " + e.getMessage());
		}finally {
			
			
				try {
					if(connection != null) connection.close();
					if(statement != null) statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("----> " + e.getMessage());
				}
			
		}
		
		return new ArrayList<>();
		

	}

	@Override
	public boolean addItemDetails(Item item) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = datasource.getConnection();
			String sql = "INSERT INTO item_details" +
			"(manufacture_date, expiry_date , description , id_item)VALUES (? ,? ,? ,?)";
			
			statement = connection.prepareStatement(sql);
			

			statement.setDate(1, item.getManufacture_date()); 
			statement.setDate(2, item.getExpiry_date());
			statement.setString(3, item.getDescription());
			statement.setLong(4, item.getId_item());
			
			  int rows = statement.executeUpdate();
		        return rows > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("----> " + e.getMessage());
		}
		finally {
			
			
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("----> " + e.getMessage());
			}
		
		
	
	}
		
		
		return false;
	}

	
	@Override
	public Item showItemDetails(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
	    ResultSet resultset = null;

		
		try {
			connection = datasource.getConnection();
			String sql = "SELECT * FROM item_details WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			
		    resultset = statement.executeQuery();

	        if(resultset.next()) {
	            Item item = new Item();
	            item.setManufacture_date(resultset.getDate("manufacture_date"));
	            item.setExpiry_date(resultset.getDate("expiry_date"));
	            item.setDescription(resultset.getString("description"));
	            item.setId_item(resultset.getLong("id_item"));
	            return item;
	        } else {
	            return null; // ما لقيتش عنصر
	        }
				
		} catch (SQLException e) {
			System.out.println("----> " + e.getMessage());
		}
		
		
		finally {
			
			
			try {
				if(resultset != null) resultset.close();
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} catch (SQLException e) {
				System.out.println("----> " + e.getMessage());
			}
	
	}
	
		return null;
	}
	
	

	@Override
	public boolean updateItemDetails(Item item) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = datasource.getConnection();
			String sql = "UPDATE item_details set MANUFACTURE_DATE = ? ,EXPIRY_DATE = ? ,DESCRIPTION = ? WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setDate(1, item.getManufacture_date());
			statement.setDate(2, item.getExpiry_date());
			statement.setString(3, item.getDescription());
			statement.setLong(4, item.getId_item());
			
			int rows = statement.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("----> " + e.getMessage());
		}
		
		
		finally {
			
			
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
	
	

	
	
}









