package characters;

import java.util.Objects;

public final class Julius extends Person {
    public Julius() {
        super("Дядя Юлиус");
    }

    @Override
    public String toString() {
        return this.getName() + this.getCondition();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.hashCode() != obj.hashCode() || !(obj instanceof Julius julius)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equals(this.name, julius.getName()) && Objects.equals(this.cond, julius.getCondition());
    }
}