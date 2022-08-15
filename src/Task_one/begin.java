package Task_one;

import Task_one.Entities.Activity;
import Task_one.Entities.Student;
import Task_one.Entities.Subject;
import static Task_one.CustomUtilities.GenStudents.genStudent;
import static Task_one.CustomUtilities.GenActivities.genActivity;
import static Task_one.CustomUtilities.GenSubjects.genSubject;

public class begin {
    public static void main(String[] args) {

        try {
            //проверка на ввод данных
            //exercise_one();

            /*Student[] students = new Student[20];
            for (int i = 0; i < students.length; i++) {
                //students[i] = genStudent(false, true);
            }*/
            //ученики, у которых наивысший балл
            //exercise_three(students);
            Student student = new Student((byte) 1,"ФВа","ФЫВ",(byte)1, genSubject(), genActivity());
            System.out.println(student.toString());
            student = genStudent();
            System.out.println(student.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
//пакет utils


    static void exercise_one() {
       /* try {
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
            activity1.addActivityArrayList("субботник");
            activity1.addActivityArrayList("олимпиада по математике");
            activity1.addActivityArrayList("благотворительный марафон на 10м");
            student1.setoActivity(activity1);

            System.out.println(student1);
            System.out.println("----------------------------------");

            //Student student3 = genStudent(false, false);
            //Student student4 = genStudent(true, false);
            //Student student5 = genStudent(false, true);
            //Student student6 = genStudent(true, true);

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
        }*/
    }

    static void exercise_three(Student[] students) {
        /*try {
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
        }*/
    }
}
