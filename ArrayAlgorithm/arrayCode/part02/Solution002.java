//二维数组的花式遍历技巧

import java.util.LinkedList;
import java.util.List;

//顺逆时针旋转矩阵
//顺时针旋转图像
public static void rotate(int[][] matrix) {
    int n = matrix.length;
    //沿着正对角线镜像反转
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    //反转一维数组
    for (int[] row : matrix) {
        reverse(row);
    }
}


//反转一维数组
public static void reverse(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (j > i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
        i++;
    }
}


//逆时针旋转图像
public static void rotate2(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - 1; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - j - 1][n - i - 1];
            matrix[n - j - 1][n - i - 1] = temp;
        }
    }
    for (int[] row : matrix) {
        reverse(row);
    }
}


//螺旋矩阵
public static List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int upper_bound = 0, lower_bound = m - 1;
    int left_bound = 0, right_bound = n - 1;
    List<Integer> res = new LinkedList<>();
    while (res.size() < m * n) {
        if (upper_bound <= lower_bound) {
            for (int j = left_bound; j <= right_bound; j++) {
                res.add(matrix[upper_bound][j]);
            }
            upper_bound++;
        }
        if (left_bound <= right_bound) {
            for (int i = upper_bound; i <= lower_bound; i++) {
                res.add(matrix[i][right_bound]);
            }
            right_bound--;
        }
        if (upper_bound <= lower_bound) {
            for (int j = right_bound; j >= left_bound; j--) {
                res.add(matrix[lower_bound][j]);
            }
            lower_bound--;
        }
        if (left_bound <= right_bound) {
            for (int i = lower_bound; i <= upper_bound; i++) {
                res.add(matrix[i][left_bound]);
            }
            left_bound++;
        }
    }
    return res;
}


//生成螺旋矩阵
public static int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][];
    int upper_bound = 0, low_bound = n - 1;
    int left_bound = 0, right_bound = n - 1;
    int num = 1;
    while (num <= n * n) {
        if (upper_bound <= low_bound) {
            for (int i = left_bound; i < right_bound; i++) {
                matrix[upper_bound][i] = num++;
            }
            upper_bound++;
        }
        if (left_bound <= right_bound) {
            for (int j = upper_bound; j < low_bound; j++) {
                matrix[j][right_bound] = num++;
            }
            right_bound--;
        }
        if (upper_bound <= low_bound) {
            for (int i = right_bound; i >= left_bound; i--) {
                matrix[low_bound][i] = num++;
            }
            low_bound--;
        }
        if (left_bound <= right_bound) {
            for (int j = low_bound; j >= upper_bound; j--) {
                matrix[j][left_bound] = num++;
            }
            left_bound++;
        }
    }
    return matrix;
}


public static void main(String[] args) {


}