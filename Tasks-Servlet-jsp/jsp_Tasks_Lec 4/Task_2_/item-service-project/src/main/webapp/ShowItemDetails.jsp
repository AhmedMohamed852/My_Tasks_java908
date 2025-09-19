<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ page import="com.item.model.*" %>   

<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>Item Details</title>  

    <style>  
        body {  
            font-family: 'Poppins', Arial, sans-serif;  
            background: #f4f6f9;  
            margin: 0;  
            padding: 20px;  
            color: #333;  
        }  

        .container {  
            max-width: 900px;  
            margin: 40px auto;  
            background: #fff;  
            padding: 25px;  
            border-radius: 12px;  
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

        table {  
            width: 100%;  
            border-collapse: collapse;  
            border-radius: 8px;  
            overflow: hidden;  
        }  

        thead th {  
            background: linear-gradient(135deg, #0d47a1, #1565c0);  
            color: #fff;  
            padding: 14px;  
            text-align: center;  
            font-size: 15px;  
        }  

        tbody td {  
            padding: 14px;  
            text-align: center;  
            border-bottom: 1px solid #eaeaea;  
            font-size: 14px;  
        }  

        tbody tr:nth-child(even) {  
            background-color: #f9f9f9;  
        }  

        tbody tr:hover {  
            background-color: #eef3f8;  
            transition: 0.3s;  
        }  

        /* Back button */  
        .btn {  
            display: inline-block;  
            margin-top: 20px;  
            padding: 10px 18px;  
            background: #0d47a1;  
            color: #fff;  
            font-size: 14px;  
            border: none;  
            border-radius: 8px;  
            text-decoration: none;  
            transition: 0.3s;  
        }  

        .btn:hover {  
            background: #1565c0;  
            transform: translateY(-2px);  
        }  

        @keyframes fadeIn {  
            from { opacity: 0; transform: translateY(20px); }  
            to { opacity: 1; transform: translateY(0); }  
        }  
    </style>  
</head>  
<body>  

<% Item item = (Item) request.getAttribute("showItem"); %>  

<div class="container">  
    <h1>📋 Item Details</h1>  

    <table>   
        <thead>   
            <tr>   
                <th>Manufacture Date</th>   
                <th>Expiry Date</th>   
                <th>Description</th>   
                <th>ID</th>   
            </tr>   
        </thead>   
        <tbody>   
            <tr>   
                <td><%= item.getManufacture_date() %></td>   
                <td><%= item.getExpiry_date() %></td>   
                <td><%= item.getDescription() %></td>   
                <td><%= item.getId_item() %></td>   
            </tr>   
        </tbody>   
    </table>  

    <div style="text-align:center;">  
        <a href="<%= request.getContextPath() %>/itemController?action=list" class="btn">⬅ Back to Items</a>  
    </div>  
</div>  

</body>  
</html>  
