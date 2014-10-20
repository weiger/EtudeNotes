
public class SingleDemo {

    public static void main(String[] args) {
    // TODO Auto-generated method stub

    }

}
//hungry
class Single1 {
    private static final Single1 s = new Single1();
    private Single1(){};
    public static Single1 getInstance(){
        return s;
    }
}
//lazy
class Single2 {
    private static Single2 s = null;
    private Single2(){};
    public static Single2 getInstance(){
        if(s==null){
            synchronized(Single2.class){
                if(s==null)
                    s = new Single2();
            }   
        }
        return s;
    }
}
