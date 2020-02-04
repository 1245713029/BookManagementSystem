<%--
  Created by IntelliJ IDEA.
  User: 12457
  Date: 2020/1/19
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resource/bs/css/bootstrap.min.css">
    <script type="text/javascript" src="resource/bs/js/bootstrap.min.js"></script>
    <script src="resource/bs/js/jquery.min.js"></script>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" >
    <title>图书管理系统登录页</title>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="${pageContext.request.contextPath}/services/UserServlet?method=login" method="post">
            <h1>登录</h1>
            <div class="input-group">
                <button type="button" class="btn btn-default btn-lg">
                    <span class="glyphicon glyphicon-user"></span> User
                    <input type="text" class="form-control" name="name" id="name" placeholder="账号">
                    <input type="password" class="form-control" name="passwrod" id="prssword"  placeholder="密码">
                </button>

            </div>


            <div>
                <button type="submit" class="btn-primary" data-toggle="button" >
                 登录
                </button>

                <a href="register.jsp" >
                    <button type="button"   class="btn-primary" data-toggle="button">
                        注册
                    </button>
                </a>

            </div>
        </form>

        </button>
    </section>

</div>
</body>
</html>