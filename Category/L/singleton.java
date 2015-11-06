class Solution {
    static Solution s;
    private Solution(){
        
    }
    public static Solution getInstance() {
        // write your code here
        if(s == null){
            s = new Solution();
            return s;
        }else{
            return s;
        }
    }
}
// Thread Safe
public class Singleton {
    private static Singleton instance;
    private Singleton (){}

    public static synchronized Singleton getInstance() {
     if (instance == null) {
         instance = new Singleton();
     }
     return instance;
    }
}
// Thread Safe double checked
public static Singleton getSingleton() {
    if (instance == null) {                         //Single Checked
        synchronized (Singleton.class) {
            if (instance == null) {                 //Double Checked
                instance = new Singleton();
            }
        }
    }
    return instance ;
}

// Not lazy
public class Singleton{
    //类加载时就初始化
    private static final Singleton instance = new Singleton();
    
    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}

// Best
public final class Singleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static class SingletonLoader {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
        if (SingletonLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static Singleton getInstance() {
        return SingletonLoader.INSTANCE;
    }

    @SuppressWarnings("unused")
    private Singleton readResolve() {
        return SingletonLoader.INSTANCE;
    }
}
