package com.study.common.server.utils.sort;

/**
 * 快速排序简单实现
 *
 * @ClassName FastSort
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/13 10:14
 * @Version 1.0
 **/

public class FastSort {

    private static int[] data = new int[]{123, 34, 13, 456, 456, 7457, 56, 7, 2, 23, 3, 45, 2};

    public static void sort(int[] data, int start, int end) {
        int st = start;
        int en = end;
        int value = data[start];
        while (st < en) {
            while (st < en && data[st] <= data[en])
                en--;
            if (value > data[en]) {
                int temp = data[en];
                data[en] = value;
                data[st] = temp;
            }

            while (st < en && data[en] >= data[st])
                st++;
            if (value < data[st]) {
                int temp = data[st];
                data[st] = value;
                data[en] = temp;
            }
        }
        if (start < st) sort(data, start, st - 1);
        if (end > en) sort(data, en + 1, end);
    }

    /**
     * 快速排序
     *
     *  从数列中挑出一个元素，称为“基准”
     *  重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
     *  该基准是它的最后位置。这个称为分割（partition）操作。
     *  递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param numbers
     * @param start
     * @param end
     */
    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }

    public static void sort_m(int[] data, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int sign = data[start];
            int temp;
            do {
                while (data[i] < sign && i < end)
                    i++;
                while (data[j] > sign && j > start)
                    j--;
                if (i <= j) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    i++;
                    j--;
                }
            } while (i < j);
            if (i < end) {
                sort_m(data, i, end);
            }
            if (j > start) {
                sort_m(data, start, j);
            }
        }

    }


    public static void main(String[] args) {
//        sort(data, 0, data.length-1);
//        quickSort(data, 0, data.length - 1);
        sort_m(data, 0, data.length - 1);

        for (int item : data) {
            System.out.print(item + "  ");
        }
        System.out.println();
        System.out.println("-------------------");
    }
}
