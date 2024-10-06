//二维数组的花式遍历技巧

//顺逆时针旋转矩阵
//旋转图像
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


public static void main(String[] args) {

}