<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f4f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background: #fff;
            padding: 25px 30px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
            width: 320px;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-container label {
            display: block;
            margin-top: 10px;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        .form-container input[type="text"],
        .form-container input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            margin-bottom: 15px;
            transition: border 0.3s ease;
        }

        .form-container input:focus {
            border: 1px solid #4f46e5;
            outline: none;
        }

        .form-container .btn {
            width: 100%;
            padding: 12px;
            background: #4f46e5;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .form-container .btn:hover {
            background: #3730a3;
        }

        .form-container .link {
            display: block;
            margin-top: 15px;
            text-align: center;
        }

        .form-container .link a {
            text-decoration: none;
            color: #4f46e5;
            font-weight: bold;
        }

        .form-container .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="form-container">




 



    <h2>Login</h2>

 <% 
String actionsource = (String) request.getAttribute("actionsource"); 

if("signup".equals(actionsource)) { 
	
    Boolean signupResult = (Boolean) request.getAttribute("signupresult");
    if(signupResult != null) { 
        if(signupResult) { %>
            <p style="color:green;">تم إنشاء الحساب بنجاح! الرجاء تسجيل الدخول.</p>
        <% } else { %>
            <p style="color:red;">اسم المستخدم موجود بالفعل!</p>
        <% } 
    } 
} else if("login".equals(actionsource)) { 
    Boolean loginResult = (Boolean) request.getAttribute("loginresult"); 
    if(loginResult != null && !loginResult) { %>
        <p style="color:red;">اسم المستخدم أو كلمة المرور غير صحيحة!</p>
    <% } 
} else {
    String error = (String) request.getAttribute("error");
    if(error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% }
} %>

   <form action="/item-service-project/userController?action=login" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <input type="submit" value="Login" class="btn">
</form>


    <div class="link">
        <a href="<%= request.getContextPath() %>/signUp.jsp">➕ Create New Account</a>
    </div>
</div>

</body>
</html>
