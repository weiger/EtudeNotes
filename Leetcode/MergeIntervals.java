// O(nlogn)
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0)
            return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        Interval prev = null;
        for(Interval cur: intervals){
            if (prev == null || cur.start > prev.end) {
                res.add(cur);
                prev = cur;
            } else {
                prev.end = Math.max(prev.end, cur.end);
            }
        }
        return res;
    }
}
// O(n^2) remove exists
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        for (int i = 1; i < intervals.size(); i++) {
            Interval trail = intervals.get(i - 1);
            Interval cur = intervals.get(i);
            if (cur.start > trail.end) {
                continue;
            }
            cur.start = Math.min(trail.start, cur.start);
            cur.end = Math.max(trail.end, cur.end);
            intervals.remove(i - 1);
            i--;
        }
        return intervals;
    }
}
