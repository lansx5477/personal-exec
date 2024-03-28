import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyinglan
 * @Date: 2023/05/31/9:48
 * @Description: 76.最小覆盖子串
 */
public class MinWindow {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = s.substring(1, s.length() - 1);


        String t = in.nextLine();
        String t1 = t.substring(1, t.length() - 1);

        String res = minWindow(s, t);
//        String res = minWindow(s1, t1);

        System.out.println(res);
    }

    public static String minWindow_2(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if (sLen <= 0 || tLen <= 0 || sLen < tLen) {
            return "";
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int[] tCnt = new int[128];
        int[] winCnt = new int[128];

        for (int i = 0; i < tLen; i++) {
            ++tCnt[tArray[i]];
        }

        // 定义 distance 为当前滑动窗口中含有distance个t中的字符
        // 如果滑动窗口中包含了t中的字符，且数量比该字符在t中的频率大，distance不变.
        int distance = 0;

        int minLeftBorder = -1;
        int minLen = sLen + 1;

        for (int l = 0, r = 0; r < sLen; ++r) {

            // 当前右边界字符在t中不存在，则跳过
            if (tCnt[sArray[r]] == 0) {
                ++winCnt[sArray[r]];
                continue;
            }

            if (winCnt[sArray[r]] < tCnt[sArray[r]]) {
                ++distance;
            }
            ++winCnt[sArray[r]];

            // 满足条件缩小左边界，尝试寻找满足条件的最小窗口
            while (distance == tLen) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minLeftBorder = l;
                }

                // 当前左边界字符在t中不存在，则跳过
                if (tCnt[sArray[l]] == 0) {
                    ++l;
                    --winCnt[sArray[l]];
                    continue;
                }

                if (winCnt[sArray[l]] == tCnt[sArray[l]]) {
                    --distance;
                }
                --winCnt[sArray[l]];
                ++l;
            }

        }
        return minLeftBorder == -1 ? "" : s.substring(minLeftBorder, minLeftBorder + minLen);
    }


    public static String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) {
            return "";
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Map<Character, Integer> count = new HashMap<>(32);


        for (int i = 0; i < tLen; i++) {
            count.put(tArray[i], count.getOrDefault(tArray[i], 0) - 1);
        }
        int diff = count.size();

        int minLeftBorder = 0;
        int minLen = Integer.MAX_VALUE;

        // [l, r]
        int l = 0;
        int r = 0;
        while (r < sLen) {

            if (count.containsKey(sArray[r])) {
                if (count.get(sArray[r]) == -1) {
                    --diff;
                }
                count.put(sArray[r], count.getOrDefault(sArray[r], 0) + 1);
            }

            while (diff == 0 && l <= r) {

                if (r - l + 1 < minLen) {
                    minLeftBorder = l;
                    minLen = r - l + 1;
                }

                if (count.containsKey(sArray[l])) {
                    if (count.get(sArray[l]) ==  0) {
                        ++diff;
                    }
                    count.put(sArray[l], count.getOrDefault(sArray[l], 0) - 1);
                }
                ++l;
            }
            ++r;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minLeftBorder, minLeftBorder + minLen);
    }
}
