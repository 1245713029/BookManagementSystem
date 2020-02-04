package com.zcf.Servlet;

import com.zcf.Dao.UserDao;
import com.zcf.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    UserBean userBean =null;
    UserDao  userDao=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        userBean.setId(request.getParameter("id"));
        try {

            boolean flag=userDao.UpdateUser(userBean);
            if(flag){
                System.out.println("修改成功");
                request.setAttribute("msg","修改成功");
                request.getRequestDispatcher("/exception.jsp").forward(request,response);
            }else {
                System.out.println("修改失败");
                request.setAttribute("msg","修改失败");
                request.getRequestDispatcher("/exception.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doPost(request,response);
    }
}
