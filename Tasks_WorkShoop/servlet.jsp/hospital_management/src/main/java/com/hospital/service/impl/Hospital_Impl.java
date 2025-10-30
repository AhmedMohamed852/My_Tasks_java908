package com.hospital.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hospital.model.Hospital;
import com.hospital.service.Hospital_Service;

public class Hospital_Impl implements Hospital_Service {
	//____________________________________________________________________________
	
	private DataSource datasource ;
	public Hospital_Impl(DataSource datasource)
	{
		this.datasource = datasource;
	}
	
	
	@Override
	public List<Hospital> getAllDoctorsWithPatient() {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
				connection = datasource.getConnection();
				String sql = "SELECT * FROM APPOINTMENTS_h a JOIN DOCTORS_h d ON d.DOCTOR_ID = a.DOCTOR_ID JOIN PATIENTS_H p ON a.PATIENT_ID = p.PATIENT_ID";
				statement = connection.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				
				List<Hospital> doctorsWithPatient = new ArrayList<Hospital>();
				
				while(resultset.next())
				{
					Hospital h = new Hospital();
					
					h.setDOCTOR_ID(resultset.getLong("DOCTOR_ID"));
					h.setFIRST_NAME_D(resultset.getString("FIRST_NAME"));
					h.setLAST_NAME_D(resultset.getString("LAST_NAME"));
					h.setSPECIALIZATION(resultset.getString("SPECIALIZATION"));
					
					h.setPATIENT_ID(resultset.getLong("PATIENT_ID"));;
					h.setFIRST_NAME_P(resultset.getString("FIRST_NAME"));
					h.setLAST_NAME_P(resultset.getString("LAST_NAME"));
					h.setPHONE_P(resultset.getString("PHONE"));
					h.setStatus(resultset.getString("STATUS"));
					
					doctorsWithPatient.add(h);
				}
				
				return doctorsWithPatient;
			
			
			
		}  catch (SQLException e) 
			{
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
		
		
		
		return null;
	}
	//____________________________________________________________________________


	@Override
	public boolean addPatient(Hospital patient) {
		Connection connection = null;
		PreparedStatement statement = null;
		
try {
			connection = datasource.getConnection();
			System.out.println("StartImmpl");
			String sql = 	"INSERT INTO PATIENTS_h (PATIENT_ID , FIRST_NAME ,LAST_NAME ,PHONE) VALUES (? ,? ,? ,?)";
			System.out.println("____________________SQL");
			System.out.println( patient.getFIRST_NAME_P() + patient.getLAST_NAME_P()+patient.getPHONE_P());


			statement = connection.prepareStatement(sql);
			

			statement.setLong(1, patient.getPATIENT_ID()); 
			System.out.println("hire");
			statement.setString(2,patient.getFIRST_NAME_P());
			statement.setString(3, patient.getLAST_NAME_P());
			statement.setString(4, patient.getPHONE_P());
			System.out.println(patient.getPATIENT_ID() + patient.getFIRST_NAME_P() +patient.getLAST_NAME_P()+patient.getPHONE_P());

			
				System.out.println("00000000000000");
			 int rows = statement.executeUpdate();
	        return rows > 0;
	        
	}  		 catch (SQLException e) 
			{
				System.out.println("----> " + e.getMessage());
			}
		
		
		finally 
		{
			
			try 
			{
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} 
				
			catch (SQLException e) 
			{
				System.out.println("----> " + e.getMessage());
			}
	
	}
System.out.println("11111111111111111111111111111111");

		return false;
		
	}

}
