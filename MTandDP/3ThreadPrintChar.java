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
//Method 2
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintThreadExample {

    public static void main(String[] args) {
        PrintThreadExample example = new PrintThreadExample();

        LetterPrinter letterPrinter = example.new LetterPrinter();

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(example.new PrintRunnable(letterPrinter, 'A'));
        service.execute(example.new PrintRunnable(letterPrinter, 'B'));
        service.execute(example.new PrintRunnable(letterPrinter, 'C'));

        service.shutdown();
    }

    private class LetterPrinter {
        private char letter = 'A';

        public void print() {
            System.out.print(letter);
        /*if ('C' == letter) {
        System.out.println();
    }*/
}

public void nextLetter() {
    switch (letter) {
        case 'A':
        letter = 'B';
        break;
        case 'B':
        letter = 'C';
        break;
        case 'C':
        letter = 'A';
        break;
    }
}

public char getLetter() {
    return letter;
}

}

private class PrintRunnable implements Runnable {

    private LetterPrinter letterPrinter = null;

    private char letter = ' ';

    public PrintRunnable(LetterPrinter letterPrinter, char letter) {
        this.letterPrinter = letterPrinter;
        this.letter = letter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (letterPrinter) {
                while (letter != letterPrinter.getLetter()) {
                    try {
                        letterPrinter.wait();
                    } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                letterPrinter.print();
                letterPrinter.nextLetter();
                letterPrinter.notifyAll();

            }
        }

    }

}

}
