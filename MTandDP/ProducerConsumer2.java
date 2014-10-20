import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BetterProducerConsumerDemo {

    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();

        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();

    }

}

class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition pc = lock.newCondition();
    private Condition cc = lock.newCondition();
    public void set(String name) {
        lock.lock();
        try {
            while (flag)
                pc.await();
            this.name = name + ": " + count++;
            System.out.println(Thread.currentThread().getName() + " Producer :"
                + this.name);
            flag = true;
            cc.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void out() {
        lock.lock();
        try {
            while (!flag)
                cc.await();
            System.out.println(Thread.currentThread().getName() + " Consumer :"
                + this.name);
            flag = false;
            pc.signalAll();
        } catch (Exception e) {
        // TODO: handle exception
        } finally {
            lock.unlock();
        }

    }
}

class Producer implements Runnable {
    private Resource res;

    Producer(Resource res) {
        this.res = res;
    }

    public void run() {
        while (true) {
            res.set("Item");
        }
    }
}

class Consumer implements Runnable {
    private Resource res;

    Consumer(Resource res) {
        this.res = res;
    }

    public void run() {
        while (true) {
            res.out();
        }
    }
}
