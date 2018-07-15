package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    //演示通过jdbc连接数据库
    private void testConnection() {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建数据库连接字符串
            String dbURL = "jdbc:mysql://127.0.0.1:3306/hnbll";
            //3.建立数据库连接
            try {
                Connection connection = DriverManager.getConnection(dbURL,
                        "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void testInsertDate(){
        try{
            //1.创建数据库连接
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(
                    "jdbc.mysql://localhost:3306/hnb11",
                    "root","root");
            //2.构建添加数据的sql语句
            String sql="insert into account values(id,account,password)";
            //3.执行sql语句
            Statement statement=connection.createStatement();
            int rows=statement.executeUpdate(sql);
            System.out.println("所影响的行数为："+rows);
            //4.得到执行后的结果，确定是否添加成功
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    public  static void main(String [] args){
        JDBCDemo demo = new JDBCDemo();
        demo.testInsertDate();
    }
}
