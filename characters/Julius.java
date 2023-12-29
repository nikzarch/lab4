package characters;

import environment.Thing;
import interfaces.Sleepable;

import java.util.Objects;

public final class Julius extends Person  {
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
        if (this.hashCode() != obj.hashCode() || !(obj instanceof Julius)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Julius julius = (Julius) obj;
        return Objects.equals(this.name, julius.getName()) && Objects.equals(this.cond, julius.getCondition());
    }
}