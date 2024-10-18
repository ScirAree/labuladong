//[强化练习 数组双指针经典习题]

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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


//有序数组的平方
public static int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int i = 0, j = n - 1;
    int p = n - 1;
    int[] res = new int[n];
    while (i <= j) {
        if (Math.abs(nums[i]) > Math.abs(nums[j])) {
            res[p] = nums[i] * nums[i];
            i++;
        } else {
            res[p] = nums[j] * nums[j];
            j--;
        }
        p--;
    }
    return res;
}


//有序转化数组
public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int i = 0, j = nums.length - 1;
    int p = a > 0 ? nums.length - 1 : 0;
    int[] res = new int[nums.length];
    while (i <= j) {
        int v1 = f(nums[i], a, b, c);
        int v2 = f(nums[j], a, b, c);
        if (a > 0) {
            if (v1 > v2) {
                res[p--] = v1;
                i++;
            } else {
                res[p--] = v2;
                j--;
            }
        } else {
            if (v1 > v2) {
                res[p++] = v2;
                j--;
            } else {
                res[p++] = v1;
                i++;
            }
        }
    }
    return res;
}
public static int f(int x, int a, int b, int c) {
    return a * x * x + b * x + c;
}


//将矩阵按对角线排序
public static int[][] diagonalSort(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int diagonalId = i - j;
            diagonals.putIfAbsent(diagonalId, new ArrayList<>());
            diagonals.get(diagonalId).add(mat[i][j]);
        }
    }
    for (ArrayList<Integer> diagonal : diagonals.values()) {
        diagonal.sort(Collections.reverseOrder());
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            ArrayList<Integer> diagonal = diagonals.get(i - j);
            mat[i][j] = diagonal.removeLast();
        }
    }
    return mat;
}


//二维网格迁移
public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length, n = grid[0].length;
    int mn = m * n;
    k = k % mn;
    reverse(grid, mn - k, mn - 1);
    reverse(grid, 0, mn - k - 1);
    reverse(grid, 0, mn - 1);

    List<List<Integer>> res = new ArrayList<>();
    for (int[] row : grid) {
        List<Integer> rowList = new ArrayList<>();
        for (int e : row) {
            rowList.add(e);
        }
        res.add(rowList);
    }
    return res;
}

public static int get(int[][] grid, int index) {
    int n = grid[0].length;
    int i = index / n, j = index % n;
    return grid[i][j];
}

public static void set(int[][] grid, int index, int val) {
    int n = grid[0].length;
    int i = index / n, j = index % n;
    grid[i][j] = val;
}

public static void reverse(int[][] grid, int i, int j) {
    while (i < j) {
        int temp = get(grid, i);
        set(grid, i, get(grid, j));
        set(grid, j, temp);
        i++;
        j--;
    }
}


//转置矩阵
public static int[][] transpose(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] res = new int[n][m];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            res[j][i] = matrix[i][j];
        }
    }
    return res;
}
public static void main(String[] args) {

}
