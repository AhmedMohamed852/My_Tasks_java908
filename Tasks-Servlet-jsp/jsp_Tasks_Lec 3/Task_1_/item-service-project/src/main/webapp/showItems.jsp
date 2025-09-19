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
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
            background: linear-gradient(135deg, #f9fbfd, #eef3f8); 
            margin: 0; 
            padding: 0; 
            color: #333; 
        } 
 
        .layer { 
            max-width: 950px; 
            margin: 60px auto; 
            background: #ffffff; 
            padding: 30px; 
            border-radius: 15px; 
            box-shadow: 0 6px 18px rgba(0,0,0,0.08); 
            transition: transform 0.2s ease-in-out; 
        } 
 
        .layer:hover { 
            transform: translateY(-4px); 
        } 
 
        h1 { 
            text-align: center; 
            color: #2c3e50; 
            margin-bottom: 25px; 
            font-size: 26px; 
        } 
 
        /* Table */ 
        table { 
            width: 100%; 
            border-collapse: collapse; 
            margin-top: 15px; 
            font-size: 15px; 
        } 
 
        thead th { 
            background: linear-gradient(135deg, #74b9ff, #0984e3); 
            color: #fff; 
            text-transform: uppercase; 
            letter-spacing: 1px; 
            padding: 14px; 
            text-align: center; 
            border-radius: 8px 8px 0 0; 
        } 
 
        tbody td { 
            padding: 12px; 
            border-bottom: 1px solid #e6e6e6; 
            text-align: center; 
            color: #444; 
        } 
 
        tbody tr:nth-child(even) { 
            background: #f9f9f9; 
        } 
 
        tbody tr:hover { 
            background: #f1f7ff; 
            transition: 0.3s; 
        } 
 
        /* Buttons */ 
        .btn { 
            display: inline-block; 
            padding: 10px 20px; 
            border-radius: 8px; 
            text-decoration: none; 
            font-size: 14px; 
            font-weight: bold; 
            transition: 0.3s; 
        } 
 
        .btn-logout { 
            background: linear-gradient(135deg, #ff7675, #d63031); 
            color: white; 
        } 
 
        .btn-logout:hover { 
            background: linear-gradient(135deg, #d63031, #ff7675); 
        } 
 
        .btn-add { 
            background: linear-gradient(135deg, #55efc4, #00b894); 
            color: white; 
            margin-top: 20px; 
        } 
 
        .btn-add:hover { 
            background: linear-gradient(135deg, #00b894, #55efc4); 
        } 
 
        .btn-update { 
            background: #74b9ff; 
            color: white; 
        } 
 
        .btn-update:hover { 
            background: #0984e3; 
        } 
 
        .btn-delete { 
            background: #ff7675; 
            color: white; 
        } 
 
        .btn-delete:hover { 
            background: #d63031; 
        } 
 
        /* Top Bar */ 
        .top-bar { 
            display: flex; 
            justify-content: space-between; /* زرار شمال وزرار يمين */ 
            align-items: center; 
            margin-bottom: 15px; 
        } 
 
        .center { 
            text-align: center; 
        } 
    </style> 
</head> 
<body> 
<div class="layer"> 
 
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
