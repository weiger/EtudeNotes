package Observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject{
    private List<Observer> observers;
    private double ibmPrice;
    private double applPrice;
    private double googPrice;

    public StockGrabber() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        int observerIdenx = observers.indexOf(o);
        System.out.println("Observer " + (observerIdenx + 1) + " deleted");
        observers.remove(observerIdenx);
    }

    @Override
    public void notifyObserver() {
        for (Observer e: observers) {
            e.update(ibmPrice, applPrice, googPrice);
        }
    }

    public void setIBMPrice(double newIBMPrice) {
        this.ibmPrice = newIBMPrice;
        notifyObserver();
    }

    public void setAAPLPrice(double newAAPLPrice) {
        this.applPrice = newAAPLPrice;
        notifyObserver();
    }

    public void setGOOGPrice(double newGOOGPrice) {
        this.googPrice = newGOOGPrice;
        notifyObserver();
    }
}
