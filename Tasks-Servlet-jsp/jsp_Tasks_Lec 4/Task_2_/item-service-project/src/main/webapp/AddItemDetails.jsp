<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ page import="com.item.model.*" %>   

<!DOCTYPE html> 
<html lang="en"> 
<head> 
<meta charset="UTF-8"> 
<title>Edit Item</title> 

<style>
    /* Reset */
    * { margin: 0; padding: 0; box-sizing: border-box; }

    body {
        font-family: 'Poppins', Arial, sans-serif;
        background: #f4f6f9;
        color: #222;
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .container {
        width: 420px;
        background: #fff;
        border-radius: 12px;
        padding: 35px 28px;
        box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
        animation: fadeIn 0.6s ease-in-out;
    }

    h1 {
        text-align: center;
        font-size: 22px;
        margin-bottom: 25px;
        color: #0d47a1;
        letter-spacing: 0.5px;
    }

    label {
        display: block;
        margin-bottom: 6px;
        font-size: 14px;
        font-weight: 600;
        color: #444;
    }

    input[type="text"],
    input[type="date"] {
        width: 100%;
        padding: 10px 12px;
        margin-bottom: 18px;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 14px;
        transition: 0.3s;
    }

    input:focus {
        border-color: #0d47a1;
        box-shadow: 0 0 6px rgba(13, 71, 161, 0.25);
        outline: none;
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 8px;
        background: #0d47a1;
        color: #fff;
        font-size: 15px;
        font-weight: 600;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: #1565c0;
        transform: translateY(-2px);
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(15px); }
        to { opacity: 1; transform: translateY(0); }
    }
</style>

</head> 
<body> 

<% 
    Item item = (Item) request.getAttribute("item");  
%>  

<div class="container"> 
    <h1>✏ Edit Item</h1> 

    <form action="/item-service-project/ItemController_java" method="post">  
        <input type="hidden" name="action" value="updateItemDetails">  
        <input type="hidden" name="id" value="<%= item.getId() %>">  

        <label>Manufacture Date:</label>  
        <input type="date" name="manufacture_date" value="<%= item.getManufacture_date() %>" required>  

        <label>Expiry Date:</label>  
        <input type="date" name="expiry_date" value="<%= item.getExpiry_date() %>" required>  

        <label>Description:</label>  
        <input type="text" name="description" value="<%= item.getDescription() %>" required>  
         
        <input type="hidden" name="id_item" value="<%= item.getId() %>">  

        <input type="submit" value="💾 Update Item Details"/>  
    </form>  
</div> 

</body> 
</html>
