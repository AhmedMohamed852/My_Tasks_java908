package com.item.service.impl;

import java.sql.Statement;
import java.sql.Connection;
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
				System.out.println("---> " + e.getMessage());
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

	@Override
	public boolean removeItem(long id) {
		
		Connection connection = null;
		Statement statement = null;
		
		
		try {
				connection = datasource.getConnection();
				statement = connection.createStatement();
				String sql = "DELETE FROM item WHERE id = " + id ;
				
				statement.executeQuery(sql);
				
				return true;
					
		} 
		
catch (SQLException e) 
		{
			System.out.println("---> " + e.getMessage());
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
				System.out.println("---> " + e.getMessage());
			}
		
finally {
			
			
				try {
					if(connection != null) connection.close();
					if(statement != null) statement.close();
				} catch (SQLException e) {
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
			String sql = "SELECT * FROM item ORDER BY ID";
			ResultSet resultset = statement.executeQuery(sql);
			
			List<Item> items = new ArrayList<>();
			
			
			while(resultset.next())
			{
				
				Item item = new Item();
				
				item.setId(resultset.getLong("ID"));
				item.setName(resultset.getString("NAME"));
				item.setPrice(resultset.getDouble("PRICE"));
				item.setTotalNumber(resultset.getInt("TOTAL_NUMBER"));
				
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
	
	//____________________________________________________________________________
	
	

}
