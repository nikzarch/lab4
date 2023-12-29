import characters.Feeling;
import characters.Julius;
import characters.Kid;
import environment.*;

public class Main {
    public static void main(String[] args) {
        Julius julius = new Julius();
        Kid kid = new Kid();
        Environment bedroom = new Environment("Спальня");
        Thing.Container glass = new Thing.Container("Стакан с водой", bedroom){
            @Override
            public void lay(){
                if (this.place == null) {
                    System.out.println(this.getName() + " стоит ");
                }else{
                    System.out.println(this.getName() + " стоит в " + this.place.getName());
                }
            }
        };
        Thing jaws = new Thing("Челюсти", bedroom);
        Thing glasses = new Thing("Очки", bedroom);
        Candy[] bag = {Candy.ROTFRONT, Candy.CHUPACHUPS, Candy.KREMKA};
        CandyBag candyBag = new CandyBag("Кулёк с карамельками", 2, bedroom);
        try {
            candyBag.fillUpWithCandies(bag);
        }catch (CandiesOutOfCandyBagException exc) {
            System.out.println(exc.getMessage());
        }

        bedroom.sound("грр-пс-пс", 1);
        julius.sleep();
        glass.lay();
        kid.see(glass);
        kid.take(jaws);
        kid.put(glass);
        glasses.lay();
        candyBag.lay();
        kid.see(candyBag);
        System.out.println(candyBag.toString());
        kid.take(candyBag, "чтобы отдать Карлсону");
        kid.take(candyBag.takeCandy(0)); // карман будет занят
        kid.feel(Feeling.SOMETHING_SHOULD_BE_HERE);
    }
}
