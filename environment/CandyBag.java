package environment;

public class CandyBag extends Thing {
    private final Candy[] content;
    private final int size;

    public CandyBag(String name, int size) {
        super(name);
        this.content = new Candy[size];
        this.size = size;
    }

    public CandyBag(String name, int size, Environment place) {
        super(name, place);
        this.content = new Candy[size];
        this.size = size;
    }

    public void fillUpWithCandies(Candy[] candies) throws CandiesOutOfCandyBagException {
        if (this.size >= 0) System.arraycopy(candies, 0, this.content, 0, this.size);
        if (candies.length > this.size) {
            StringBuilder message = new StringBuilder("Не влезли конфеты: ");
            for (int i = this.size; i < candies.length; i++) {
                message.append(candies[i].toString() + " ");
            }
            throw new CandiesOutOfCandyBagException(message.toString());
        }

    }

    public Thing takeCandy(int index) {
        Thing takenCandy = new Thing(content[index].toString());
        this.content[index] = null;
        return takenCandy;
    }

    public void putCandy(Candy candy) throws CandiesOutOfCandyBagException {
        boolean wasNotPut = true;
        for (int i = 0; i < this.content.length; i++) {
            if (this.content[i] == null) {
                this.content[i] = candy;
                wasNotPut = false;
                break;
            }
        }
        if (wasNotPut) throw new CandiesOutOfCandyBagException("Не влезла конфета: " + candy.toString());
    }

    public Candy[] getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(this.name + ", содержащий ");
        for (int i = 0; i < this.size; i++) {
            if (this.content[i] != null) {
                string.append(this.content[i].toString() + " ");
            }
        }
        return string.toString();
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
        if (this.hashCode() != obj.hashCode() || !(obj instanceof CandyBag candybag)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.name == candybag.getName() && this.content == candybag.getContent();
    }
}