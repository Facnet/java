package Task_one.Entities;

import java.util.ArrayList;
import java.util.HashMap;

import static Task_one.CustomUtilities.AvgBall.getAvgBall;

public class Student {
    private byte classStudent;
    private String surnameStudent;
    private String nameStudent;
    private byte sexStudent;
    private Subject subjectStudent;
    private Activity activityStudent;

    public Student(byte grade, String surname, String name, byte sex, Subject subject, Activity activity) throws Exception {
        setClassStudent(grade);
        setSurnameStudent(surname);
        setNameStudent(name);
        setSexStudent(sex);
        setSubjectStudent(subject);
        setActivityStudent(activity);
    }

    public byte getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(byte classStudent) throws Exception {
        if (classStudent < 1) {
            throw new Exception("Класс не может быть отрицательным! Инфо: " + classStudent);
        }
        if (classStudent > 11) {
            throw new Exception("Класс не может быть больше одиннадцати! Инфо: " + classStudent);
        }
        this.classStudent = classStudent;
    }

    public String getSurnameStudent() {
        return surnameStudent;
    }

    public void setSurnameStudent(String surnameStudent) throws Exception {
        if(surnameStudent.equals("")) {
            throw new Exception("Фамилия не может быть пустым!");
        }
        this.surnameStudent = surnameStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) throws Exception {
        if(nameStudent.equals("")) {
            throw new Exception("Имя не может быть пустым!");
        }
        this.nameStudent = nameStudent;
    }

    public String getSexStudent() {
        if(this.sexStudent == 1){
            return "муж";
        }
        else {
            return "жен";
        }
    }

    public void setSexStudent(byte sexStudent) throws Exception {
        if (sexStudent < 0)
            throw new Exception("Пол не может быть отрицательным! Инфо: " + sexStudent);
        if (sexStudent > 1)
            throw new Exception("Пол не может быть больше одного! Инфо: " + sexStudent);
        this.sexStudent = sexStudent;
    }

    public Subject getSubjectStudent() {
        return subjectStudent;
    }

    public void setSubjectStudent(Subject subjectStudent) {
        this.subjectStudent = subjectStudent;
    }

    public ArrayList<String> getActivityStudent() {
        return activityStudent.getActivityArrayList();
    }

    public void setActivityStudent(Activity activityStudent) {
        this.activityStudent = activityStudent;
    }

    @Override
    public String toString() {
        return ("Класс: " + getClassStudent() + "\n" +
                "Фамилия: " + getSurnameStudent() + "\n" +
                "Имя: " + getNameStudent() + "\n" +
                "Пол: " + getSexStudent() + "\n"
                + getSubjectStudent().getSubjectHashMap() + " Средний балл: " + getAvgBall(this.subjectStudent) + "\n"
                + getActivityStudent());
    }
}
