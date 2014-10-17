import java.util.LinkedList;
import java.util.Queue;

public class Q3_7 {

    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));

        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());

        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));

        while (animals.size() != 0) {
            System.out.println(animals.dequeueAny().name());
        }

    }

}

class AnimalQueue {
    Queue<Dog> Dogs = new LinkedList<Dog>();
    Queue<Cat> Cats = new LinkedList<Cat>();
    private int order = 1;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog)
            Dogs.offer((Dog) a);
        else if (a instanceof Cat)
            Cats.offer((Cat) a);
    }

    public Animal dequeueAny() {
        if (Dogs.isEmpty())
            return dequeueCat();
        else if (Cats.isEmpty())
            return dequeueDog();
        if (Dogs.peek().isOrder(Cats.peek()))
            return dequeueDog();
        else
            return dequeueCat();
    }

    public Dog dequeueDog() {
        return Dogs.poll();
    }

    public Cat dequeueCat() {
        return Cats.poll();
    }

    public int size() {
        return Dogs.size() + Cats.size();
    }
}

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String name();

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOrder(Animal a) {
        return order < a.order;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    public String name() {
        return "Dog: " + name;
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    public String name() {
        return "Cat: " + name;
    }
}
