package com.user.controller;

import java.io.IOException;
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

import com.user.model.UserAcount;
import com.user.service.UserService;
import com.user.service.impl.UserServiceImpl;

@WebServlet("/userController")
public class userController extends HttpServlet {
    @Resource(name = "jdbc/item")
    private DataSource datasource;
    
    
    UserService userserviceimpl ;
   public void init() throws ServletException {
	   super.init();
	   userserviceimpl = new UserServiceImpl(datasource);
   }

    //_____________________________________________________________________________________
    //_____________________________________________________________________________________
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String action = request.getParameter("action");

        if (Objects.isNull(action)) {
            action = "login";
        }

        switch (action) {
            case "signup":
                signup(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "deleatAccount":
                deleatAccount(request, response);
                break;
            case "forgotPassword":
            	forgotPassword(request, response);
            	break;
            default:
                login(request, response);
        }
    }
    
    

    private void forgotPassword(HttpServletRequest request, HttpServletResponse response) {
		
    	   String name = request.getParameter("name");

           UserAcount user = new UserAcount(name);

           boolean result = userserviceimpl.loginWithUserName(user);
           
           
           if(result)
           {	
        	   request.setAttribute("actionsource", "login");
        	   request.setAttribute("loginresult", result);
        	   HttpSession session = request.getSession();
        	   session.setAttribute("sessionUserIsLogin", user);
        	   
        	   
        	   Cookie userCookie = new Cookie("cookieUserIsLogin" , user.getUsername() );
        	   userCookie.setMaxAge(60*60);
        	   userCookie.setHttpOnly(true);   // حماية من JS
        	   userCookie.setSecure(false);    // true لو شغال HTTPS
        	   userCookie.setPath("/");  
        	   response.addCookie(userCookie);
        	   
               try {
            	    response.sendRedirect(request.getContextPath() + "/ItemController_java?action=getItems");
    		} catch (IOException e) {
    			 System.out.println("---> " + e.getMessage());
    		} 
           }else {
        	   request.setAttribute("error", "Invalid username!");
        	    try {
    				request.getRequestDispatcher("/login.jsp").forward(request, response);
    			} catch (ServletException | IOException e) {
    				 System.out.println("---> " + e.getMessage());
    			} 
           }

           
          
	}

	private void deleatAccount(HttpServletRequest request, HttpServletResponse response) {
    	
    	HttpSession session = request.getSession();
    	
    	if(session == null || session.getAttribute("sessionUserIsLogin") == null)
    	{
    		try {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} catch (IOException e) {
				System.out.println("---> " + e.getMessage());
			}
    		return;
    	}
    	
    	 UserAcount user = (UserAcount) session.getAttribute("sessionUserIsLogin");
    	 
    	 boolean result = userserviceimpl.DeleatAccount(user);
    	 
    	 if(result)
    	 {
    		 Cookie usercookie = new Cookie("cookieUserIsLogin" , "");
    		 usercookie.setMaxAge(0);
    		 usercookie.setPath("/");
    		 response.addCookie(usercookie);
    		 
    		 
    		 session.invalidate();
    		 
    		 try {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("---> " + e.getMessage());
			}
    	 }else {
    	        try {
    	            response.getWriter().write("❌ Failed to delete account!");
    	        } catch (IOException e) {
    				System.out.println("---> " + e.getMessage());
    	        }
    	    }
	}
    
   
    
    
    
    
    
    
    
    
    
    
    
    //____________________________________________________________________________________________

    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    //________________________ LOGIN ________________________
    //____________________________________________________________________________________________

    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // لو مفيش بيانات لسه → ارجع login.jsp
        if (request.getParameter("name") == null) 
        {
            try 
            {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } 
            catch (ServletException | IOException e) 
            {
                System.out.println("---> " + e.getMessage());
            }
            return;
        }
        
 //____________________________________________________________________________________________
        
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserAcount user = new UserAcount(name, password);

        boolean result = userserviceimpl.login(user);
        
       if(result)
       {	
    	   request.setAttribute("actionsource", "login");
    	   request.setAttribute("loginresult", result);
    	   HttpSession session = request.getSession();
    	   session.setAttribute("sessionUserIsLogin", user);
    	   
    	   
    	   Cookie userCookie = new Cookie("cookieUserIsLogin" , user.getUsername() );
    	   userCookie.setMaxAge(60*60);
    	   userCookie.setHttpOnly(true);   // حماية من JS
    	   userCookie.setSecure(false);    // true لو شغال HTTPS
    	   userCookie.setPath("/");  
    	   response.addCookie(userCookie);
    	   
           try {
        	    response.sendRedirect(request.getContextPath() + "/ItemController_java?action=getItems");
		} catch (IOException e) {
			 System.out.println("---> " + e.getMessage());
		} 
       }else {
    	   request.setAttribute("error", "Invalid username or password!");
    	    try {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				 System.out.println("---> " + e.getMessage());
			} 
       }

     
    }

    //________________________ SIGNUP ________________________
    //____________________________________________________________________________________________
    

    private void signup(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserAcount user = new UserAcount( name, password);

        boolean result = userserviceimpl.signup(user);

        // أرسل حالة التسجيل للـ login.jsp
        request.setAttribute("actionsource", "signup");
        request.setAttribute("signupresult", result);

        try {
            // إحالة المستخدم إلى login.jsp بعد Sign Up
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println("---> " + e.getMessage());
        }
    }

}
