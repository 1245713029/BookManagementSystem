package com.zcf.Servlet;

import com.zcf.Dao.UserDao;
import com.zcf.bean.UserBean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.jws.WebService;
import javax.mail.Session;
import javax.servlet.http.*;
import javax.servlet.*;

@WebService
public class UserServlet extends HttpServlet {

    UserDao userDao=new UserDao();
   static  HttpSession session=null;
   private List<UserBean> userBeanList=null;
   UserBean  userBean=null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws
            ServletException, IOException {

      request.setCharacterEncoding("UTF-8");
      String method=request.getParameter("method");
      if(method.equals("login")) {
          try {
              Login(request, response);
          } catch (ClassNotFoundException | SQLException e) {
              e.printStackTrace();
          }
      }else  if (method.equals("addedit")){
          try {
              AddEidt(request, response);
          } catch (ClassNotFoundException | SQLException e) {
              e.printStackTrace();
          }
      }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
       this.doPost(request,response);
    }

    protected  void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String passwrod=request.getParameter("passwrod");
        userBeanList=  UserDao.Login(name,passwrod);
        if(!userBeanList.isEmpty()){
            System.out.println("登录成功");
            request.setAttribute("userBeanList",userBeanList);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            System.out.println("登录失败");
            request.setAttribute("msg", "登录失败检查账号密码是否错误");
            request.getRequestDispatcher("/exception.jsp").forward(request,response);
        }
    }
    protected void  AddEidt(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");
        userBean.setUsername(request.getParameter("username"));
        userBean.setPasswrod(request.getParameter("passwrod"));
        userBean.setName(request.getParameter("name"));
        userBean.setGh(request.getParameter("gh"));
        userBean.setMobile(request.getParameter("mobile"));
        boolean flag=UserDao.AddEidt(userBean);
       if (flag){
            System.out.println("注册成功");
            request.setAttribute("msg","注册成功");
            response.sendRedirect(request.getContextPath()+"/exception.jsp");
        }else{
            System.out.println("注册失败");
            request.setAttribute("msg","注册失败");
            response.sendRedirect(request.getContextPath()+"/exception.jsp");
        }

    }
}
