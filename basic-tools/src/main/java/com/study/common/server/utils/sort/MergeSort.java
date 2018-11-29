package com.study.common.server.utils.sort;

/**
 * @ClassName MergeSort
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/29 17:13
 * @Version 1.0
 **/

public class MergeSort {

    private static int[] data = new int[]{123, 34, 13, 456, 456, 7457, 56, 7, 2, 23, 3, 45, 2};


    /**
     * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
     * 该算法采用经典的分治（divide-and-conquer）策略
     * （分治法将问题分(divide)成一些小的问题然后递归求解，
     * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
     */
    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    /**
     * -----------------------------------------------------------------
     * 以下是个人练习实现
     **/


    public static void sort_m(int[] datas) {
        int[] temp = new int[datas.length];
        sort_m(datas, 0, datas.length - 1, temp);

    }

    private static void sort_m(int[] datas, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort_m(datas, start, mid, temp);
            sort_m(datas, mid+1, end, temp);
            merge_m(datas, start, mid, end, temp);
        }
    }

    private static void merge_m(int[] datas, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= end) {
            if (datas[i] <= datas[j]) {
                temp[t++] = datas[i++];
            } else {
                temp[t++] = datas[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = datas[i++];
        }

        while (j <= end) {
            temp[t++] = datas[j++];
        }

        t = 0;
        while (start <= end) {
            datas[start++] = temp[t++];
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
