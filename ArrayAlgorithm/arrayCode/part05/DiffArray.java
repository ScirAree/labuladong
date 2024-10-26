package arrayCode.part05;

class DiffArray {

    private final int[] diff;

    public DiffArray(int[] nums) {
        assert nums.length >= 0;
        diff = new int[nums.length];
        //构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    //给数组区间[i j] 加减 val
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) diff[j + 1] -= val;
    }

    //构造结果数组
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
