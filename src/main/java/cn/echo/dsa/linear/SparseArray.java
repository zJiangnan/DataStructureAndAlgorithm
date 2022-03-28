package cn.echo.dsa.linear;

/**
 * 稀疏数组
 * <p>
 * 将原始大量重复的二维数组存储为较小的二维数组
 * </p>
 *
 * @author pluto
 * @version 1.0
 * @createdate 2022/3/26
 * @see SparseArray
 **/
public class SparseArray {
    public static void main(String[] args) {
//        创建 11 * 11 的源二维数组
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

//        1、遍历二维数组，得到非0的个数
        int sum = 0;
        for (int[] row : array) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("获取有效数据个数：" + sum);

//        2、创建稀疏数组
        int[][] sparse = new int[sum + 1][3];
//        3、给稀疏数组第一行赋值
        sparse[0][0] = array.length;
        sparse[0][1] = array[0].length;
        sparse[0][2] = sum;
//        4、遍历源二维数组将非0数据存入到稀疏数组中
        int count = 1;      // 计数器，从第二行开始(第一行已经表示二维数组大小)
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    sparse[count][0] = i;
                    sparse[count][1] = j;
                    sparse[count][2] = array[i][j];
                    count++;
                }
            }
        }
        for (int[] row : sparse) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

//        稀疏数组 -> 二维数组
//        1、读取稀疏数组第一行，创建二维数组
        int[][] arr = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {       // 从第二行开始遍历，余下是有效数据个数
            arr[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
