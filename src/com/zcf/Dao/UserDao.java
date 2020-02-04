package com.zcf.Dao;


import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.zcf.DBUtil.DBUtil;
import com.zcf.bean.UserBean;


import java.rmi.MarshalledObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户增删改查类
 */
public class UserDao {

   private  static  Statement statement=null;
   private static ResultSet resultSet=null;
   private static Connection connection = null;
   private static PreparedStatement preparedStatement=null;
   private  static String sql =null;
   private static     int      flag=0;
    private static  UserBean userBean=new UserBean();
    private static List<UserBean> beanList=new ArrayList<UserBean>();

    public static List<UserBean>  Login(String name, String password) throws ClassNotFoundException, SQLException {
        connection = DBUtil.getConn();
        try{

            if(name.equals("admin")){
               sql="select * from t_user ";
                System.out.println("sql语句"+sql);
               preparedStatement = connection.prepareStatement(sql);
               resultSet = preparedStatement.executeQuery();
            }else {
                sql = "select * from t_user where username=? and password=?";
                System.out.println("sql语句"+sql);
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, password);
               resultSet = preparedStatement.executeQuery();
            }
            while(resultSet.next()){
                userBean.setId(resultSet.getString("id"));
                userBean.setUsername(resultSet.getString("username"));
                userBean.setPasswrod(resultSet.getString("password"));
                userBean.setName(resultSet.getString("name"));
                userBean.setGh(resultSet.getString("gh"));
                userBean.setMobile(resultSet.getString("mobile"));
                beanList.add(userBean);
                System.out.println("查询数据"+beanList+resultSet.getString("id"));
            }
            resultSet.close();
            preparedStatement.close();
            System.out.println("登录成功+++");
            return beanList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,statement,connection);
        }
        return  beanList;
    }


    public  static  Boolean AddEidt(UserBean userBean) throws SQLException, ClassNotFoundException {
        connection = DBUtil.getConn();
        try{
                 sql = "insert  into t_user ( username,password,name,gh,mobile) values(?,?,?,?,?)";
            System.out.println("sql语句"+sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userBean.getUsername());
            preparedStatement.setString(2,userBean.getPasswrod());
            preparedStatement.setString(3,userBean.getName());
            preparedStatement.setString(4,userBean.getGh());
            preparedStatement.setString(5,userBean.getMobile());
            flag = preparedStatement.executeUpdate();
            preparedStatement.close();
                return  flag>0?true:false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,statement,connection);
        }
        return false;
    }

    public  Boolean UpdateUser(UserBean userBean) throws SQLException, ClassNotFoundException {
        connection = DBUtil.getConn();
        try{
            sql="update t_user set username=?,password=?,name=?,gh=?,mobile=? where id=?;";
            System.out.println("sql语句"+sql);
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userBean.getUsername());
            preparedStatement.setString(2,userBean.getPasswrod());
            preparedStatement.setString(3,userBean.getName());
            preparedStatement.setString(4,userBean.getGh());
            preparedStatement.setString(5,userBean.getMobile());
            preparedStatement.setString(6,userBean.getId());
            flag=preparedStatement.executeUpdate();
            preparedStatement.close();
            return  flag>0 ?true:false;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,statement,connection);
        }
        return false;
    }

    public  boolean deleteUser(UserBean userBean) throws SQLException, ClassNotFoundException {
        connection = DBUtil.getConn();
        try{
            sql="delete form t_user where id=?";
            System.out.println("sql语句"+sql);
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userBean.getId());
            flag =preparedStatement.executeUpdate();
            preparedStatement.close();
            return  flag>0?true:false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,statement,connection);
        }
        return false;
    }
    public   List<UserBean> SelectMap(UserBean userBean) throws SQLException, ClassNotFoundException {
        connection = DBUtil.getConn();
        try{
            sql="select * from t_user where id=?";
            System.out.println("sql语句"+sql);
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,userBean.getId());
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                userBean.setId(resultSet.getString("id"));
                userBean.setUsername(resultSet.getString("username"));
                userBean.setPasswrod(resultSet.getString("password"));
                userBean.setName(resultSet.getString("name"));
                userBean.setGh(resultSet.getString("gh"));
                userBean.setMobile(resultSet.getString("mobile"));
                beanList.add(userBean);
            }
            preparedStatement.close();
            return beanList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,statement,connection);
        }
        return beanList;
    }
}
