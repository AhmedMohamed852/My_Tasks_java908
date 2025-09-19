<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>Login</title>  
    <style>  
        /* Reset */  
        * { margin: 0; padding: 0; box-sizing: border-box; }

        body {  
            font-family: 'Poppins', Arial, sans-serif;  
            background: #f4f6f9;  
            display: flex;  
            justify-content: center;  
            align-items: center;  
            height: 100vh;  
        }  

        .form-container {  
            background: #fff;  
            padding: 35px 30px;  
            border-radius: 12px;  
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);  
            width: 380px;  
            animation: fadeIn 0.6s ease-in-out;  
        }  

        .form-container h2 {  
            text-align: center;  
            margin-bottom: 22px;  
            color: #0d47a1;  
            font-size: 22px;  
            letter-spacing: 0.5px;  
        }  

        /* رسائل التنبيه */  
        .form-container p.message {  
            margin-bottom: 18px;  
            padding: 10px;  
            border-radius: 6px;  
            font-size: 14px;  
            text-align: center;  
        }  

        .form-container p.success {  
            background-color: #d4edda;  
            color: #155724;  
            border: 1px solid #c3e6cb;  
        }  

        .form-container p.error {  
            background-color: #f8d7da;  
            color: #721c24;  
            border: 1px solid #f5c6cb;  
        }  

        label {  
            display: block;  
            margin-bottom: 6px;  
            font-weight: 600;  
            color: #444;  
        }  

        input[type="text"],  
        input[type="password"] {  
            width: 100%;  
            padding: 12px;  
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

        .btn {  
            width: 100%;  
            padding: 12px;  
            background: #0d47a1;  
            border: none;  
            border-radius: 8px;  
            font-size: 15px;  
            font-weight: 600;  
            color: #fff;  
            cursor: pointer;  
            transition: 0.3s;  
        }  

        .btn:hover {  
            background: #1565c0;  
            transform: translateY(-2px);  
        }  

        .link, .password {  
            text-align: center;  
            margin-top: 15px;  
        }  

        .link a, .password a {  
            text-decoration: none;  
            font-weight: bold;  
            color: #0d47a1;  
            transition: 0.3s;  
        }  

        .link a:hover, .password a:hover {  
            text-decoration: underline;  
            color: #1565c0;  
        }  

        @keyframes fadeIn {  
            from { opacity: 0; transform: translateY(20px); }  
            to { opacity: 1; transform: translateY(0); }  
        }  
    </style>  
</head>  
<body>  

<div class="form-container">  
    <h2>🔐 Login</h2>  

    <%   
    String actionsource = (String) request.getAttribute("actionsource");   
    if("signup".equals(actionsource)) {   
        Boolean signupResult = (Boolean) request.getAttribute("signupresult");  
        if(signupResult != null) {   
            if(signupResult) { %>  
                <p class="message success">✅ تم إنشاء الحساب بنجاح! الرجاء تسجيل الدخول.</p>  
            <% } else { %>  
                <p class="message error">⚠️ اسم المستخدم موجود بالفعل!</p>  
            <% }   
        }   
    } else if("login".equals(actionsource)) {   
        Boolean loginResult = (Boolean) request.getAttribute("loginresult");   
        if(loginResult != null && !loginResult) { %>  
            <p class="message error">❌ اسم المستخدم أو كلمة المرور غير صحيحة!</p>  
        <% }   
    } else {  
        String error = (String) request.getAttribute("error");  
        if(error != null) { %>  
            <p class="message error">⚠️ <%= error %></p>  
        <% }  
    } %>  

    <form action="/item-service-project/userController?action=login" method="post">  
        <label for="name">Username:</label>  
        <input type="text" id="name" name="name" required>  

        <label for="password">Password:</label>  
        <input type="password" id="password" name="password" required>  

        <input type="submit" value="Login" class="btn">  
    </form>  

    <div class="link">  
        <a href="<%= request.getContextPath() %>/signUp.jsp">➕ Create New Account</a>  
    </div>  
    <div class="password">  
        <a href="<%= request.getContextPath() %>/ForgotPassword.html">🔑 Forgot Password</a>  
    </div>  
</div>  

</body>  
</html>  
