package Task_one.CustomUtilities;

public class CheckFieldEntities {
    public static void checkFieldEntities(String field, String value) throws Exception {
        switch (field) {
            case "Фамилия":
                if(value.equals("")) {
                    throw new Exception("Фамилия не может быть пустым!");
                }
                break;
            case "Имя":
                if(value.equals("")) {
                    throw new Exception("Имя не может быть пустым!");
                }
                break;
        }
    }

    public static void checkFieldEntities(String field, byte value) throws Exception {
        if ("Класс".equals(field)) {
            if (value < 1) {
                throw new Exception("Класс не может быть меньше одного! Инфо: " + value);
            }
            if (value > 11) {
                throw new Exception("Класс не может быть больше одиннадцати! Инфо: " + value);
            }
        }
    }
    public static void checkFieldEntities(String field, byte[] value) throws Exception {
        if ("Оценки".equals(field)) {
            for (byte b : value) {
                if (b < 1) {
                    throw new Exception("Оценка не может быть меньше одного! Инфо: " + b);
                }
                if (b > 11) {
                    throw new Exception("Оценка не может быть больше пяти! Инфо: " + b);
                }
            }
        }
    }
}
