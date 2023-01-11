package Task_one.Entities;

public enum Subject {
    MATHEMATICS("Математика"),
    RUSSIANLANGUAGE("Русский язык"),
    PHYSICS("Физика"),
    GEOGRAPHY("География"),
    CHEMISTRY("Химия"),
    PHYSICALCULTURE("Физкультура");
    private String translate;

    Subject(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return this.translate;
    }
}
