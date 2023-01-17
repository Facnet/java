package Task_one.Utilities;

import Task_one.Exceptions.EntitiesEmptyException;

public class CheckFieldEntities {
    public static void checkField(String field, String value) throws EntitiesEmptyException {
        switch (field) {
            case "Фамилия":
                if (value.equals("")) {
                    throw new EntitiesEmptyException("Фамилия не может быть пустым!");
                }
                break;
            case "Имя":
                if (value.equals("")) {
                    throw new EntitiesEmptyException("Имя не может быть пустым!");
                }
                break;
        }
    }

    public static void checkGroup(byte value) {
        if (value < 1 || value > 11) {
            throw new IndexOutOfBoundsException("Класс не может быть меньше одного или больше одиннадцати! Инфо: " + value);
        }
    }

    public static void checkMarks(byte[] value) {
        for (byte mark : value) {
            if (mark < 1 || mark > 5) {
                throw new IndexOutOfBoundsException("Оценка не может быть меньше одного или больше пяти! Инфо: " + mark);
            }
        }
    }
}
