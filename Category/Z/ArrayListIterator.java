public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{2,2,3,4}));
        list.add(Arrays.asList(new Integer[]{1,2,4}));
        list.add(Arrays.asList(new Integer[]{3,2}));
        System.out.println(list);

        Iterator it = new Iterator(list);
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
class Iterator{
    Queue<Pair> q;
    List<List<Integer>> list;
    Iterator(List<List<Integer>> list){
        this.list = list;
        q = new LinkedList<Pair>();
        for(int i = 0 ; i < list.size(); i++){
            q.offer(new Pair(i, 0));
        }
    }
    public boolean hasNext(){
        return q.size() != 0;
    }
    public int next(){
        Pair cur = q.poll();
        int val = list.get(cur.x).get(cur.y);
        if(cur.y + 1 < list.get(cur.x).size()){
            q.offer(new Pair(cur.x, cur.y + 1));
        }
        return val;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
