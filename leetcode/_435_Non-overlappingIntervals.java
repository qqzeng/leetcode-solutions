/**
	refer: https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
			https://blog.csdn.net/yutianzuijin/article/details/78897604
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
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval intv1, Interval intv2) {
                return intv1.end - intv2.end;
            } 
        });
        int start = intervals[0].start;
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
	
	public int eraseOverlapIntervals2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval intv1, Interval intv2) {
                return intv1.start - intv2.start;
            } 
        });
        int last = 0;
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[last].end) {
                count++;
                if(intervals[i].end < intervals[last].end) last = i;
            } else {
                last = i;
            }
        }
        return count;
    }
}