//一个方法团灭nSum问题

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//twoSum问题
public static int[] twoSum(int[] nums, int target) {
    Arrays.sort(nums);
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        if (sum < target) {
            lo++;
        } else if (sum > target) {
            hi--;
        } else {
            return new int[]{nums[lo], nums[hi]};
        }
    }
    return new int[]{};
}


//nums 中可能有多对儿元素之和都等于 target，请你的算法返回所有和为 target 的元素对儿，
// 其中不能出现重复
public static List<List<Integer>> twoSumTarget(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        int left = nums[lo], right = nums[hi];
        if (sum < target) {
            while (lo < hi && left == nums[lo]) lo++;
        } else if (sum > target) {
            while (lo < hi && right == nums[hi]) hi--;
        } else {
            res.add(Arrays.asList(nums[lo], nums[hi]));
            while (lo < hi && left == nums[lo]) lo++;
            while (lo < hi && right == nums[hi]) hi--;
        }
    }
    return res;
}


public static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
    int lo = start, hi = nums.length - 1;
    List<List<Integer>> res = new ArrayList<>();
    while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        int left = nums[lo], right = nums[hi];
        if (sum > target) {
            while (lo < hi && left == nums[lo]) lo++;
        } else if (sum < target) {
            while (lo < hi && right == nums[hi]) hi++;
        } else {
            res.add(Arrays.asList(nums[lo], nums[hi]));
            while (lo < hi && left == nums[lo]) lo++;
            while (lo < hi && right == nums[hi]) hi--;
        }
    }
    return res;
}


//3Sum问题
public static List<List<Integer>> threeSum(int[] nums) {
    return threeSumTarget(nums, 0);
}

public static List<List<Integer>> threeSumTarget(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
        for (List<Integer> tuple : tuples) {
            tuple.add(nums[i]);
            res.add(tuple);
        }
        while (i < n - 1 && nums[i] == nums[i + 1]) i++;
    }
    return res;
}

public static List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = start; i < n; i++) {
        List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
        for (List<Integer> tuple : tuples) {
            tuple.add(nums[i]);
            res.add(tuple);
        }
        while (i < n - 1 && nums[i] == nums[i + 1]) i++;
    }
    return res;
}

//4Sum问题
public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        List<List<Integer>> triples = threeSumTarget(nums, i + 1, target - nums[i]);
        for (List<Integer> triple : triples) {
            triple.add(nums[i]);
            res.add(triple);
        }
        while (i < n - 1 && nums[i] == nums[i + 1]) i++;
    }
    return res;
}



public void main() {

}
