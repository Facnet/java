package Task_one.CustomUtilities;

import Task_one.Entities.Student;

import java.util.ArrayList;

import static Task_one.CustomUtilities.GenActivities.genActivity;
import static Task_one.CustomUtilities.GenSubjects.genSubject;
import static Task_one.CustomUtilities.MathRandom.genRandom;

public class GenStudents {
    public static Student[] genStudent(int count) throws Exception {
        Student[] students = new Student[count];
        for (int i = 0; i < count - 1; i++) {
            String gender;
            if (genRandom(0, 10) > 5) {
                gender = "М";
            } else {
                gender = "Ж";
            }
            students[i] = new Student(
                    (byte) (genRandom(1, 11)),
                    "RandomSubject",
                    "WithActivity",
                    gender,
                    genSubject(),
                    genActivity()
            );
        }
        ArrayList<String> activity = new ArrayList<>();
        activity.add("Java");
        students[count - 1] = new Student((byte) 8, "Perfect", "Idol", "Ж", new byte[]{5, 5, 5, 5, 5, 5}, activity);

        return students;
    }
}
