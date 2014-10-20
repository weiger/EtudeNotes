//Method 1
public class SleepExample extends Thread {

    private static int currentCount = 0;

    public SleepExample(String name) {
        this.setName(name);
    }

    public void run() {
        while (currentCount < 50) {
            switch (currentCount % 3) {
                case 0:
                if ("A".equals(getName())) {
                    printAndIncrease();
                }
                break;
                case 1:
                if ("B".equals(getName())) {
                    printAndIncrease();
                }
                break;
                case 2:
                if ("C".equals(getName())) {
                    printAndIncrease();
                }
                break;
            }
        }

    }

    private void printAndIncrease() {
        System.out.print(getName());
    /*if ("C".equals(getName())) {
        System.out.println();
    }*/
    currentCount++;
}

    public static void main(String[] args) {
        new SleepExample("A").start();
        new SleepExample("B").start();
        new SleepExample("C").start();
    }

}
