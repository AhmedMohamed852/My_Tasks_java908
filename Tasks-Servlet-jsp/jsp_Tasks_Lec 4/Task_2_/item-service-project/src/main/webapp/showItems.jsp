<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ page import="java.util.List" %>  
<%@ page import="com.item.model.*" %>  

<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <title>Show Items</title>  

    <style>  
        body {  
            font-family: 'Poppins', Arial, sans-serif;  
            background: #f4f6f9;  
            margin: 0;  
            padding: 20px;  
            color: #333;  
        }  

        .container {  
            max-width: 1000px;  
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
            font-size: 26px;  
            letter-spacing: 0.5px;  
        }  

        /* Table */  
        table {  
            width: 100%;  
            border-collapse: collapse;  
            border-radius: 8px;  
            overflow: hidden;  
            margin-top: 20px;  
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

        /* Buttons */  
        .btn {  
            display: inline-block;  
            padding: 8px 14px;  
            border-radius: 8px;  
            text-decoration: none;  
            font-size: 13px;  
            font-weight: bold;  
            transition: 0.3s;  
            margin: 2px;  
        }  

        .btn-logout {  
            background: linear-gradient(135deg, #d32f2f, #b71c1c);  
            color: white;  
        }  

        .btn-logout:hover {  
            background: linear-gradient(135deg, #b71c1c, #d32f2f);  
        }  

        .btn-add {  
            background: linear-gradient(135deg, #2e7d32, #1b5e20);  
            color: white;  
            margin-top: 20px;  
        }  

        .btn-add:hover {  
            background: linear-gradient(135deg, #1b5e20, #2e7d32);  
        }  

        .btn-update {  
            background: #1565c0;  
            color: white;  
        }  

        .btn-update:hover {  
            background: #0d47a1;  
        }  

        .btn-delete {  
            background: #d32f2f;  
            color: white;  
        }  

        .btn-delete:hover {  
            background: #b71c1c;  
        }  

        .btn-addItemDetails {  
            background: linear-gradient(135deg, #f57c00, #ef6c00);  
            color: white;  
        }  

        .btn-addItemDetails:hover {  
            background: linear-gradient(135deg, #ef6c00, #f57c00);  
        }  

        /* Top Bar */  
        .top-bar {  
            display: flex;  
            justify-content: space-between;  
            align-items: center;  
            margin-bottom: 15px;  
        }  

        .center {  
            text-align: center;  
        }  

        @keyframes fadeIn {  
            from { opacity: 0; transform: translateY(20px); }  
            to { opacity: 1; transform: translateY(0); }  
        }  
    </style>  
</head>  
<body>  
<div class="container">  

    <!-- Top Bar -->  
    <div class="top-bar">  
        <!-- Left: Delete Account -->  
        <div>  
            <a href="/item-service-project/userController?action=deleatAccount" class="btn btn-delete">🗑 Delete Account</a>  
        </div>  

        <!-- Right: Logout -->  
        <div>  
            <a href="/item-service-project/ItemController_java?action=logout" class="btn btn-logout">🚪 Logout</a>  
        </div>  
    </div>  

    <% List<Item> items = (List<Item>) request.getAttribute("allItems"); %>  

    <h1>📋 Items List</h1>  
    <table>  
        <thead>  
        <tr>  
            <th>ID</th>  
            <th>Name</th>  
            <th>Price</th>  
            <th>Total Number</th>  
            <th>Action</th>  
        </tr>  
        </thead>  
        <tbody>  
        <% for(Item item: items){ %>  
            <tr>  
                <td><%= item.getId() %></td>  
                <td><%= item.getName() %></td>  
                <td><%= item.getPrice() %></td>  
                <td><%= item.getTotalNumber() %></td>  
                <td>  
                    <% if(item.isHasDetails()){ %>  
                        <a href="/item-service-project/ItemController_java?action=showItemDetails&id=<%= item.getId() %>" class="btn btn-addItemDetails">👁 Show Details</a>  
                        <a href="/item-service-project/ItemController_java?action=getAndupdateItemDetails&id=<%= item.getId() %>" class="btn btn-addItemDetails">✏ Update Details</a>  
                    <% } else { %>  
                        <a href="/item-service-project/ItemController_java?action=getItemDetails&id=<%= item.getId() %>" class="btn btn-addItemDetails">➕ Add Details</a>  
                    <% } %>  
                    <a href="/item-service-project/ItemController_java?action=getItem&id=<%= item.getId() %>" class="btn btn-update">✏ Update</a>  
                    <a href="/item-service-project/ItemController_java?action=deleteItem&id=<%= item.getId() %>" class="btn btn-delete">🗑 Delete</a>  
                </td>  
            </tr>  
        <% } %>  
        </tbody>  
    </table>  

    <!-- Add Item Button -->  
    <div class="center">  
        <a href="/item-service-project/ItemController_java?action=addItem" class="btn btn-add">➕ Add Item</a>  
    </div>  

</div>  
</body>  
</html>  
