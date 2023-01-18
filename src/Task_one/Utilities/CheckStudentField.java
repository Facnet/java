package Task_one.Utilities;

import Task_one.Exceptions.StudentException;

public class CheckStudentField {
    public static void checkField(String field, String value) throws StudentException {
        if (value.equals("")) {
            throw new StudentException(field+" не может быть пустым!");
        }
    }

    public static void checkGroup(byte group) throws StudentException {
        if (group < 1 || group > 11) {
            throw new StudentException("Класс не может быть меньше одного или больше одиннадцати! Инфо: " + group);
        }
    }

    public static void checkMarks(byte[] value) throws StudentException {
        for (byte mark : value) {
            if (mark < 1 || mark > 5) {
                throw new StudentException("Оценка не может быть меньше одного или больше пяти! Инфо: " + mark);
            }
        }
    }
}
