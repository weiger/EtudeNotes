
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();
        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();
    }

}

class Resource{
    private String name;
    private int count = 1;
    private boolean flag = false;
    public synchronized void set(String name){
        while(flag)
            try{wait();}catch(Exception e){};
        this.name = name + ": "+count++;
        System.out.println(Thread.currentThread().getName()+" Producer :" + this.name);
        flag = true;
        this.notifyAll();
    }
    public synchronized void out(){
        while(!flag)
            try{wait();}catch(Exception e){};
        System.out.println(Thread.currentThread().getName()+" Consumer :" + this.name);
        flag = false;
        this.notifyAll();
    }
}

class Producer implements Runnable{
    private Resource res;
    Producer(Resource res){
        this.res = res;
    }
    public void run(){
        while(true){
            res.set("Item");
        }
    }
}
class Consumer implements Runnable{
    private Resource res;
    Consumer(Resource res){
        this.res = res;
    }
    public void run(){
        while(true){
            res.out();
        }
    }
}
