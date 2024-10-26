package arrayCode.part05;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] getModifyArray(int length, int[][] updates) {
        int[] nums = new int[length];
        DiffArray diff = new DiffArray(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            diff.increment(i, j, val);
        }
        return diff.result();
    }

    int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        DiffArray answer = new DiffArray(nums);
        for (int[] booking : bookings) {
            //转成数组索引减一
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            answer.increment(i, j, val);
        }
        return answer.result();
    }

    boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1000];

        DiffArray diff = new DiffArray(nums);

        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            diff.increment(i, j, val);
        }

        int[] res = diff.result();
        for (int re : res) {
            if (re < capacity) return true;
        }
        return true;
    }

    //t = "ADOBECODEBANC", m = "ABC"
    public String minWindow(String t, String m) {

        //记录所需要字符出现次数
        Map<Character, Integer> need = new HashMap<>();

        //记录window中字符出现次数
        Map<Character, Integer> window = new HashMap<>();
        for (char c : m.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        //窗口中满足need数组条件的字符个数
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while (right < t.length()) {
            //c是将移入窗口的字符
            char c = t.charAt(right);
            //扩大窗口
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //判断左侧窗口是否要收缩
            while (valid == need.size()) {

                //在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                //d是将要移出窗口的字符
                char d = t.charAt(left);

                //缩小窗口
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;

                    //将window计数器减1
                    window.put(d, window.get(d) - 1);
                }

            }

        }

        //返回最小覆盖子串
        return len == Integer.MAX_VALUE ? " " : t.substring(start, start + len);

    }


}
