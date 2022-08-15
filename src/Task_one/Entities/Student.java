package Task_one.Entities;

import java.util.ArrayList;
import java.util.HashMap;

import static Task_one.CustomUtilities.AvgBall.getAvgBall;

public class Student {
    private byte bClass;
    private String sSurname;
    private String sName;
    private byte sSex;
    private Subject oSubject;
    private Activity oActivity;

    public Student(byte iClass, String sSurname, String sName, byte sSex, Subject subject, Activity activity) throws Exception {
        setbClass(iClass);
        setsSurname(sSurname);
        setsName(sName);
        setsSex(sSex);
        setoSubject(subject);
        setoActivity(activity);
    }

    public byte getbClass() {
        return bClass;
    }

    public void setbClass(byte bClass) throws Exception {
        if (bClass < 1) {
            throw new Exception("Класс не может быть отрицательным! Инфо: " + bClass);
        }
        if (bClass > 11) {
            throw new Exception("Класс не может быть больше одиннадцати! Инфо: " + bClass);
        }
        this.bClass = bClass;
    }

    public String getsSurname() {
        return sSurname;
    }

    public void setsSurname(String sSurname) throws Exception {
        if(sSurname.equals("")) {
            throw new Exception("Фамилия не может быть пустым!");
        }
        this.sSurname = sSurname;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) throws Exception {
        if(sName.equals("")) {
            throw new Exception("Имя не может быть пустым!");
        }
        this.sName = sName;
    }

    public String getsSex() {
        if(this.sSex == 1){
            return "муж";
        }
        else {
            return "жен";
        }
    }

    public void setsSex(byte sSex) throws Exception {
        if (sSex < 0)
            throw new Exception("Пол не может быть отрицательным! Инфо: " + sSex);
        if (sSex > 1)
            throw new Exception("Пол не может быть больше одного! Инфо: " + sSex);
        this.sSex = sSex;
    }

    public HashMap<String, Byte> getoSubject() {
        return oSubject.getSubjectHashMap();
    }

    public void setoSubject(Subject oSubject) {
        this.oSubject = oSubject;
    }

    public ArrayList<String> getoActivity() {
        return oActivity.getActivityArrayList();
    }

    public void setoActivity(Activity oActivity) {
        this.oActivity = oActivity;
    }

    @Override
    public String toString() {
        return ("Класс: " + getbClass() + "\n" +
                "Фамилия: " + getsSurname() + "\n" +
                "Имя: " + getsName() + "\n" +
                "Пол: " + getsSex() + "\n"
                + getoSubject() + " Средний балл: " + getAvgBall(this.oSubject) + "\n"
                + getoActivity());
    }
}
