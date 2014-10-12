import java.util.ArrayList;
// 0 1 bag
public class KnapsackProblem {
    private Knapsack[] bags;
    private int totalWeight;
    private int n;
    private int[][] dp;
    private int bestRes;
    private ArrayList<Knapsack> solution;
    public KnapsackProblem(Knapsack[] bags,int totalWeight){
        this.bags = bags;
        this.totalWeight = totalWeight;
        this.n = bags.length;
        if(dp==null){
            dp = new int[n+1][totalWeight+1];
        }
    }
    public void solve(){
        System.out.println("The bags is ");
        for(Knapsack k:bags)
            System.out.print(k+" ");
        System.out.println("The total weight is " + totalWeight);
        for(int j=0;j<=totalWeight;j++){
            for(int i=0;i<=n;i++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else{
                    if(j<bags[i-1].getWeight()){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        int iweight = bags[i-1].getWeight();  
                        int ivalue = bags[i-1].getValue();  
                        dp[i][j] = Math.max(dp[i-1][j], ivalue + dp[i-1][j-iweight]);   
                    }
                }
            }
        }
        if(solution==null)
            solution = new ArrayList<Knapsack>();
        
        int tempWeight = totalWeight;  
        for (int i=n; i >= 1; i--) {  
            if (dp[i][tempWeight] > dp[i-1][tempWeight]) {  
                solution.add(bags[i-1]);  // bags[i-1] 表示第 i 个背包  
                tempWeight -= bags[i-1].getWeight();  
            }  
            if (tempWeight == 0) { break; }  
        }  
        bestRes = dp[n][totalWeight]; 
        
    }
    public int getBestValue() {   
        return bestRes;  
    } 
    public int[][] getBestValues() {  

        return dp;  
    }  
    public ArrayList<Knapsack> getBestSolution() {  
        return solution;  
    }
    public static void main(String[] args) {
        Knapsack[] bags = new Knapsack[] {  
            new Knapsack(2,13), new Knapsack(1,10),  
            new Knapsack(3,24), new Knapsack(2,15),  
            new Knapsack(4,28), new Knapsack(5,33),  
            new Knapsack(3,20), new Knapsack(1, 8)  
        };  
        int totalWeight = 12;  
        KnapsackProblem kp = new KnapsackProblem(bags, totalWeight);  
        
        kp.solve();  
        System.out.println("BestRes：" + kp.getBestValue());   
        System.out.println("Solution: ");  
        System.out.println(kp.getBestSolution());  
        System.out.println("DP：");  
        int[][] bestValues = kp.getBestValues();  
        for (int i=0; i < bestValues.length; i++) {  
            for (int j=0; j < bestValues[i].length; j++) {  
                System.out.printf("%-5d", bestValues[i][j]);  
            }  
            System.out.println();  
        }  

    }
    

}
class Knapsack{
    private int weight;
    private int value;
    
    public Knapsack(int weight,int value){
        this.weight = weight;
        this.value = value;
    }
    public int getWeight(){
        return weight;
    }
    public int getValue(){
        return value;
    }
    public String toString(){
        return "[Weight:"+weight+" "+"Value:"+value+"]";
    }
}
