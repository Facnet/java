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
        subject.put(Subject.MATHEMATICS.getTranslate(), (byte) 0);
        subject.put(Subject.RUSSIANLANGUAGE.getTranslate(), (byte) 0);
        subject.put(Subject.PHYSICS.getTranslate(), (byte) 0);
        subject.put(Subject.GEOGRAPHY.getTranslate(), (byte) 0);
        subject.put(Subject.CHEMISTRY.getTranslate(), (byte) 0);
        subject.put(Subject.PHYSICALCULTURE.getTranslate(), (byte) 0);
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
        return this.group;
    }

    public void setGroup(byte group) throws Exception {
        checkFieldEntities("Класс", group);
        this.group = group;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) throws Exception {
        checkFieldEntities("Фамилия", surname);
        this.surname = surname;
    }

    public String getName() {
        return this.name;
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
        return this.subject;
    }

    public void setSubject(byte[] subject) throws Exception {
        checkFieldEntities("Оценка", subject);
        this.subject.put(Subject.MATHEMATICS.getTranslate(), subject[0]);
        this.subject.put(Subject.RUSSIANLANGUAGE.getTranslate(), subject[1]);
        this.subject.put(Subject.PHYSICS.getTranslate(), subject[2]);
        this.subject.put(Subject.GEOGRAPHY.getTranslate(), subject[3]);
        this.subject.put(Subject.CHEMISTRY.getTranslate(), subject[4]);
        this.subject.put(Subject.PHYSICALCULTURE.getTranslate(), subject[5]);
    }

    public ArrayList<String> getActivity() {
        return this.activity;
    }

    public void setActivity(ArrayList<String> activity) {
        this.activity = activity;
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
