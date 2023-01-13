package Task_one.Entities;

import Task_one.CustomExceptions.EntitiesFieldEmptyException;
import Task_one.CustomExceptions.EntitiesFieldOutOfBoundsException;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static Task_one.CustomUtilities.AvgBall.getAvgBall;
import static Task_one.CustomUtilities.CheckFieldEntities.*;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = -8306194194883677241L;
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

    public Student(byte grade, String surname, String name, String gender, byte[] subject, ArrayList<String> activity) throws EntitiesFieldOutOfBoundsException, EntitiesFieldEmptyException {
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

    public void setGroup(byte group) throws EntitiesFieldOutOfBoundsException {
        checkFieldEntities("Класс", group);
        this.group = group;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) throws EntitiesFieldEmptyException {
        checkFieldEntities("Фамилия", surname);
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws EntitiesFieldEmptyException {
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

    public void setSubject(byte[] subject) throws EntitiesFieldOutOfBoundsException {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return group == student.group
                && surname.equals(student.surname)
                && name.equals(student.name)
                && gender.equals(student.gender)
                && subject.equals(student.subject)
                && Objects.equals(activity, student.activity);
    }

    @Override
    public int hashCode() {
        return 31*Objects.hash(group, surname, name, gender, subject, activity);
    }
}
