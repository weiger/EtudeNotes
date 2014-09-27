/*
 * Given a collection of intervals, merge all overlapping intervals.

 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//Sort then merge
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null) return intervals;
        if(intervals.size()==0 || intervals.size()==1) return intervals;
        Collections.sort(intervals, new IntervalComparator());
        for(int i=1;i<intervals.size();i++){
            Interval trail = intervals.get(i-1);
            Interval cur = intervals.get(i);
            if(trail.end<cur.start) continue;
            cur.start = Math.min(cur.start,trail.start);
            cur.end = Math.max(cur.end,trail.end);
            intervals.remove(i-1);
            i--;
        }
        return intervals;
    }
    
}
class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval a,Interval b) {	
	return a.start - b.start;
    }
}
//same idea
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)
            return res;
        Collections.sort(intervals,new comp());
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for(Interval x:intervals){
            if(x.start>e){
                res.add(new Interval(s,e));
                s = x.start;
                e = x.end;
            }else{
                e = Math.max(e,x.end);
            }
        }
        res.add(new Interval(s,e));
        return res;
    }
    class comp implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
}

public clss MergeIntervals {
    public void quicksort(ArrayList<Interval> intervals, int low, int high) {
        if(low >= high)
            return ;
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(intervals.get(j).start <= intervals.get(high).start) {
                i++;
                swap(intervals, i, j);
            }
        }
        swap(intervals, i + 1, high);
        quicksort(intervals, low, i);
        quicksort(intervals, i + 1, high);
    }
    
    public void swap(ArrayList<Interval> intervals, int i, int j) {
        Interval temp = intervals.get(i);
        intervals.set(i, intervals.get(j));
        intervals.set(j, temp);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        quicksort(intervals, 0, intervals.size() - 1);
        for(int i = 0; i < intervals.size() - 1; i++) {
            while(i < intervals.size() - 1 && intervals.get(i).end >= intervals.get(i + 1).start) {
                if(intervals.get(i).end >= intervals.get(i + 1).start) {
                    intervals.get(i).start = Math.min(intervals.get(i).start, intervals.get(i + 1).start);
                    intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                    intervals.remove(i + 1);
                }
            }
        }
        return intervals;
    }    
}
