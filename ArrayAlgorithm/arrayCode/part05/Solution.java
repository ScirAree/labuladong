package arrayCode.part05;

import java.util.*;

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
    String minWindow(String t, String m) {

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

    boolean checkInclusion(String t, String m) {
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

    List<Integer> findAnagrams(String s, String t) {
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

    int LengthOfLongestSubString(String s) {
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

    int minOperations(int[] nums, int x) {
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

    int numSubarrayProductLessThanK(int[] nums, int k) {
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

    int longestOnes(int[] nums, int k) {
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

    int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, right = 0;
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            right++;

            while (left < right && windowCount.size() > k) {
                char d = s.charAt(left);
                windowCount.put(d, windowCount.getOrDefault(d, 0) - 1);
                if (windowCount.get(d) == 0) {
                    windowCount.remove(d);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        // 统计窗口中每个字符的出现次数
        int[] windowCharCount = new int[26];
        // 记录窗口中字符的最多重复次数
        // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
        // 所以窗口大小减去 windowMaxCount 就是所需的替换次数
        int windowMaxCount = 0;
        // 记录结果长度
        int res = 0;

        // 开始滑动窗口模板
        while (right < s.length()) {
            // 扩大窗口
            windowCharCount[s.charAt(right) - 'A']++;
            windowMaxCount = Math.max(windowMaxCount, windowCharCount[s.charAt(right) - 'A']);
            right++;

            while (right - left - windowMaxCount > k) {
                // 缩小窗口
                windowCharCount[s.charAt(left) - 'A']--;
                left++;
                // 这里不用更新 windowMaxCount
                // 因为只有 windowMaxCount 变得更大的时候才可能获得更长的重复子串，才会更新 res
            }
            // 此时一定是一个合法的窗口
            res = Math.max(res, right - left);
        }
        return res;
    }

    boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> window = new TreeSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            // 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)
            // 查找略大于 nums[right] 的那个元素
            Integer ceiling = window.ceiling(nums[right]);
            if (ceiling != null && (long) ceiling - nums[right] <= t) {
                return true;
            }
            // 查找略小于 nums[right] 的那个元素
            Integer floor = window.floor(nums[right]);
            if (floor != null && (long) nums[right] - floor <= t) {
                return true;
            }

            // 扩大窗口
            window.add(nums[right]);
            right++;

            if (right - left > k) {
                // 缩小窗口
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }

    int longestSubstring(String s, int k) {
        int len = 0;
        for (int i = 1; i <= 26; i++) {
            len = Math.max(len, longestKLetterSubstr(s, k, i));
        }
        return len;
    }

    int longestKLetterSubstr(String s, int k, int count) {
        int res = 0;

        int left = 0, right = 0;

        int[] windowCount = new int[26];

        int windowUniqueCount = 0;

        int windowValidCount = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            if (windowCount[c - 'a'] == 0) {
                windowUniqueCount++;
            }

            windowCount[c - 'a']++;
            if (windowCount[c - 'a'] == k) {
                windowValidCount++;
            }
            right++;

            while (windowUniqueCount > count) {

                char d = s.charAt(left);
                if (windowCount[d - 'a'] == k) {
                    windowValidCount--;
                }
                windowCount[d - 'a']--;
                if (windowCount[d - 'a'] == 0) {
                    windowUniqueCount--;
                }
                left++;
            }
            if (windowValidCount == count) {
                res = Math.max(res, right - left);
            }
        }
        return res;
    }

}
