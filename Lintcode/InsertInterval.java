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
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        int i = 0;
        for( ; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.end < newInterval.start){
                continue;
            }
            if(cur.start > newInterval.end){
                break;
            }
            
            newInterval.start = Math.min(cur.start, newInterval.start);
            newInterval.end = Math.max(cur.end, newInterval.end);
            intervals.remove(i); i--;
        }
        intervals.add(i, newInterval);
        return intervals;
    }
}
