package environment;

public enum Candy {

    ROTFRONT("Ротфронт"),
    KREMKA("Кремка"),
    CHUPACHUPS("Чупа-чупс");

    private final String name;

    Candy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}