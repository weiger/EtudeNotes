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
