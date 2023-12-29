package characters;

import environment.ContainerPutInContainerException;
import environment.Essence;
import environment.Thing;
import interfaces.CanPut;
import interfaces.Seeable;
import interfaces.Takeable;

import java.util.Objects;

public final class Kid extends Person implements Seeable, Takeable, CanPut {
    private Thing.Container pocket;
    private Essence observed;
    private Feeling lastFeeling;

    public Kid() {
        super("Малыш");
        this.pocket = new Thing.Container("Карман");
    }

    @Override
    public void take(Thing thing) {
        if (this.pocket.getContent() == null) {
            try {
                this.pocket.add(thing);
                System.out.println(this.getName() + " взял " + thing.getName());
            } catch (ContainerPutInContainerException exc) {
                System.out.println(exc.getMessage());
            }
        } else {
            System.out.println("Карман занят");
        }
    }

    public void take(Thing thing, String reason) {
        if (this.pocket.getContent() == null) {
            try {
                this.pocket.add(thing);
                System.out.println(this.getName() + " взял " + thing.getName() + " " + reason);
            } catch (ContainerPutInContainerException exc) {
                System.out.println(exc.getMessage());
            }
        } else {
            System.out.println("Карман полон");
        }

    }

    public void drop() {
        System.out.println(this.name + " выбросил из кармана " + this.pocket.getContent().getName());
        this.pocket.remove();
    }

    public void put(Thing.Container container) {
        try {
            container.add(this.pocket.getContent());
            System.out.println(this.name + " положил " + this.pocket.getContent().getName() + " в " + container.getName());
            this.pocket.remove();
        } catch (ContainerPutInContainerException exc) {
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void see(Essence essence) {
        this.observed = essence;
        System.out.println(this.name + " увидел " + essence.getName());
    }

    public Thing.Container getPocket() {
        return this.pocket;
    }

    public void feel(Feeling feeling){
        lastFeeling = feeling;
        System.out.println(this.name + feeling.toString());
    }
    @Override
    public int hashCode() {
        return super.hashCode() + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode() || !(obj instanceof Kid)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Kid kid = (Kid) obj;
        return Objects.equals(this.name, kid.getName()) && Objects.equals(this.pocket.getContent(), kid.pocket.getContent()) && Objects.equals(this.cond, kid.getPocket());
    }

    @Override
    public String toString() {
        return this.name + " c " + this.pocket.getName() + " в кармане, наблюдащий " + this.observed.getName();
    }
}