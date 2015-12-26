package Singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {
    private static Singleton instance = null;
    String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l", "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o", "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u", "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z",};
    private LinkedList<String> letterList = new LinkedList<>(Arrays.asList(scrabbleLetters));
    static boolean firstThread = true;

    private Singleton() {
    }

    // Put synchronized here works but could slow program down
    public static Singleton getInstance() {
        if (instance == null) {
            if (firstThread) {
                firstThread = false;
                Thread.currentThread();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    Collections.shuffle(instance.letterList);
                }
            }
        }
        return instance;
    }

    public LinkedList<String> getLetterList() {
        return instance.letterList;
    }

    public LinkedList<String> getTiles(int howManyTiles) {
        LinkedList<String> tileToSend = new LinkedList<>();
        for (int i = 0; i <= howManyTiles; i++) {
            tileToSend.add(instance.letterList.remove(0));
        }
        return tileToSend;
    }
}
