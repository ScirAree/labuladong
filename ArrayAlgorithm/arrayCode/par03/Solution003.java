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
        } else if (sum == target) {
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

public void main() {

}
