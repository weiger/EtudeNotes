package Strategy;

public class Dog extends Animal {
    public Dog() {
        super();
        setSound("Bark");
        flyingType = new CantFly();
    }
}
