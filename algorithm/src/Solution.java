import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xiaoyinglan
 * @date 2023/5/29 09:43:57
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        /**
         * 优先队列中的每一个元素都是一个长度为2的一维数组，arr[0]存储元素值，arr[1]存储其索引
         */
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        int win_size = Math.min(n, k);
        for (int i = 0; i < win_size; i++) {
            pq.add(new int[]{nums[i], i});
        }

        if (n < k) {
            return new int[]{pq.peek()[0]};
        }

        int[] ans = new int[n-k+1];
        int win_max_idx = 0;
        ans[win_max_idx++] = pq.peek()[0];

        for (int l = 0, r = k; r < n; r++) {
            ++l;
            pq.add(new int[]{nums[r], r});
            while (pq.peek()[1] < l) {
                pq.poll();
            }
            ans[win_max_idx++] = pq.peek()[0];
        }

        return ans;
    }
}
