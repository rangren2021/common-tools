package com.study.common.server.utils.sort;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/29 11:57
 * @Version 1.0
 **/

public class SelectSort {

    private static int[] data = new int[]{123, 34, 13, 456, 456, 7457, 56, 7, 2, 23, 3, 45, 2};

    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    public static void sort(int[] numbers) {
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] <= numbers[k]) {
                    k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }

    public static void sort_m(int[] datas){
        int length = datas.length;
        int temp;
        for(int i = 0;i<length;i++){
            int sign = i;
            for(int j = i;j<length;j++){
                if(datas[j]<= datas[sign]){
                    sign = j;
                }
            }
            temp = datas[sign];
            datas[sign] = datas[i];
            datas[i] = temp;
        }
    }

    public static void main(String[] args) {


        sort_m(data);

        for (int item : data) {
            System.out.print(item + "  ");
        }
        System.out.println();
        System.out.println("-------------------");
    }

}
