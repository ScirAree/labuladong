package arrayCode.part05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    int[] getModifyArray(int length, int[][] updates) {
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

        //获得模式串信息
        for (char c : m.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        //窗口window中满足need数组条件的字符个数
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

    public boolean checkInclusion(String t, String m) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : m.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right <= m.length()) {

            char d = t.charAt(right);
            right++;

            if (need.containsKey(d)) {
                window.put(d, window.getOrDefault(d, 0) + 1);
                if (need.get(d).equals(window.get(d))) {
                    valid++;
                }
            }

            while (right - left >= m.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char e = t.charAt(left);
                left++;

                if (need.containsKey(e)) {
                    if (window.get(d).intValue() == need.get(d).intValue())
                        valid--;
                    window.put(d, window.get(d) - 1);

                }

            }

        }
        return false;


    }

    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size())
                    res.add(left);
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

    public int LengthOfLongestSubString(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        int left = 0, right = 0;
        int windowSum = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < nums.length) {
            windowSum += nums[right];
            right++;

            while (windowSum > target && left < right) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left);
            }

        }
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;


    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;
        int windowProduct = 1;
        while (right < nums.length) {
            k = windowProduct * nums[left];
            right++;
            while (left < right && windowProduct >= k) {
                windowProduct = windowProduct / nums[left];
                left++;
            }
            count += right - left;
        }
        return count;
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int windowOneCount = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right] == 1)
                windowOneCount++;
            right++;
            while (right - left - windowOneCount > k) {
                if (nums[left] == 1)
                    windowOneCount--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
