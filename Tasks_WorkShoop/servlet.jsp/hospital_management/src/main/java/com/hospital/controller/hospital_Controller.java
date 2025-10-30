package com.hospital.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.hospital.model.Hospital;
import com.hospital.service.Hospital_Service;
import com.hospital.service.impl.Hospital_Impl;


@WebServlet("/HospitalController")
public class hospital_Controller extends HttpServlet {
	@Resource(name = "Hospital/Controller" )
	private DataSource datasourse;       

	Hospital_Service hospital_Service;
	
	public void init() throws ServletException
	{
		super.init();
		hospital_Service = new Hospital_Impl(datasourse);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(Objects.isNull(action))
		{
			action = "getAllDoctorsWithPatient";
		}
		
		switch(action)
		{
			case "getAllDoctorsWithPatient": getAllDoctorsWithPatient(request ,response); 
			break;
			case "addDoctor": addDoctor(request ,response); 
			break;
			case "addPatient": addPatient(request ,response); 
			break;
		
			 default :
				 getAllDoctorsWithPatient(request ,response); 
		
		}
	}

	
	private void addPatient(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Starrrrt");
		
		 if (request.getParameter("ID") == null || request.getParameter("ID").isEmpty() ) {

		        try {
					request.getRequestDispatcher("/addPatient.html").forward(request, response);
				} catch (ServletException | IOException e) {
					System.out.println("---> " + e.getMessage());
				} 
		        return ;
		    }
		
		
		Long id = Long.parseLong(request.getParameter("ID"));
		String fn = request.getParameter("FN");
		String ln = request.getParameter("LN");
		String ph = request.getParameter("PH");
		System.out.println(id + fn +ln+ph);

		Hospital patient = new Hospital(id ,fn ,ln ,ph);
		
		boolean result = hospital_Service.addPatient(patient);
		System.out.println(result);

		
		if(result)
		{
			getAllDoctorsWithPatient(request ,response);
		}else {
			System.out.println("Faild add");
		}
		
		
	}


	private void addDoctor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void getAllDoctorsWithPatient(HttpServletRequest request, HttpServletResponse response) {
		
		List<Hospital> hospital = hospital_Service.getAllDoctorsWithPatient();
		
		request.setAttribute("details", hospital);
		
		try {
			request.getRequestDispatcher("/showDocWithPatients.jsp").forward(request, response);
		}  catch (ServletException | IOException e) {
			System.out.println("---> " + e.getMessage());
		} 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
