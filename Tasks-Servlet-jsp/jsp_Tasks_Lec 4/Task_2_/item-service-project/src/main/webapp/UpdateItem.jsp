<%@ page language="java" contentType="text/html; charset=UTF-8"   
    pageEncoding="UTF-8"%>   
<%@ page import="com.item.model.*" %>    

<!DOCTYPE html>   
<html lang="en">   
<head>   
<meta charset="UTF-8">   
<title>Edit Item</title>   

<style>  
    body {  
        font-family: 'Poppins', Arial, sans-serif;  
        background: #f4f6f9;  
        display: flex;  
        justify-content: center;  
        align-items: center;  
        height: 100vh;  
        margin: 0;  
    }  

    .form-container {  
        background: #fff;  
        padding: 35px;  
        border-radius: 15px;  
        width: 420px;  
        box-shadow: 0 8px 24px rgba(0,0,0,0.1);  
        animation: fadeIn 0.6s ease-in-out;  
    }  

    h1 {  
        text-align: center;  
        color: #0d47a1;  
        margin-bottom: 25px;  
        font-size: 24px;  
        letter-spacing: 0.5px;  
    }  

    label {  
        display: block;  
        margin-top: 12px;  
        font-weight: 600;  
        color: #444;  
    }  

    input[type="text"] {  
        width: 100%;  
        padding: 12px;  
        margin-top: 6px;  
        border: 1px solid #ccc;  
        border-radius: 10px;  
        font-size: 15px;  
        transition: border-color 0.3s, box-shadow 0.3s;  
    }  

    input[type="text"]:focus {  
        border-color: #0d47a1;  
        box-shadow: 0 0 6px rgba(13,71,161,0.3);  
        outline: none;  
    }  

    .btn {  
        width: 100%;  
        margin-top: 20px;  
        padding: 14px;  
        background: linear-gradient(135deg, #0d47a1, #1565c0);  
        border: none;  
        color: white;  
        font-size: 16px;  
        font-weight: bold;  
        border-radius: 12px;  
        cursor: pointer;  
        transition: 0.3s ease;  
    }  

    .btn:hover {  
        background: linear-gradient(135deg, #1565c0, #0d47a1);  
        transform: translateY(-2px);  
    }  

    .back-btn {  
        display: block;  
        text-align: center;  
        margin-top: 15px;  
        padding: 10px;  
        background: #0d47a1;  
        color: #fff;  
        font-size: 14px;  
        border-radius: 8px;  
        text-decoration: none;  
        transition: 0.3s;  
    }  

    .back-btn:hover {  
        background: #1565c0;  
        transform: translateY(-2px);  
    }  

    @keyframes fadeIn {  
        from { opacity: 0; transform: translateY(-15px); }  
        to { opacity: 1; transform: translateY(0); }  
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

        <input type="submit" class="btn" value="Update Item"/>   
    </form>   

    <a href="/item-service-project/ItemController_java?action=listItems" class="back-btn">⬅ Back to Items</a>  
</div>  

</body>   
</html>
