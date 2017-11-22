<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel='stylesheet'
    href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet" href="<%=basePath%>assets/css/reset.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/supersized.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/style.css">
</head>
<body>

    <div class="page-container">
        <h1>Login</h1>
        <form action="user/login.do" method="post">
            <input type="text" name="username" class="username"
                placeholder="Username"> <input type="password"
                name="password" class="password" placeholder="Password">
            <button type="submit">登录</button>
            <div class="error">
                <span>+</span>
            </div>
        </form>
    </div>

    <!-- Javascript -->
    <script src="<%=basePath%>assets/js/jquery-1.8.2.min.js"></script>
    <script src="<%=basePath%>assets/js/supersized.3.2.7.min.js"></script>
    <script src="<%=basePath%>assets/js/supersized-init.js"></script>
    <script src="<%=basePath%>assets/js/scripts.js"></script>

</body>
</html>