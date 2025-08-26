<%@ page language="java" contentType="text/html; charset=UTF-8"   
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>   
<html>   
<head>   
<meta charset="UTF-8">   
<title>User Information</title>   

<style> 
    body, h2, p, ul { 
        margin: 0; 
        padding: 0; 
    } 

    body { 
        font-family: 'Roboto', 'Helvetica Neue', Arial, sans-serif; 
        background-color: #e9ecef;
        color: #495057;
        line-height: 1.6; 
        padding: 40px; 
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    } 

    .container { 
        max-width: 600px; 
        background: #ffffff;
        margin: 0 auto; 
        padding: 40px; 
        border-radius: 10px; 
        box-shadow: 0 4px 12px rgba(0,0,0,0.15); 
        text-align: left;
    } 
    
    h2 { 
        color: #007bff;
        margin-bottom: 25px; 
        font-size: 2.2em; 
        border-bottom: 3px solid #007bff; 
        padding-bottom: 12px; 
        text-align: center;
    } 

    p { 
        font-size: 1.1em; 
        margin-bottom: 18px; 
    } 

    strong { 
        color: #343a40;
        font-weight: bold;
    } 

    ul { 
        list-style-type: none;
        margin-left: 0; 
        padding: 0;
        margin-bottom: 20px; 
    } 

    ul li { 
        background-color: #f8f9fa;
        padding: 12px 15px; 
        border-left: 4px solid #007bff;
        margin-bottom: 8px;
        border-radius: 4px;
        font-size: 1em; 
    } 
</style> 

</head>   
<body>   

<div class="container"> 

<% 
    // قراءة البيانات المرسلة من الفورم
    String name = request.getParameter("name");

    String password = request.getParameter("password");
    password = (password != null) ? password : "Not provided";

    String age = request.getParameter("Age");
    age = (age != null) ? age : "Not provided";

    String country = request.getParameter("Country");
    country = (country != null) ? country : "Not provided";

    String[] favorite = request.getParameterValues("favorite");
%> 

<h2>User Details</h2>  
<p><strong>Name:</strong> <%= name.toUpperCase() %></p>  
<p><strong>Password:</strong> <%= password %></p>  
<p><strong>Age:</strong> <%= age %></p>  
<p><strong>Country:</strong> <%= country %></p>  

<p><strong>Favorite items:</strong></p>  
<% if (favorite != null && favorite.length > 0) { %>  
    <ul>  
    <% for (String item : favorite) { %>  
        <li><%= item %></li>  
    <% } %>  
    </ul>  
<% } else { %>  
    <p>No favorites selected.</p>  
<% } %>  

</div>   

</body>   
</html>