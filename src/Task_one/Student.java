package Task_one;

public class Student {
    private byte bClass;
    private String sSurname, sName, sSex;
    private Subject oSubject = new Subject();
    private Activity oActivity = new Activity();

    public Student(byte iClass, String sSurname, String sName, String sSex) throws Exception {
        checkClass(iClass);
        this.bClass = iClass;
        this.sSurname = sSurname;
        this.sName = sName;
        this.sSex = sSex;
    }

    public Student(byte iClass, String sSurname, String sName, String sSex, Subject subject) throws Exception {
        checkClass(iClass);
        this.bClass = iClass;
        this.sSurname = sSurname;
        this.sName = sName;
        this.sSex = sSex;
        this.oSubject = subject;
    }

    public Student(byte iClass, String sSurname, String sName, String sSex, Subject subject, Activity activity) throws Exception {
        checkClass(iClass);
        this.bClass = iClass;
        this.sSurname = sSurname;
        this.sName = sName;
        this.sSex = sSex;
        this.oSubject = subject;
        this.oActivity = activity;
    }

    public byte getbClass() {
        return bClass;
    }

    public void setbClass(byte bClass) throws Exception {
        checkClass(bClass);
        this.bClass = bClass;
    }

    private void checkClass(byte bClass) throws Exception {
        if (bClass < 1)
            throw new Exception("Класс не может быть отрицательным! Инфо: " + bClass);
        if (bClass > 11)
            throw new Exception("Класс не может быть больше одиннадцати! Инфо: " + bClass);
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
                + oSubject.gethSubject() + " Средний балл: " + oSubject.getAvgball() + "\n"
                + oActivity.getStringArrayList());
    }
}
