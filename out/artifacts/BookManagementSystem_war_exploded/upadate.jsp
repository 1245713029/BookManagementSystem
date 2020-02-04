<%--
  Created by IntelliJ IDEA.
  User: 12457
  Date: 2020/2/4
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page  language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户修改</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:100px;">
    <form class="bs-example bs-example-form" role="form" action="UpdateServlet/id?=${beanlist.id}">
        <div class="input-group">
            <span class="input-group-addon">账号</span>
            <input type="text" class="form-control" placeholder="${beanlist.username}"
                   namae="username" id="username" value="" >
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input type="text" class="form-control" placeholder="${beanlist.passwrod}"
                   namae="passwrod" id="passwrod" value="" >
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">姓名</span>
            <input type="text" class="form-control" placeholder="${beanlist.name}"
             name="name" id="name" value="">
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">工号</span>
            <input type="text" class="form-control" placeholder="${beanlist.gh}"
            name="gh" id="gh" value="">
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">手机号</span>
            <input type="text" class="form-control" placeholder="${beanlist.mobile}"
                   name="mobile" id="mobile" value="">
        </div><br>

    </form>
</div>
</body>
</html>
