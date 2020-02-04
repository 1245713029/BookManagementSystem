
<%--
  Created by IntelliJ IDEA.
  User: 12457
  Date: 2020/1/17
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page  language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
      <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>>

    <title>欢迎页面</title>
  </head>
  <body>

    <h2 style="text-align: center;">用户信息</h2>
    <p style="text-align: center;"><a href="register.jsp">添加用户</a>&nbsp;&nbsp;
        <a href="ShowServlet">查询用户</a>&nbsp;&nbsp;<a href="#">高级搜索</a><p/>

    <hr />
    <br /><br />
   <center>
  <div >
   <section id="content">
          <h1>登陆成功</h1>


          <table border="1" class="table table-bordered">
              <caption>用户个人信息</caption>
              <thead>
              <tr>
                  <th>id</th>
                  <th>账号</th>
                  <th>密码</th>
                  <th>姓名</th>
                  <th>工号</th>
                  <th>手机</th>
                  <th>操作</th>
              </tr>
              </thead>
              <tbody>

                <c:forEach items="${userBeanList}" var="userBeanList">
                    <form method="post" name="myForm${userBeanList.id}" action="UpdateServlet?id=${userBeanList.id}">
                <tr>
                        <td>${userBeanList.id}</td>
                        <td><input type="text" value="${userBeanList.username}" style="border: none" name="username"></td>
                        <td><input type="text" value="${userBeanList.passwrod}" style="border: none" name="passwrod"></td>
                        <td><input type="text" value="${userBeanList.name}" style="border: none" name="name"></td>
                        <td><input type="text" value="${userBeanList.gh}" style="border: none" name="gh"></td>
                        <td><input type="text" value="${userBeanList.mobile}" style="border: none" name="mobile"></td>
                    <td><a href="${pageContext.request.contextPath}/services/ShowServlet?id=${userBeanList.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/services/DeleteServlet?id=${userBeanList.id}">删除</a>

                    </td>
                </tr>
                </c:forEach>
                    </form>
              </tbody>
          </table>
      </section>
  </div>
        <div>
            <ul class="pagination">
                <li><a href="#">&laquo;</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&raquo;</a></li>
            </ul>
        </div>

   </center>
  </body>


</html>
