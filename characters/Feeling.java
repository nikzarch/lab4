package characters;


public enum Feeling {
    SOMETHING_SHOULD_BE_HERE("что-то должно лежать здесь"),
    ITS_OK("всё хорошо");
    private final String name;

    Feeling(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " почувствовал, что " + this.name;
    }
}
