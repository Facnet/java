package Task_one.CustomUtilities;

import Task_one.Entities.Student;

import static Task_one.CustomUtilities.GenActivities.genActivity;
import static Task_one.CustomUtilities.GenSubjects.genSubject;
import static Task_one.CustomUtilities.MathRandom.genRandom;

public class GenStudents {
    public static Student genStudent() {
        try {
            byte bSex;
            if (genRandom(0, 10) > 5) {
                bSex = 1;
            } else {
                bSex = 0;
            }
            return new Student((byte) (
                    genRandom(1, 11)),
                    "RandomSubject",
                    "WithActivity",
                    bSex,
                    genSubject(),
                    genActivity()
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
