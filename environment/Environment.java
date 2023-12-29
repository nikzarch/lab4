package environment;

import java.util.Objects;

public class Environment {
    private String name;
    private DayTime daytime = DayTime.MORNING;
    private String lastsound;

    {
        System.out.println(daytime.toString());
    }

    public Environment(String name) {
        this.name = name;
    }

    private enum DayTime {

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

    public void changeTime() {
        if (this.daytime == DayTime.MORNING) {
            this.daytime = DayTime.EVENING;
            System.out.println(daytime.toString());
        } else {
            this.daytime = DayTime.MORNING;
            System.out.println(daytime.toString());
        }
    }

    public void sound(String sound) {
        System.out.println("В " + this.name + " звучал " + sound);
        this.lastsound = sound;
    }

    public String getLastSound() {
        return this.lastsound;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + ", время: " + this.daytime.toString() + ", последнее что звучало: " + this.lastsound;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode() || !(obj instanceof Environment)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Environment environment = (Environment) obj;
        return Objects.equals(this.name, environment.getName()) && Objects.equals(this.lastsound, environment.getLastSound());
    }
}