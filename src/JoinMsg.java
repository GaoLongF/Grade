import Message.Course;
import Message.Students;
import MySql.JDBCoper;

import java.sql.SQLException;

public class JoinMsg
{
    public static void main(String[] args) {
        Students zs=new Students("张三",123);
        Students ls=new Students("李四",456);
        Students ww=new Students("王五",789);
        Course math=new Course("高数",123,85.5);
        Course math2=new Course("高数",456,90.5);
        Course math3=new Course("高数",789,60.5);
        Course English=new Course("英语",123,70.5);
        Course English2=new Course("英语",456,80.5);
        Course English3=new Course("英语",789,90.5);
        JDBCoper coper=new JDBCoper();
        try {
            coper.creatTable();     //创建表
            coper.insert(zs,ls,ww);     //添加学生信息
            coper.insert(math,math2,math3,English,English2,English3);       //添加成绩
            coper.select(zs);       //查询学生成绩
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
