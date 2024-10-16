//双指针技巧秒杀七道数组题目
import linkedListCode.ListNode;


//删除有序数组中的重复项
public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    int slow = 0, fast = 1;
    while (fast < nums.length) {
        if (nums[fast] != nums[slow]) {
            slow++;
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast];
        }
        fast++;
    }
    // 数组长度为索引 + 1
    return slow + 1;
}


//删除排序链表中的重复元素
public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
        if (fast.val != slow.val) {
            slow.next = fast;
            slow = slow.next;
        }
        fast = fast.next;
    }
    slow.next = null;
    return head;
}


//移除元素
public static int removeElement(int[] nums, int val) {
    int fast = 0;
    int slow = 0;
    while (fast < nums.length) {
        if (nums[fast] != val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
}


//移动零
public static void moveZeros(int[] nums) {
    int p = removeElement(nums, 0);
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
}


//二分查找
public static int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else if (nums[mid] > target) right = mid - 1;
    }
    return -1;
}


//俩数之和
public static int[] towSun(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
            // 题目要求的索引是从 1 开始的
            return new int[]{left + 1, right + 1};
        } else if (sum < target) {
            // 让 sum 大一点
            left++;
        } else if (sum > target) {
            // 让 sum 小一点
            right--;
        }
    }
    return new int[]{-1, -1};
}


//反转数组
public static void reverseString(char[] s) {
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
    }
}


//回文串判断
public static boolean isPalindrome(String s) {
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


//最长回文串
public static String palindrome(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
    }
    return s.substring(l + 1, r);
}


public static String longestPalindrome(String s) {
    String res = "";
    for (int i = 0; i < s.length(); i++) {
        String s1 = palindrome(s, i, i);
        String s2 = palindrome(s, i, i + 1);
        res = res.length() > s1.length() ? res : s1;
        res = res.length() > s2.length() ? res : s2;
    }
    return res;
}


public static void main(String[] args) {
    int[] nums = {1, 1, 2, 3, 3, 4};
//    int[] num = towSun(nums,3);
//    for(int i = 0 ; i< num.length;i++){
//        System.out.println(num[i]);
//    }

    //删除有序数组中的重复项
//    int newLength = removeDuplicates(nums);
//
//    // 输出新数组的长度和内容
//    System.out.println("新数组的长度: " + newLength);
//    System.out.print("无重复的数组内容: ");
//    for (int i = 0; i < newLength; i++) {
//        System.out.print(nums[i] + " ");
//    }


}

