//[强化练习 数组双指针经典习题]

//删除有序数组中的重复项II
public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int slow = 0, fast = 0;
    int count = 0;
    while (fast < nums.length) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        } else if (slow < fast && count < 2) {
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
        count++;
        if (fast < nums.length && nums[fast] != nums[fast - 1]) {
            count = 0;
        }
    }
    return slow + 1;
}


//验证回文串
public static boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isLetterOrDigit(c)) {
            sb.append(Character.toLowerCase(c));
        }
    }
    s = sb.toString();
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}


//合并俩个有序数组
public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1;
    int p = nums1.length - 1;
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[p] = nums1[i];
            i--;
        } else {
            nums1[p] = nums2[j];
            j--;
        }
        p--;
    }
    while (j >= 0) {
        nums1[p] = nums2[j];
        j--;
        p--;
    }
}


public static void main(String[] args) {

}
