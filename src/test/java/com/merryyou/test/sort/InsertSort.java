package com.merryyou.test.sort;

/**
 * Created on 2016/2/14 0014.
 * <p>
 * 直接插入排序
 *
 *（1）基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
 * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
 * @author zlf
 * @since 1.0
 */
public class InsertSort {
    public static int[] intArray = {57, 68, 59, 52};
    /*
     * 57, 68, 59, 52
     * i = 1 时 temp = 68  j = 0  intArray[j] = 57  68 > 57 不执行交换  跳出循环
     * i = 2 时 temp = 59  j = 1  intArray[j] = 68  68 > 57 不执行交换
     *
     */

    public static void main(String[] args) {
        int temp = 0;
        for (int i = 1; i < intArray.length; i++) {
            int j = i - 1;
            temp = intArray[i];
            for (; j >= 0 && temp < intArray[j]; j--) {
                intArray[j + 1] = intArray[j];
            }
            intArray[j + 1] = temp;
        }

        for (Integer inte : intArray) {
            System.out.print(inte+" ");
        }
    }
}
