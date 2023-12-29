package environment;

enum DayTime {

    MORNING("Начинало светать"),
    EVENING("Начинало темнеть");

    private final String name;

    DayTime(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
