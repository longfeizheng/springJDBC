package com.merryyou.test.sort;

/**
 * Created on 2016/2/14 0014.
 * 冒泡排序
 * <p>
 * （1）基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 *
 * @author zlf
 * @since 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {
                49, 38, 65, 97, 76, 13
        };
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) { //a.length - 1  是因为最后一次不需要排序啦 所以 -1
            for (int j = 0; j < a.length - 1 - i; j++) { // a.length - 1 为了防止数组越界（下面比价是a[j] 与 a[j+1] 比较）- i 是之前几次排序 后面那几位已经不需要比较啦
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
