<%--
  Created by IntelliJ IDEA.
  User: 12457
  Date: 2020/2/3
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<section id="content">
    <form action="${pageContext.request.contextPath}/services/UserServlet?method=addedit"
          method="post">
        <h1>用户注册</h1>
        <div>
            <input type="text" name="username" id="username" required="" placeholder="账号">
        </div>

        <div>
            <input type="text" name="passwrod" id="password" required=""  placeholder="密码">
        </div>
        <div>
            <input type="text" name="name" id="name" required=""  placeholder="用户名">
        </div>
        <div>
            <input type="text" name="gh" id="gh" required=""  placeholder="工号">
        </div>
        <div>
            <input type="text" name="mobile" id="mobile" required=""  placeholder="手机号">
        </div>
        <div>
            <input type="submit" value="注册">
        </div>
    </form>
</section>
</body>
</html>
