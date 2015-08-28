/*
Implement an iterator to flatten a 2d vector.
For example,
Given 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,2,3,4,5,6].
*/
public class Vector2D {
    int row;
    int col;
    List<List<Integer>> list;
    int size;
    public Vector2D(List<List<Integer>> vec2d) {
        this.list = vec2d;
        row = 0;
        col = 0;
        size = vec2d.size();
    }

    public int next() {
        int val = 0;
        if(col < list.get(row).size()){
            val = list.get(row).get(col++);
        }
        if(col == list.get(row).size()){
            row++;
            col = 0;
        }
        return val;
    }

    public boolean hasNext() {
        while(row < size && (list.get(row) == null || list.get(row).size() == 0)){
            row++;
        }
        return list != null && list.size() > 0 && row < size;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
