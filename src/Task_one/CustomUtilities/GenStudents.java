package Task_one.CustomUtilities;

import Task_one.Entities.Student;

import java.util.ArrayList;
import java.util.Arrays;

import static Task_one.CustomUtilities.MathRandom.genRandom;

public class GenStudents {
    public static Student[] genStudent(int count) throws Exception {
        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
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
        //ArrayList<String> activity = new ArrayList<>();
        //activity.add("Java");
        //students[count - 1] = new Student((byte) 8, "Perfect", "Idol", "Ж", new byte[]{5, 5, 5, 5, 5, 5}, activity);

        return students;
    }

    public static byte[] genSubject() {
        return new byte[]{
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5)
        };
    }

    public static ArrayList<String> genActivity() {
        String[] activityArray = {
                "субботник",
                "олимпиада по математике",
                "благотворительный марафон на 10м"
        };
        byte count;
        byte random = (byte) genRandom(0, 10);
        if (random > 7) {
            count = 3;
        } else if (random > 4) {
            count = 1;
        } else {
            count = 0;
        }
        return new ArrayList<>(Arrays.asList(activityArray).subList(0, count));
    }
}
