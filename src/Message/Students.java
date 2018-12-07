package Message;

public class Students
{
    private String sname;
    private int sid;

    public Students(String sname, int sid) {
        this.sname = sname;
        this.sid = sid;
    }

    public String getName() {
        return sname;
    }

    public void setName(String sname) {
        this.sname = sname;
    }

    public int getId() {
        return sid;
    }

    public void setId(int sid) {
        this.sid = sid;
    }
}
