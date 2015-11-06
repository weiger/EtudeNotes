public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        for (; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.end < newInterval.start) continue;
            if (cur.start > newInterval.end) break; 
            newInterval.start = Math.min(newInterval.start, cur.start);
            newInterval.end = Math.max(newInterval.end, cur.end);
            intervals.remove(i);
            i--;
        }
        intervals.add(i, newInterval);
        return intervals;
    }
}
