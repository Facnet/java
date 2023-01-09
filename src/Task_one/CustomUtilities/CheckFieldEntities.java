package Task_one.CustomUtilities;

import Task_one.CustomExceptions.EntitiesFieldEmptyException;
import Task_one.CustomExceptions.EntitiesFieldOutOfBoundsException;

public class CheckFieldEntities {
    public static void checkFieldEntities(String field, String value) throws Exception {
        switch (field) {
            case "Фамилия":
                if (value.equals("")) {
                    throw new EntitiesFieldEmptyException("Фамилия");
                }
                break;
            case "Имя":
                if (value.equals("")) {
                    throw new EntitiesFieldEmptyException("Имя");
                }
                break;
        }
    }

    public static void checkFieldEntities(String field, byte value) throws Exception {
        if (field.equals("Класс")) {
            if (value < 1 || value > 11) {
                throw new EntitiesFieldOutOfBoundsException("Класс", value);
            }
        }
    }

    public static void checkFieldEntities(String field, byte[] value) throws Exception {
        if (field.equals("Оценки")) {
            for (byte subject : value) {
                if (subject < 1 || subject > 5) {
                    throw new EntitiesFieldOutOfBoundsException("Оценка", subject);
                }
            }
        }
    }
}
