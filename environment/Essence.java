package environment;

import java.util.Objects;

public abstract class Essence {
    protected String name;

    public Essence(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.hashCode() != obj.hashCode() || !(obj instanceof Essence essence)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equals(this.name, essence.getName());
    }

    public String getName() {
        return this.name;
    }
}