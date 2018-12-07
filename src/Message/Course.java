package Message;

public class Course
{
    private String cname;
    private int sid;
    private double grade;

    public Course(String cname,int sid, double grade) {
        this.cname = cname;
        this.sid = sid;
        this.grade = grade;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
