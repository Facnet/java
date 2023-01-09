package Task_one.CustomUtilities;

import Task_one.CustomExceptions.EntitiesFieldEmptyException;
import Task_one.CustomExceptions.EntitiesFieldOutOfBoundsException;

public class CheckFieldEntities {
    public static void checkFieldEntities(String field, String value) throws Exception {
        switch (field) {
            case "Фамилия":
                if (value.equals("")) {
                    throw new EntitiesFieldEmptyException("Фамилия не может быть пустым!");
                }
                break;
            case "Имя":
                if (value.equals("")) {
                    throw new EntitiesFieldEmptyException("Имя не может быть пустым!");
                }
                break;
        }
    }

    public static void checkFieldEntities(String field, byte value) throws Exception {
        if (field.equals("Класс")) {
            if (value < 1) {
                throw new EntitiesFieldOutOfBoundsException("Класс не может быть меньше одного! Инфо: " + value);
            }
            if (value > 11) {
                throw new EntitiesFieldOutOfBoundsException("Класс не может быть больше одиннадцати! Инфо: " + value);
            }
        }
    }

    public static void checkFieldEntities(String field, byte[] value) throws Exception {
        if (field.equals("Оценка")) {
            for (byte subject : value) {
                if (subject < 1) {
                    throw new EntitiesFieldOutOfBoundsException("Оценка не может быть меньше одного! Инфо: " + subject);
                }
                if (subject > 11) {
                    throw new EntitiesFieldOutOfBoundsException("Оценка не может быть больше пяти! Инфо: " + subject);
                }
            }
        }
    }
}
