<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    form {
        background-color: white;
        padding: 30px 40px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    h3 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    label, p {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #555;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    
    .radio-group, .checkbox-group {
        margin-bottom: 20px;
    }

    input[type="radio"], input[type="checkbox"] {
        margin-right: 8px;
    }
    
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<form action="Task_2_file_1_.jsp" method ="post">
    <h3>Registration Form</h3>
    
    <label for="name">Full Name:</label>
    <input type="text" id="name" name="name" required>
    
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    
    <label for="age">Age:</label>
    <input type="text" id="age" name="Age" required>
    
    <div class="radio-group">
        <p>Country Is:</p>
        <input type="radio" id="cairo" name="Country" value="Cairo" required>
        <label for="cairo" style="display:inline;">Cairo</label><br>
        
        <input type="radio" id="alex" name="Country" value="alex" required>
        <label for="alex" style="display:inline;">Alexandria</label><br>
        
        <input type="radio" id="menofia" name="Country" value="menofia" required>
        <label for="menofia" style="display:inline;">Menofia</label><br>
    </div>
    
    <div class="checkbox-group">
        <p>Your Favorite Countries:</p>
        <input type="checkbox" id="fav_cairo" name="favorite" value="Cairo">
        <label for="fav_cairo" style="display:inline;">Cairo</label><br>
        
        <input type="checkbox" id="fav_alex" name="favorite" value="alex">
        <label for="fav_alex" style="display:inline;">Alexandria</label><br>
        
        <input type="checkbox" id="fav_menofia" name="favorite" value="menofia">
        <label for="fav_menofia" style="display:inline;">Menofia</label><br>
    </div>
    
    <input type="submit" value="Submit">
</form>

</body>
</html>