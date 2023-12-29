package environment;

import interfaces.Containable;
import interfaces.Layable;

import java.util.Objects;

public class Thing extends Essence implements Layable {
    protected Environment place;

    public Thing(String name) {
        super(name);
    }

    public Thing(String name, Environment place) {
        super(name);
        this.place = place;
    }
    public static class Container extends Thing implements Containable {
        private Thing content;

        public Container(String name, Environment place, Thing content) {
            super(name,place);
            this.content = content;
        }
        public Container(String name, Thing content) {
            super(name);
            this.content = content;
        }
        public Container(String name, Environment place) {
            super(name,place);
            this.content = null;
        }
        public Container(String name) {
            super(name);
            this.content = null;
        }


        @Override
        public void add(Thing thing) throws ContainerPutInContainerException{
            if (thing instanceof Thing.Container) throw new ContainerPutInContainerException("Нельзя класть контейнер в контейнер");
            if (this.content != null) {
                System.out.println(this.name + " полон");
            } else {
                this.content = thing;
                System.out.println(thing.getName() + " был положен в " + this.getName());
            }
        }

        @Override
        public void remove() {
            this.content = null;
        }

        public Thing getContent() {
            return this.content;
        }
        @Override
        public String toString(){
            return this.name + " с содержимым: " + this.content.getName();
        }
        @Override
        public boolean equals(Object obj) {
            if (this.hashCode() != obj.hashCode() || !(obj instanceof Container )) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Container container = (Container) obj;
            return Objects.equals(this.name, container.getName()) && Objects.equals(this.content, container.getContent());
        }

    }
    public void setPlace(Environment place) {
        this.place = place;
    }

    public Environment getPlace() {
        return this.place;
    }

    @Override
    public void lay() {
        if (this.place != null) {
            System.out.println(this.getName() + " лежит в " + this.place.getName());
        } else {
            System.out.println(this.getName() + " лежит");
        }
    }

    @Override
    public String toString() {
        return this.name + " в месте " + this.place.getName();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode() || !(obj instanceof Thing)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Thing thing = (Thing) obj;
        return Objects.equals(this.name, thing.getName()) && Objects.equals(this.place, thing.getPlace());
    }
}