<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <title>User Info</title> 

    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #eef2f3, #8e9eab);
            margin: 0;
            padding: 40px;
        }

        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            max-width: 500px;
            margin: auto;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .result {
            margin-top: 20px;
            text-align: center;
            font-size: 18px;
            color: #444;
        }
    </style>
</head> 
<body> 

<% 
    int id = 852005; 
    String name = "Ahmed_Mohamed"; 
%> 

<%! 
    String concatIdAndName(int i, String n) { 
        return i + " - " + n; 
    } 
%> 

<div class="container">
    <h2>User Details</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <tr>
            <td><%= id %></td>
            <td><%= name %></td>
        </tr>
    </table>

    <div class="result">
        Result: <strong><%= concatIdAndName(id, name) %></strong>
    </div>
</div>

</body> 
</html>
