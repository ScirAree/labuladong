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


public static void main(String[] args) {
    int[] nums = {1, 1, 2, 3, 3, 4};

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

