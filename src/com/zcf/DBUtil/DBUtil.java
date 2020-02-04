package com.zcf.DBUtil;

import java.sql.*;

import static java.lang.Class.forName;

/**
 * 数据库连接工具类
 */
public class DBUtil {

    //数据库连接地址
    public static String db_url="jdbc:mysql://localhost:3306/testdb?uerUnicode=true&characterEncoding=UTF-8";

    public static String db_user="root";

    public static String db_passwrod="123456";


    /*public  static  void main(String[] agrs) throws SQLException, ClassNotFoundException {
        DBUtil.getConn();
    }*/
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        // 1.加载数据库驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("数据库驱动加载成功");

        // 2.创建连接
        //格式为jdbc:mysql:
        // 127.0.0.1:3306/数据库名称?useSSL=true&characterEncoding=utf-8&user=账号名&password=密码
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT&user=root&password=123456");
        System.out.println("创建连接成功");
        Statement statement=null;
        ResultSet resultSet=null;
        String name ="admin";
        String sql="select * from t_user where username='"+name+"'";
        statement =connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString("password").toString());

        }
        return  connection;

    }

    /**
     * 没有过结果集情况的下关闭连接
     * @param statement 状态
     * @param connection 连接
     */
    public static void close(Statement statement ,Connection connection){

        if(statement!=null) {
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 在访问后有结果集的状态下先关闭结果集在关闭状态在关闭数据库连接
     * @param resultSet 连接后返回的结果集
     * @param statement 连接的状态
     * @param connection 连接
     */
    public static void close(ResultSet resultSet ,Statement statement,Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   /* public static void main(String[] args) {
        try {
            // 1.加载数据库驱动类
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

            // 2.创建连接
            //格式为jdbc:mysql:
            // 127.0.0.1:3306/数据库名称?useSSL=true&characterEncoding=utf-8&user=账号名&password=密码
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/testdb?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT&user=root&password=123456");
            System.out.println("创建连接成功");
            Statement statement=null;
            ResultSet resultSet=null;
            String name ="admin";
            String sql="select * from t_user where username='"+name+"'";
            statement =connection.createStatement();
            resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    System.out.println(resultSet.getString("password").toString());
                }

        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }*/



}
