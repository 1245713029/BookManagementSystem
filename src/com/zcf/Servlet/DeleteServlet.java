package com.zcf.Servlet;

import com.zcf.Dao.UserDao;
import com.zcf.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao userDao=new UserDao();
    UserBean userBean=new UserBean();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userBean.setId(request.getParameter("id"));
        boolean i;
        try{
            i=userDao.deleteUser(userBean);
            if (i){
                request.setAttribute("msg","删除成功");
                request.getRequestDispatcher("/exception.jsp").forward(request,response);
                System.out.println("删除成功");
            }else{
                request.setAttribute("msg","删除失败");
                request.getRequestDispatcher("/exception.jsp").forward(request,response);
                System.out.println("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doPost(request,response);

    }
}
