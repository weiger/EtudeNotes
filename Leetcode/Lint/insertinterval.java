/*
Given a non-overlapping interval list which is sorted by start point.

Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Example
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = intervals;
        res.add(newInterval);
        if(res.size()==1)
            return res;
        Collections.sort(intervals,new comp());
        
        for(int i=1;i<res.size();i++){
            Interval trail = res.get(i-1);
            Interval cur = res.get(i);
            if(cur.start>trail.end)
                continue;
            cur.start = Math.min(trail.start,cur.start);
            cur.end = Math.max(trail.end,cur.end);
            res.remove(i-1);
            i--;
        }
        return res;
    }
    class comp implements Comparator<Interval>{
        public int compare(Interval a,Interval b){
            return a.start - b.start;
        }
    }
}
