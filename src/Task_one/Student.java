package Task_one;

public class Student {
    private byte bClass;
    private String sSurname, sName, sSex;
    private Subject oSubject = new Subject();
    private Activity oActivity = new Activity();

    public Student(byte iClass, String sSurname, String sName, String sSex) {
        this.bClass = iClass;
        this.sSurname = sSurname;
        this.sName = sName;
        this.sSex = sSex;
    }

    public byte getbClass() {
        return bClass;
    }

    public void setbClass(byte bClass) {
        this.bClass = bClass;
    }

    public String getsSurname() {
        return sSurname;
    }

    public void setsSurname(String sSurname) {
        this.sSurname = sSurname;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public Subject getoSubject() {
        return oSubject;
    }

    public void setoSubject(Subject oSubject) {
        this.oSubject = oSubject;
    }

    public Activity getoActivity() {
        return oActivity;
    }

    public void setoActivity(Activity oActivity) {
        this.oActivity = oActivity;
    }

    @Override
    public String toString() {
        return ("Класс: " + this.bClass + "\n" +
                "Фамилия: " + this.sSurname + "\n" +
                "Имя: " + this.sName + "\n" +
                "Пол: " + this.sSex + "\n"
                + oSubject.gethSubject() + "\n"
                + oActivity.getStringArrayList());
    }
}
