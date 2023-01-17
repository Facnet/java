package Task_one.Entities;

import Task_one.Exceptions.EntitiesEmptyException;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static Task_one.Utilities.CheckFieldEntities.*;
import static Task_one.Utilities.StudentUtils.getAvgMark;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = -6551838513398849980L;
    // группу переделать, чтобы можно было вместе с буквой, например 6А
    private byte group;
    private String surname;
    private String name;
    private String gender;
    private HashMap<Subject, Byte> marks = new HashMap<>();
    private ArrayList<String> activity = new ArrayList<>();

    public Student(byte group, String surname, String name, String gender, byte[] marks, ArrayList<String> activity) throws EntitiesEmptyException {
        setGroup(group);
        setSurname(surname);
        setName(name);
        setGender(gender);
        setMarks(marks);
        setActivity(activity);
    }

    public byte getGroup() {
        return this.group;
    }

    public void setGroup(byte group) {
        checkGroup(group);
        this.group = group;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) throws EntitiesEmptyException {
        checkField("Фамилия", surname);
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws EntitiesEmptyException {
        checkField("Имя", name);
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HashMap<Subject, Byte> getMarks() {
        return this.marks;
    }

    public void setMarks(byte[] marks) {
        checkMarks(marks);
        this.marks.put(Subject.MATHEMATICS, marks[0]);
        this.marks.put(Subject.RUSSIAN_LANGUAGE, marks[1]);
        this.marks.put(Subject.PHYSICS, marks[2]);
        this.marks.put(Subject.GEOGRAPHY, marks[3]);
        this.marks.put(Subject.CHEMISTRY, marks[4]);
        this.marks.put(Subject.PHYSICAL_CULTURE, marks[5]);
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
                + getMarks() + " Средний балл: " + getAvgMark(this.marks) + "\n"
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
                && marks.equals(student.marks)
                && Objects.equals(activity, student.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, surname, name, gender, marks, activity);
    }
}
