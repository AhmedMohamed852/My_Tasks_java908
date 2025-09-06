<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ page import="java.util.List" %>
<%@ page import="com.item.model.*" %>
    
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Show Items</title> 

    <style>
        /* General Page Styling */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f9fbfd, #eef3f8);
            margin: 0;
            padding: 0;
            color: #333;
        }

        /* Main Container */
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

        /* Title */
        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 26px;
        }

        /* Table Styling */
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

        /* Action Links */
        td a {
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 6px;
            font-size: 14px;
            font-weight: 600;
            transition: all 0.3s ease;
        }

        td a:first-child {
            background: #74b9ff;
            color: white;
        }

        td a:first-child:hover {
            background: #0984e3;
        }

        td a:last-child {
            background: #ff7675;
            color: white;
        }

        td a:last-child:hover {
            background: #d63031;
        }

        /* Add Item Button */
        button.f {
            display: block;
            margin: 25px auto 0;
            padding: 12px 28px;
            background: linear-gradient(135deg, #55efc4, #00b894);
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: transform 0.2s ease, background 0.3s ease;
        }

        button.f:hover {
            background: linear-gradient(135deg, #00b894, #55efc4);
            transform: scale(1.03);
        }

        button.f a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
            display: block;
        }
    </style>
</head> 
<body> 
<div class="layer"> 

    <%
        List<Item> items = (List<Item>) request.getAttribute("allItems");
    %>

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
            <%
                for(Item item: items){ 
            %> 
            <tr>  
                <td><%= item.getId() %></td>  
                <td><%= item.getName() %></td>  
                <td><%= item.getPrice() %></td>  
                <td><%= item.getTotalNumber() %></td>  
                <td>  
                    <a href="/item-service-project/ItemController_java?action=getItem&id=<%= item.getId() %>">✏ Update</a>  
                    <a href="/item-service-project/ItemController_java?action=deleteItem&id=<%= item.getId() %>">🗑 Delete</a>  
                </td>  
            </tr>  
            <% } %> 
        </tbody>
    </table> 

    <button class="f"><a href="addItem.html">➕ Add Item</a></button> 
</div> 
</body> 
</html>
