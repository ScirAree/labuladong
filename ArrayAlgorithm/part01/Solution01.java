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


public static void main(String[] args) {
    int[] nums = {1, 1, 2, 3, 3, 4};
    int newLength = removeDuplicates(nums);

    // 输出新数组的长度和内容
    System.out.println("新数组的长度: " + newLength);
    System.out.print("无重复的数组内容: ");
    for (int i = 0; i < newLength; i++) {
        System.out.print(nums[i] + " ");
    }


}
