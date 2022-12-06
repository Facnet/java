package Task_one.CustomUtilities;

import static Task_one.CustomUtilities.MathRandom.genRandom;

public class GenSubjects {
    public static byte[] genSubject() {
        try {
            return new byte[]{
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5),
                    (byte) genRandom(1, 5)
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
