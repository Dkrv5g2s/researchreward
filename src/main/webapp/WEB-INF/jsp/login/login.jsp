<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/11
  Time: 上午 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        if (window != top)
            top.location.href = location.href; // 跳轉頁面用
    </script>
    <title>登入畫面</title>
</head>
<body>
    <form action="login" method="post">
        帳號:<input type="text" name="account">
        密碼:<input type="password" name="password">
        <button type="submit">登入</button>
    </form>
</body>
</html>
