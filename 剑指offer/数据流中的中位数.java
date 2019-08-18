import java.util.Comparator;
import java.util.PriorityQueue;

// 最小堆中所有元素都比最大堆中的元素大
public class Solution {
    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            return o2.compareTo(o1);
        }
    });
 
    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) { // 如果是偶数个，则最终应该添加到最小堆中
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {  // 如果是奇数个，则最终应该添加到最大堆中
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }
 
    public Double GetMedian() {   
        if(count==0)
            throw new RuntimeException("no available number!");
        double result;
       //总数为奇数时，大顶堆堆顶就是中位数
       if((count&1)==1)
            result=maxHeap.peek();
        else
            result=(minHeap.peek()+maxHeap.peek())/2.0;
        return result;
    }
}