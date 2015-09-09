public class Calculator {
    private int a;
    private int b;

    public Calculator(){

    }

    public int add(){
        return a + b;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.b = b;
    }

    public int add(int a, int b){
        return a + b;
    }
}
