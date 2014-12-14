public class Solution {

    public static void main(String[] args) {
	CoffeeMachine cm = new CoffeeMachine();
	CoffeeMaker maker = new CoffeeMaker(cm);
	CoffeeDrinker drinker = new CoffeeDrinker(cm);
	new Thread(maker).start();
	new Thread(drinker).start();
    }
}

class CoffeeMachine {
    private int num;
    private boolean available = false;

    public synchronized void produce(String name, int i) {
	while (available) {
	    try {
		wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	available = true;
	num = i;
	System.out.println(name + " produces " + num + "th coffee.");
	notifyAll();
    }

    public synchronized void consumer(String name) {
	while (!available) {
	    try {
		wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	available = false;
	System.out.println(name + " consumes " + num + "th coffee");
	notifyAll();
    }
}

class CoffeeMaker implements Runnable {
    CoffeeMachine cm;

    CoffeeMaker(CoffeeMachine cm) {
	this.cm = cm;
    }

    public void produce(int i) {
	cm.produce("CoffeeMake", i);
	try {
	    Thread.sleep((long) (Math.random() * 1000));
	} catch (Exception e) {
	}
    }

    public void run() {
	for (int i = 0; i < 10; i++) {
	    produce(i);
	}
    }
}

class CoffeeDrinker implements Runnable {
    CoffeeMachine cm;

    CoffeeDrinker(CoffeeMachine cm) {
	this.cm = cm;
    }

    public void consume() {
	cm.consumer("CoffeeDrinker");
    }

    public void run() {
	for (int i = 0; i < 10; i++) {
	    consume();
	}
    }
}
