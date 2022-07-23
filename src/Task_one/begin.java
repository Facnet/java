package Task_one;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class begin {
    public static void main(String[] args) {
        /*
        Необходимо хранить данные по ученикам школы и их оценки.

        Дана структура данных:
        Класс
        Фамилия
        Имя
        Пол
        Оценки по предметам: математика, русский язык, физика, география, химия,
        физкультура.
        А также список участия в активностях олимпиадах, спортивных мероприятиях.

        Например:
        Класс: 7
        Фамилия: Иванов
        Имя: Сергей
        Пол: муж
        Оценки:
          математика:3,
          русский язык:4,
          физика:4,
          география:5,
          химия:3,
          физкультура:5.

        Мероприятия:
          субботник,
          олимпиада по математике,
          благотворительный марафон на 10м.

        Задачи:
        1) Добавить проверку на ввод данных(не может быть отрицательная оценка и т.д.)
        2) Написать метод для генерации учеников.
        3) Найти учеников, у которых наивысший балл.
        4) Найти девочек, у которых пятёрка по математике.
        5) Найти мальчиков, у которых нет троек.
        6) Найти всех учеников из одной группы(группа вводится с клавиатуры или в коде).
        7) Найти всех круглых отличников, которые учатся в классе, выше 7.
        8) Найти всех ударников(только 4 и 5), которые участвуют в каких-то активностях.*/

        try {
            //проверка на ввод данных
            //exercise_one();

            Student[] students = new Student[20];
            for (int i = 0; i < students.length; i++) {
                students[i] = genStudent(false, true);
            }
            //ученики, у которых наивысший балл
            //exercise_three(students);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    static Student genStudent(boolean subject, boolean activity) {
        try {
            String bSex;
            if ((0 + Math.random() * 10) > 5) {
                bSex = "муж";
            } else {
                bSex = "жен";
            }
            if (subject) {
                Student student = new Student((byte) (1 + Math.random() * 11), "Random",
                        "WithSubject", bSex, genSubject());
                return student;
            }
            if (activity) {
                Student student = new Student((byte) (1 + Math.random() * 11), "RandomSubject",
                        "WithActivity", bSex, genSubject(), genActivity());
                return student;
            }
            Student student = new Student((byte) (1 + Math.random() * 11), "Random",
                    "Bob", bSex);
            return student;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    static Subject genSubject() {
        try {
            byte[] bytes = new byte[]
                    {(byte) (1 + Math.random() * 5), (byte) (1 + Math.random() * 5), (byte) (1 + Math.random() * 5),
                            (byte) (1 + Math.random() * 5), (byte) (1 + Math.random() * 5), (byte) (1 + Math.random() * 5)};
            Subject subject = new Subject(bytes);
            return subject;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    static Activity genActivity() {
        try {
            String[] arrayactivity = {
                    "субботник",
                    "олимпиада по математике",
                    "благотворительный марафон на 10м"
            };
            Activity activity = new Activity();
            byte count;
            if (0 + (Math.random() * 10) > 5) {
                count = 2;
            } else {
                count = 3;
            }
            for (int i = 0; i < count; i++) {
                activity.setStringArrayList(arrayactivity[i]);
            }
            return activity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    static void exercise_one() {
        try {
            Student student1 = new Student((byte) 7, "Bogdan",
                    "Bob", "муж");
            //Student student2 = new Student((byte) 13,"Bogdan",
            //        "Bob", "муж");
            //Student student3 = new Student((byte) -13,"Bogdan",
            //        "Bob", "муж");

            Subject sSubject1 = new Subject();
            sSubject1.sethSubject("математика", (byte) 4);
            sSubject1.sethSubject("русский язык", (byte) 4);
            sSubject1.sethSubject("физика", (byte) 4);
            sSubject1.sethSubject("география", (byte) 4);
            sSubject1.sethSubject("химия", (byte) 4);
            sSubject1.sethSubject("физкультура", (byte) 4);
            //sSubject1.sethSubject("физкультура", (byte)-5);
            //sSubject1.sethSubject("физкультура", (byte)6);
            //sSubject1.sethSubject("информатика", (byte)4);
            student1.setoSubject(sSubject1);

            Activity activity1 = new Activity();
            activity1.setStringArrayList("субботник");
            activity1.setStringArrayList("олимпиада по математике");
            activity1.setStringArrayList("благотворительный марафон на 10м");
            student1.setoActivity(activity1);

            System.out.println(student1);
            System.out.println("----------------------------------");

            Student student3 = genStudent(false, false);
            Student student4 = genStudent(true, false);
            Student student5 = genStudent(false, true);
            Student student6 = genStudent(true, true);

            System.out.println(student3);
            System.out.println("----------------------------------");
            System.out.println(student4);
            System.out.println("----------------------------------");
            System.out.println(student5);
            System.out.println("----------------------------------");
            System.out.println(student6);
            System.out.println("----------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void exercise_three(Student[] students) {
        try {
            double maxball = students[0].getoSubject().getAvgball();
            for (int i = 1; i < students.length; i++) {
                if (maxball < students[i].getoSubject().getAvgball()) {
                    maxball = students[i].getoSubject().getAvgball();
                }
                //System.out.println(i + " " + students[i].getoSubject().getAvgball());
            }
            for (int i = 0; i < students.length; i++) {
                if (maxball == students[i].getoSubject().getAvgball()) {
                    System.out.println(students[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
