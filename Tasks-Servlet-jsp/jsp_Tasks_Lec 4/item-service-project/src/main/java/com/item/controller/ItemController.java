package com.item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;
import com.item.service.impl.ItemServiceImpl;
import com.user.model.UserAcount;
/**
 * Servlet implementation class ItemController_java
 */

//_____________________________________________________________________________________


@WebServlet("/ItemController_java")
public class ItemController extends HttpServlet {
	@Resource(name = "jdbc/item" )
	private DataSource datasourse;
	
	ItemService itemservice ;

	public void init() throws ServletException {
		super.init();
		itemservice = new ItemServiceImpl(datasourse);
		
	}
	//_____________________________________________________________________________________



	//http://localhost:8080/item-service-project/ItemController_java?Action=getItems
	//http://localhost:8080/item-service-project/ItemController_java?Action=addItems
	//http://localhost:8080/item-service-project/ItemController_java?Action=getItem
	//http://localhost:8080/item-service-project/ItemController_java?Action=addItem
	//http://localhost:8080/item-service-project/ItemController_java?Action=editItem
	//http://localhost:8080/item-service-project/ItemController_java?Action=deleteItem
	//http://localhost:8080/item-service-project/ItemController_java?Action=logout
	//http://localhost:8080/item-service-project/ItemController_java?Action=fkfjas
	//https://localhost:/8080/item-service-project//ItemController_java?Action="NoAction"
	
	//_____________________________________________________________________________________

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("sessionUserIsLogin") == null) {
			
			
			Cookie[] cookies = request.getCookies();
			
			String userNameForCookie = null;
			
			if(Objects.nonNull(cookies))
			{
				for(Cookie cookie : cookies)
				{
					if("cookieUserIsLogin".equals(cookie.getName()))
					{
						userNameForCookie = cookie.getValue();
					}
				}
			}
			
			if(userNameForCookie != null)
			{
				UserAcount user = new UserAcount(userNameForCookie , null);
				
				session = request.getSession(true);
				
				session.setAttribute("sessionUserIsLogin", user);
			}else { 
		        // مفيش كوكي → رجع للـ login
		        response.sendRedirect(request.getContextPath() + "/login.jsp"); 
		        return; 
		    }
			
		}
		
		
		String action = request.getParameter("action");
		
		if(Objects.isNull(action))
		{
			action = "getItems";
		}
		
		switch(action)
		{
		case "getItems": getItems(request ,response); 
			
			break;
		case "getItem": getItem(request ,response); 
			
			break;
		case "addItem": addItem(request ,response); 
			
			break;
		case "editItem": editItem(request ,response); 
			
			break;
		case "deleteItem": deleteItem(request ,response); 
			
			break;
		case "logout": logout(request ,response); 
		
		break;
			 default :
				 getItems(request ,response); 
		
		
		
		}
		
		
		
		
	}	
	
	//_____________________________________________________________________________________

	
	
private void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		Cookie userCookie  = new Cookie("cookieUserIsLogin" , "");
		userCookie.setMaxAge(0);   // يعني امسح الكوكي فورًا
		userCookie.setPath("/"); 
		response.addCookie(userCookie);
		
		
		if(session != null)
		{
			session.invalidate();
		}
		
		
		try {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} catch (IOException e) {
			System.out.println("---> " + e.getMessage());
		}
		

	}

//_____________________________________________________________________________________

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

//_______________________________________________________________________
	
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		
		boolean isItemDeleted = itemservice.removeItem(id);
		
		getItems(request ,response);
		
	}

//_____________________________________________________________________________________


	private void editItem(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * Long id = Long.parseLong(request.getParameter("id")); String nameItem
		 * =request.getParameter("name"); double price =
		 * Double.parseDouble(request.getParameter("price")); int totalNumber
		 * =Integer.parseInt(request.getParameter("total_number"));
		 * 
		 * Item item = new Item(id ,nameItem , price , totalNumber);
		 */

		Item item = itemDetails(request ,response);
		
		boolean isUpdated = itemservice.editItem(item);
		
		List<Item> items =  null;
		
		  if (isUpdated) { items = itemservice.loadItems();}
		
		request.setAttribute("allItems" ,items);
		
		try {
			request.getRequestDispatcher("/showItems.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("---> " + e.getMessage());
		} 
		

		
	} 
	
	
//_____________________________________________________________________________________


	private void addItem(HttpServletRequest request, HttpServletResponse response) {

		
		 if (request.getParameter("name") == null) {
		        request.setAttribute("additem", null); 
		        
		        try {
					request.getRequestDispatcher("/addItem.html").forward(request, response);
				} catch (ServletException | IOException e) {
					System.out.println("---> " + e.getMessage());
				} 
		        return ;
		    }
		 
		
			/*
			 * String nameItem =request.getParameter("name"); double price =
			 * Double.parseDouble(request.getParameter("price")); int totalNumber
			 * =Integer.parseInt(request.getParameter("totalNumber"));
			 * 
			 * Item item = new Item(nameItem , price , totalNumber);
			 */
		 
		 Item item = itemDetails(request ,response);

		boolean succsessAdItem = itemservice.addItem(item);
		
		getItems(request ,response);
	}

//_____________________________________________________________________________________



	private void getItem(HttpServletRequest request, HttpServletResponse response) {
		
		long id =Long.parseLong(request.getParameter("id")); 
		Item item = itemservice.loadItem(id);
		
	
		request.setAttribute("item" ,item);
		
		try {
			request.getRequestDispatcher("/UpdateItem.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("---> " + e.getMessage());
		} 
		
		
	}


//_____________________________________________________________________________________

	private void getItems(HttpServletRequest request, HttpServletResponse response) {

		
		List <Item> items = itemservice.loadItems();
		
		request.setAttribute("allItems" ,items);
		
		try {
			request.getRequestDispatcher("/showItems.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("---> " + e.getMessage());
		} 
		
	}
	
	
	//_____________________________________________________________________________________

	
	
	private Item itemDetails(HttpServletRequest request ,HttpServletResponse response)
	{
		Long id ;
		
		if(Long.parseLong((request.getParameter("id"))) == 0)
		{
			 id = (long) 0;
		}else {
			 id = Long.parseLong(request.getParameter("id"));
		}

		String nameItem =request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int totalNumber =Integer.parseInt(request.getParameter("totalNumber"));
		
		Item item = new Item(id ,nameItem , price , totalNumber);

		return item;
	}
}
//_____________________________________________________________________________________


