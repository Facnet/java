package Task_one;

import Task_one.CustomUtilities.AvgBall;
import Task_one.CustomUtilities.FindStudents;
import Task_one.Entities.Student;
import java.util.Scanner;

import static Task_one.CustomUtilities.GenStudents.genStudent;
import static Task_one.CustomUtilities.PrintStudents.printStidents;

public class begin {
    public static void main(String[] args) {
        try {
            //генерации учеников
            Student[] students = genStudent(100);

            //все ученики
            //printStidents(FindStudents.findStudent(students,"","", (byte) 0));

            //ученики, у которых наивысший балл
            //printStidents(AvgBall.getMaxAvgBall(students));
            //девочки, у которых пятёрка по математике
            //printStidents(FindStudents.findStudent(students,"Ж","математика", (byte) 5));
            //мальчики, у которых нет троек
            //printStidents(FindStudents.findStudent(students,"М","",(byte) -3));
            //все ученики из одной группы (группа вводится с клавиатуры)
            //printStidents(FindStudents.fromGroup(students, new Scanner(System.in).nextByte()));
            //всех круглых отличников, которые учатся в классе, выше 7.
            //printStidents(FindStudents.fromExcellentBeforeGroup(students, (byte) 7));
            //всех ударников(только 4 и 5), которые участвуют в каких-то активностях.
            //printStidents(FindStudents.fromExcellentWithActivity(students));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
