<%@ page language="java" contentType="text/html; charset=UTF-8"   
    pageEncoding="UTF-8"%>   
<%@ page import="com.item.model.*" %>    

<!DOCTYPE html>   
<html lang="en">   
<head>   
    <meta charset="UTF-8">   
    <title>Update Item Details</title>   

    <style>  
        body {  
            font-family: 'Poppins', Arial, sans-serif;  
            background: #f4f6f9;  
            margin: 0;  
            padding: 20px;  
            color: #333;  
            display: flex;  
            justify-content: center;  
            align-items: center;  
            height: 100vh;  
        }  

        .form-container {  
            background: #fff;  
            padding: 35px;  
            border-radius: 15px;  
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);  
            width: 420px;  
            animation: fadeIn 0.6s ease-in-out;  
        }  

        h2 {  
            text-align: center;  
            color: #0d47a1;  
            margin-bottom: 25px;  
            font-size: 24px;  
            letter-spacing: 0.5px;  
        }  

        label {  
            display: block;  
            margin: 12px 0 6px;  
            font-weight: 600;  
            color: #444;  
        }  

        input[type="text"],  
        input[type="date"] {  
            width: 100%;  
            padding: 12px;  
            margin-bottom: 18px;  
            border-radius: 10px;  
            border: 1px solid #ccc;  
            font-size: 15px;  
            transition: border-color 0.3s, box-shadow 0.3s;  
        }  

        input[type="text"]:focus,  
        input[type="date"]:focus {  
            border-color: #0d47a1;  
            box-shadow: 0 0 6px rgba(13,71,161,0.3);  
            outline: none;  
        }  

        input[type="submit"] {  
            width: 100%;  
            background: linear-gradient(135deg, #0d47a1, #1565c0);  
            color: white;  
            padding: 14px;  
            border: none;  
            border-radius: 12px;  
            font-size: 16px;  
            font-weight: bold;  
            cursor: pointer;  
            transition: 0.3s ease;  
        }  

        input[type="submit"]:hover {  
            background: linear-gradient(135deg, #1565c0, #0d47a1);  
            transform: translateY(-2px);  
        }  

        .btn-back {  
            display: block;  
            margin: 20px auto 0;  
            padding: 10px 18px;  
            background: #0d47a1;  
            color: #fff;  
            font-size: 14px;  
            border-radius: 8px;  
            text-decoration: none;  
            text-align: center;  
            transition: 0.3s;  
            width: 60%;  
        }  

        .btn-back:hover {  
            background: #1565c0;  
            transform: translateY(-2px);  
        }  

        @keyframes fadeIn {  
            from { opacity: 0; transform: translateY(-20px); }  
            to { opacity: 1; transform: translateY(0); }  
        }  
    </style>  
</head>   
<body>   

    <div class="form-container">  
        <h2>✏ Update Item Details</h2>  
        <% Item item = (Item) request.getAttribute("item") ;%>   

        <form action="/item-service-project/ItemController_java" method="post">     
            <input type="hidden" name="action" value="updateItemDetails">     
            <input type="hidden" name="id" value="<%= item.getId() %>">     

            <label>Manufacture Date:</label>     
            <input type="date" name="manufacture_date" value="<%=item.getManufacture_date() %>" required>     

            <label>Expiry Date:</label>     
            <input type="date" name="expiry_date" value="<%=item.getExpiry_date() %>" required>     

            <label>Description:</label>     
            <input type="text" name="description" value="<%=item.getDescription() %>" required>     

            <input type="hidden" name="id_item" value="<%= item.getId() %>">     

            <input type="submit" value="Update Details"/>     
        </form>  

        <a href="<%= request.getContextPath() %>/itemController?action=list" class="btn-back">⬅ Back to Items</a>  
    </div>  

</body>   
</html>
