package Task_one.Entities;

import java.util.ArrayList;
import java.util.HashMap;

import static Task_one.CustomUtilities.AvgBall.getAvgBall;
import static Task_one.CustomUtilities.CheckFieldEntities.*;

public class Student {
    private byte group;
    private String surname;
    private String name;
    private String gender;
    private HashMap<String, Byte> subject;
    private ArrayList<String> activity = new ArrayList<>();

    {
        subject = new HashMap<>();
        subject.put("математика", (byte) 0);
        subject.put("русский язык", (byte) 0);
        subject.put("физика", (byte) 0);
        subject.put("география", (byte) 0);
        subject.put("химия", (byte) 0);
        subject.put("физкультура", (byte) 0);
    }

    public Student(byte grade, String surname, String name, String gender, byte[] subject, ArrayList<String> activity) throws Exception {
        setGroup(grade);
        setSurname(surname);
        setName(name);
        setGender(gender);
        setSubject(subject);
        setActivity(activity);
    }

    public byte getGroup() {
        return group;
    }

    public void setGroup(byte group) throws Exception {
        checkFieldEntities("Класс", group);
        this.group = group;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws Exception {
        checkFieldEntities("Фамилия", surname);
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkFieldEntities("Имя", name);
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HashMap<String, Byte> getSubject() {
        return subject;
    }

    public void setSubject(byte[] subject) throws Exception {
        checkFieldEntities("Оценка", subject);
        this.subject.put("математика", subject[0]);
        this.subject.put("русский язык", subject[1]);
        this.subject.put("физика", subject[2]);
        this.subject.put("география", subject[3]);
        this.subject.put("химия", subject[4]);
        this.subject.put("физкультура", subject[5]);
    }

    public ArrayList<String> getActivity() {
        return this.activity;
    }

    public void setActivity(ArrayList<String> activityArrayList) {
        this.activity = activityArrayList;
    }

    @Override
    public String toString() {
        return ("Класс: " + getGroup() + "\n" +
                "Фамилия: " + getSurname() + "\n" +
                "Имя: " + getName() + "\n" +
                "Пол: " + getGender() + "\n"
                + getSubject() + " Средний балл: " + getAvgBall(this.subject) + "\n"
                + getActivity());
    }
}
