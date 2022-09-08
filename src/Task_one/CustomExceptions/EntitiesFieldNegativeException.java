package Task_one.CustomExceptions;

public class EntitiesFieldNegativeException extends Exception {
    String nameEntity;
    String nameFieldEntity;
    int valueFieldEntity;

    public EntitiesFieldNegativeException(String nameEntity, String nameFieldEntity, int valueFieldEntity) {
        this.nameEntity = nameEntity;
        this.nameFieldEntity = nameFieldEntity;
        this.valueFieldEntity = valueFieldEntity;
    }

    @Override
    public String toString() {
        return (this.nameEntity + " не может быть меньше нуля! Инфо: " + this.nameFieldEntity + " " + this.valueFieldEntity);
    }
}
