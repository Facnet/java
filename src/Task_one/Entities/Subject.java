package Task_one.Entities;

public enum Subject {
    MATHEMATICS("Математика"),
    RUSSIAN_LANGUAGE("Русский язык"),
    PHYSICS("Физика"),
    GEOGRAPHY("География"),
    CHEMISTRY("Химия"),
    PHYSICAL_CULTURE("Физкультура");
    private String translate;

    Subject(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return this.translate;
    }

    @Override
    public String toString() {
        return getTranslate();
    }
}
