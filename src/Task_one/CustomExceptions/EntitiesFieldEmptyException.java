package Task_one.CustomExceptions;

public class EntitiesFieldEmptyException extends Exception {
    private String field;

    public EntitiesFieldEmptyException(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Поле " + this.field + " не может быть пустым!";
    }
}
