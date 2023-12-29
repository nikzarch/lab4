package characters;

public enum Condition {

    SLEEPING("Спящий"),
    AWAKEN("Пробудившийся");

    private final String name;

    Condition(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}