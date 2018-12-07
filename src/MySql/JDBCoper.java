package MySql;
import Message.Students;
import Message.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCoper
{
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    public Connection getConn() {
        return conn;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public JDBCoper() {
        this.conn = JDBCUtil.getConnection();
    }

    public void close()
    {
        JDBCUtil.close(rs,ps,conn);
    }

    public void creatTable() throws SQLException {
        String sqlS = "create table if not exists tempstudent" +
                "(sName varchar(20),sId int);";
        String sqlC = "create table if not exists tempcourse" +
                "(sId int,cName varchar(20),grade double);";
        String str[]={sqlS,sqlC};
        for(int i=0;i<str.length;i++)
        {
            ps = conn.prepareStatement(str[i]);
            ps.executeUpdate();
        }
    }

    public void insert(Students...stu) throws SQLException {
        String sql="INSERT INTO tempstudent(sName,sId)values (?,?)";
        ps=conn.prepareStatement(sql);
        for(int i=0;i<stu.length;i++) {
            ps.setObject(1, stu[i].getName());
            ps.setObject(2, stu[i].getId());
            ps.executeUpdate();
        }
    }

    public void insert(Course... cs) throws SQLException {
        String sql="INSERT INTO tempcourse(sId,cName,grade)values (?,?,?)";
        ps=conn.prepareStatement(sql);
        for(int i=0;i<cs.length;i++) {
            ps.setObject(1, cs[i].getSid());
            ps.setObject(2, cs[i].getCname());
            ps.setObject(3, cs[i].getGrade());
            ps.executeUpdate();
        }
    }

    public void select(Students stu) throws SQLException {
        String sql="SELECT sName,tempstudent.sId,cName,grade FROM tempstudent,tempcourse " +
                "where tempstudent.sId=tempcourse.sId AND tempstudent.sName=?";
        ps=conn.prepareStatement(sql);
        ps.setObject(1,stu.getName());
        rs=ps.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getObject("sName")
                            +" 学号:"+rs.getObject("sId")
                            +" "+rs.getObject("cName")
                            +" 成绩:"+rs.getObject("grade"));
        }
    }
}