package Task_one.CustomUtilities;

import Task_one.Entities.Subject;

import static Task_one.CustomUtilities.MathRandom.genRandom;

public class GenSubjects {
    public static Subject genSubject() {
        try {
            byte[] bytes = new byte[]{
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5)
            };
            return new Subject(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
