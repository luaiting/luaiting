package libary;

import jdbc.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class readbook{
    //演示通过jdbc连接数据库
    @SuppressWarnings("unused")
    private void testConnection() {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建数据库连接字符串
            String dbURL = "jdbc:mysql://localhost:3306/students";
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


    //添加书籍
    private void testInsertDate(int id, String nameValue, String writer){
        try{
            //创建数据库连接
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(
                    "jdbc.mysql://localhost:3306/reader",
                    "root","root");
            //构建数据库的sql语句
            String sql="insert into cj values"+"values("+id+"','"+nameValue+"','"+writer+")";
            //执行语句
            Statement statement=connection.createStatement();
            //得到执行后的结果，确定是否添加成功
            int rows=statement.executeUpdate(sql);
            System.out.println("所添加的书籍数为："+rows);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //修改数据
    private void testUpdateData(int id,String name,String writer){
        try{
            //创建数据库连接
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/students",
                    "root","root");
            //2.创建update.sql语句
            String sql="update readbook set reader='"+name+"',"+"writer='"+writer+"'while id="+id;
            //update sql语句
            Statement statement=connection.createStatement();
            //得到执行结果，确定是否成功
            int rows=statement.executeUpdate(sql);
            System.out.println("更新结果为："+(rows>0));
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }





    //数据的删除
    private void testDeleteDate(String writer) {
        try {
            //创建数据库连接
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students",
                    "root", "root");
            //构建数据库的delete.sql语句
            String sql = "delete from readbook where writer=" + writer;
            //执行语句
            Statement statement = connection.createStatement();
            //得到执行后的结果，确定是否删除成功
            int rows = statement.executeUpdate(sql);
            System.out.println("有" + rows + "书籍被删除成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("=================================================================");
            System.out.println("|                  欢迎进入图书管理系统                       |");
            System.out.println("    1.添加书籍   2.修改数据    3.删除数据    4.退出系统    ");
            System.out.println("请选择你要进行的操作。。。。");
            int select = 0;//接受用户的选项
            select = scanner.nextInt();
            while (select < 1 || select > 4) {
                System.out.println("您的选择不在范围内，请重新选择：");
                select = scanner.nextInt();
            }
            String value = null;
            JDBCDemo jdbcDome = new JDBCDemo();
            if (select == 1) {
                System.out.println("请输入要添加的书名和作者名，中间用逗号隔开。例如：西游记，吴承恩");
                value = scanner.next();
                String[] values = value.split(",");
                jdbcDome.testInsertDate((int) System.currentTimeMillis(),
                        values[0], values[1]);
            } else if (select == 2) {//修改数据
                System.out.println("请输入要修改数据");
                value = scanner.next();
                String[] values = value.split(",");
                jdbcDome.testUpdateData(Integer.parseInt(values[0]),values[1],values[2],values[3]);
            } else if (select == 3) {//删除数据
                System.out.println("请输入要删除的数据");
                value =scanner.next();
                jdbcDome.testDeleteDate(Integer.parseInt(value));

            } else if (select == 4) {//退出系统
                System.exit(-1);
            }
        }
    }
}
