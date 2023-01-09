package Task_one.CustomExceptions;

public class EntitiesFieldOutOfBoundsException extends Exception {

    private String field;
    private byte value;

    public EntitiesFieldOutOfBoundsException(String field, byte value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Поле " + this.field + " заполнено не правильно! Инфо: " + this.value;
    }
}
