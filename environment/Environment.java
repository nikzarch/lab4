package environment;

import java.util.Objects;

public class Environment {
    private final String name;
    private DayTime daytime;
    private Sound lastsound;

    {
        lastsound = new Sound("Тишина", 0);
        daytime = DayTime.MORNING;
        System.out.println(daytime);
    }

    public Environment(String name) {
        this.name = name;
    }

    public void changeTime() {
        if (this.daytime == DayTime.MORNING) {
            this.daytime = DayTime.EVENING;
        } else {
            this.daytime = DayTime.MORNING;
        }
        System.out.println(daytime);
    }

    public void sound(String sound, int volume) {
        this.lastsound = new Sound(sound, volume);
        System.out.println("В " + this.name + " звучал " + sound);
    }

    public String getLastSound() {
        return this.lastsound.toString();
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
        if (obj == null) {
            return false;
        }
        if (this.hashCode() != obj.hashCode() || !(obj instanceof Environment environment)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equals(this.name, environment.getName()) && Objects.equals(this.lastsound, environment.getLastSound());
    }

    private class Sound {
        private final String name;
        private final int volume;

        private Sound(String name, int volume) {
            this.name = name;
            this.volume = volume;
        }

        @Override
        public String toString() {
            return "звук " + this.name + " громкостью " + this.volume;
        }
    }
}