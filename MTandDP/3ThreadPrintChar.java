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
//Method 3
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ConditionExample {

  private Lock lock = new ReentrantLock();

  private Condition conditionA = lock.newCondition();
  private Condition conditionB = lock.newCondition();
  private Condition conditionC = lock.newCondition();

  /** 当前线程的名字 */
  private char currentThreadName = 'A';

  private static final Logger logger = Logger
      .getLogger("my.thread.test.OrderPrintTest");

  public static void main(String[] args) {

    ConditionExample ce = new ConditionExample();

    ExecutorService service = Executors.newFixedThreadPool(3);
    service.execute(ce.new ThreadA());
    service.execute(ce.new ThreadB());
    service.execute(ce.new ThreadC());

    service.shutdown();
  }

  private class ThreadA implements Runnable {
    public void run() {

      for (int i = 0; i < 10; i++) {
        lock.lock();
        try {
          while (currentThreadName != 'A') {
            try {
              /*
               * 如果当前线程名字不是A，那么ThreadA就处理等待状态
               */
              conditionA.await();
            } catch (InterruptedException e) {
              logger.severe(e.getLocalizedMessage());
            }
          }

          /*
           * 打印出第几遍以及A信息
           */
          System.out.println(String.format("%d Time : ", i + 1));
          System.out.print("A");

          /*
           * 将当前线程名置为B， 然后通知ThreadB执行
           */
          currentThreadName = 'B';
          conditionB.signal();

        } finally {
          lock.unlock();
        }
      }
    }

  }

  private class ThreadB implements Runnable {
    public void run() {
      for (int i = 0; i < 10; i++) {
        lock.lock();
        try {
          while (currentThreadName != 'B') {
            try {
              /*
               * 如果当前线程名字不是B，那么ThreadB就处理等待状态
               */
              conditionB.await();
            } catch (InterruptedException e) {
              logger.severe(e.getLocalizedMessage());
            }
          }

          /*
           * 打印信息B
           */
          System.out.print("B");

          /*
           * 将当前线程值置为C 并通过ThreadC来执行
           */
          currentThreadName = 'C';
          conditionC.signal();

        } finally {
          lock.unlock();
        }
      }

    }

  }

  private class ThreadC implements Runnable {

    public void run() {
      for (int i = 0; i < 10; i++) {
        lock.lock();
        try {
          while (currentThreadName != 'C') {
            try {
              /*
               * 如果当前线程名字不是C，那么ThreadC就处理等待状态
               */
              conditionC.await();
            } catch (InterruptedException e) {
              logger.severe(e.getLocalizedMessage());
            }
          }

          /*
           * 打印信息C
           */
          System.out.print("C");
          System.out.println();

          /*
           * 将当前线程值置为A 并通过ThreadA来执行
           */
          currentThreadName = 'A';
          conditionA.signal();

        } finally {
          lock.unlock();
        }

      }
    }
  }
}
//Method 4
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoresExample {

    private Semaphore semaphoresA = new Semaphore(1);
    private Semaphore semaphoresB = new Semaphore(0);
    private Semaphore semaphoresC = new Semaphore(0);

    public static void main(String[] args) {
	SemaphoresExample example = new SemaphoresExample();
	ExecutorService service = Executors.newFixedThreadPool(3);

	service.execute(example.new RunnableA());
	service.execute(example.new RunnableB());
	service.execute(example.new RunnableC());

	service.shutdown();
    }

    private class RunnableA implements Runnable {

	public void run() {

	    for (int i = 0; i < 10; i++) {
		try {
		    semaphoresA.acquire();
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		System.out.println(String.format("第%d遍", i + 1));
		System.out.print("A");
		semaphoresB.release();

	    }
	}
    }

    private class RunnableB implements Runnable {

	public void run() {

	    for (int i = 0; i < 10; i++) {
		try {
		    semaphoresB.acquire();
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		System.out.print("B");
		semaphoresC.release();
	    }

	}
    }

    private class RunnableC implements Runnable {

	public void run() {

	    for (int i = 0; i < 10; i++) {
		try {
		    semaphoresC.acquire();
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		System.out.print("C");
		System.out.println();

		semaphoresA.release();
	    }
	}
    }
}
//Method 5
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

  private AtomicInteger sycValue = new AtomicInteger(0);

  private static final int MAX_SYC_VALUE = 3 * 10;

  public static void main(String[] args) {
    AtomicIntegerExample example = new AtomicIntegerExample();
    ExecutorService service = Executors.newFixedThreadPool(3);

    service.execute(example.new RunnableA());
    service.execute(example.new RunnableB());
    service.execute(example.new RunnableC());

    service.shutdown();
  }

  private class RunnableA implements Runnable {

    public void run() {

      while (sycValue.get() < MAX_SYC_VALUE) {
        if (sycValue.get() % 3 == 0) {
          System.out.println(String.format("第%d遍",
              sycValue.get() / 3 + 1));
          System.out.print("A");
          sycValue.getAndIncrement();
        }
      }

    }
  }

  private class RunnableB implements Runnable {

    public void run() {

      while (sycValue.get() < MAX_SYC_VALUE) {
        if (sycValue.get() % 3 == 1) {
          System.out.print("B");
          sycValue.getAndIncrement();
        }
      }

    }
  }

  private class RunnableC implements Runnable {

    public void run() {

      while (sycValue.get() < MAX_SYC_VALUE) {
        if (sycValue.get() % 3 == 2) {
          System.out.println("C");
          System.out.println();
          sycValue.getAndIncrement();
        }
      }

    }
  }
}
