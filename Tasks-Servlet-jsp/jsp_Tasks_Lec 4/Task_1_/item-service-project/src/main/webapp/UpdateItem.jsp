<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ page import="com.item.model.*" %>  
     
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Edit Item</title> 

<style>
    /* General Styling */
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #f9fbfd, #eef3f8);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    /* Form Container */
    .form-container {
        background: #fff;
        padding: 30px;
        border-radius: 15px;
        width: 420px;
        box-shadow: 0 6px 18px rgba(0, 0, 0, 0.08);
        transition: transform 0.2s ease-in-out;
    }

    .form-container:hover {
        transform: translateY(-4px);
    }

    /* Title */
    h1 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 25px;
        font-size: 24px;
    }

    /* Labels */
    label {
        display: block;
        margin-top: 12px;
        font-weight: 600;
        color: #444;
    }

    /* Input Fields */
    input[type="text"] {
        width: 100%;
        padding: 12px;
        margin-top: 6px;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 15px;
        transition: border-color 0.3s ease;
    }

    input[type="text"]:focus {
        border-color: #74b9ff;
        outline: none;
    }

    /* Submit Button */
    input[type="submit"] {
        width: 100%;
        margin-top: 20px;
        padding: 12px;
        background: linear-gradient(135deg, #74b9ff, #0984e3);
        border: none;
        color: white;
        font-size: 16px;
        font-weight: bold;
        border-radius: 8px;
        cursor: pointer;
        transition: all 0.3s ease;
    }

    input[type="submit"]:hover {
        background: linear-gradient(135deg, #0984e3, #74b9ff);
        transform: scale(1.03);
    }
</style>
</head> 
<body> 

<%
    Item item = (Item) request.getAttribute("item"); 
%> 

<div class="form-container">
    <h1>✏ Edit Item</h1>

    <form action="/item-service-project/ItemController_java" method="post"> 
        <input type="hidden" name="action" value="editItem"> 
        <input type="hidden" name="id" value="<%= item.getId() %>"> 

        <label>Name:</label> 
        <input type="text" name="name" value="<%= item.getName() %>" required> 

        <label>Price:</label> 
        <input type="text" name="price" value="<%= item.getPrice() %>" required> 

        <label>Total Number:</label> 
        <input type="text" name="totalNumber" value="<%= item.getTotalNumber() %>" required> 

        <input type="submit" value="Update Item"/> 
    </form> 
</div>

</body> 
</html>
